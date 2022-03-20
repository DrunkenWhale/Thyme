package thyme.boot

import com.sun.net.httpserver.{HttpExchange, HttpServer}
import thyme.boot.ServerRegister.httpServer
import thyme.request.Route
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
  
}
