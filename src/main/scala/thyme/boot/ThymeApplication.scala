package thyme.boot

import com.sun.net.httpserver.{HttpExchange, HttpServer}
import thyme.boot.ThymeApplication.{res, setResponseHeader}
import thyme.log.{BootLogger, RequestLogger}
import thyme.request.Node
import thyme.request.context.Extractor
import thyme.response.{Complete, ContentTypes}
import thyme.route.RouteTree

import concurrent.ExecutionContext.Implicits.global
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import scala.collection.mutable
import scala.concurrent.Future

private class ThymeApplication {

  private[thyme] val httpServer: HttpServer = HttpServer.create()

  def mount(routes: Seq[Node]): ThymeApplication = {

    BootLogger.logger("init route tree")

    routes.foreach(route => RouteTree.buildRoute(route.path.result(), route.method, route.handler))

    BootLogger.logger("finish route tree init")

    this
  }

  def mount(route: Node): ThymeApplication = {

    BootLogger.logger("init route tree")

    RouteTree.buildRoute(route.path.result(), route.method, route.handler)

    BootLogger.logger("finish route tree init")

    this
  }

  def run(port: Int = 8080, backlog: Int = 7): Unit = {

    BootLogger.logger("start http server")

    this.httpServer.createContext("/", (httpExchange: HttpExchange) => Future {
      val path = httpExchange.getRequestURI.getPath
      val (handlerOpt, dynamicRouteParamList, isMethodNotAllow) = RouteTree.matchRoute(path, httpExchange.getRequestMethod)
      // path don't match any node in routeTree
      if (handlerOpt.isEmpty) {
        if (isMethodNotAllow) {
          res(httpExchange, 405, "Method Not Allowed")
        } else {
          res(httpExchange, 404, "Not Found")
        }
      } else {

        //--------------lambda user define-------------------
        val complete: Complete = handlerOpt.get(Extractor.extractor(httpExchange, dynamicRouteParamList))
        //---------------------------------------------------

        setResponseHeader(httpExchange, ("Content-Type", complete.entity.contentType.toString))
        res(httpExchange, complete.statusCode, complete.entity.responseBody)
      }
    })
    this.httpServer.bind(new InetSocketAddress(port), backlog)

    BootLogger.logger(s"listen on port: $port")

    this.httpServer.start()
  }
}

object ThymeApplication {

  def create(): ThymeApplication = {

    BootLogger.logger("init http server ")

    new ThymeApplication

  }

  private def res(httpExchange: HttpExchange, statusCode: Int, responseBody: String): Unit = {
    // a string to a byte array
    // its length may be changed
    // for example: result contains chinese word
    val bs = responseBody.getBytes(StandardCharsets.UTF_8)
    httpExchange.sendResponseHeaders(statusCode, bs.length)
    httpExchange.getResponseBody.write(bs)
    httpExchange.getResponseBody.flush()
    httpExchange.getResponseBody.close()
    RequestLogger.logRequest(httpExchange.getRequestMethod, httpExchange.getRequestURI.getPath, statusCode)

  }

  //side effect
  private def setResponseHeader(httpExchange: HttpExchange, keyValueTuples: (String, String)*): Unit = {
    keyValueTuples.foreach(keyValueTuple =>
      httpExchange.getResponseHeaders.add(keyValueTuple._1, keyValueTuple._2)
    )
  }

}
