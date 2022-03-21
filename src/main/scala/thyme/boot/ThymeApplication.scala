package thyme.boot

import com.sun.net.httpserver.{HttpExchange, HttpServer}
import thyme.boot.ServerRegister.httpServer
import thyme.boot.ThymeApplication.{res, setResponseHeader}
import thyme.request.Route
import thyme.response.{Complete, ContentType}
import thyme.route.RouteTree

import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import scala.collection.mutable

private class ThymeApplication {

  private[thyme] val httpServer: HttpServer = HttpServer.create()

  private[thyme] val routeMap: mutable.HashMap[String, String] = mutable.HashMap.empty

  def mount(routes: Seq[Route]): ThymeApplication = {
    routes.foreach(route => RouteTree.buildRoute(route.path.result(), route.handle))
    this
  }

  def mount(route: Route): ThymeApplication = {
    RouteTree.buildRoute(route.path.result(), route.handle)
    this
  }

  def run(port: Int = 8080, backlog: Int = 7): Unit = {
    this.httpServer.createContext("/", (httpExchange: HttpExchange) => {
      val path = httpExchange.getRequestURI.getPath
      val route = RouteTree.matchRoute(path)
      // path don't match any node in routeTree
      if (route == null) {
        res(httpExchange, 404, "Not Found")
      } else {
        val complete: Complete = route.handle(httpExchange)
        setResponseHeader(httpExchange, ("Content-Type", complete.entity.contentType.contentType))
        res(httpExchange, complete.statusCode, complete.entity.responseBody)
      }
    })
    this.httpServer.bind(new InetSocketAddress(port), backlog)
    this.httpServer.start()
  }
}

object ThymeApplication {

  def create(): ThymeApplication = {
    new ThymeApplication
  }

  private def res(httpExchange: HttpExchange, statusCode: Int, responseBody: String): Unit = {
    httpExchange.sendResponseHeaders(statusCode, responseBody.length)
    httpExchange.getResponseBody.write(responseBody.getBytes(StandardCharsets.UTF_8))
    httpExchange.getResponseBody.flush()
    httpExchange.getResponseBody.close()
  }

  //side effect
  private def setResponseHeader(httpExchange: HttpExchange, keyValueTuples: (String, String)*): Unit = {
    keyValueTuples.foreach(keyValueTuple =>
      httpExchange.getResponseHeaders.add(keyValueTuple._1, keyValueTuple._2)
    )
  }

}
