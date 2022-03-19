package thyme.boot

import com.sun.net.httpserver.spi.HttpServerProvider
import com.sun.net.httpserver.{HttpExchange, HttpServer}
import thyme.request.Route
import thyme.response.{Complete, Entity}
import thyme.route.RouteTree
import thyme.request.Path.*
import thyme.request.Get.*
import thyme.request.ContextParam.*
import thyme.response.ContentType
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util
import java.util.concurrent.{Executor, Executors}
import scala.collection.mutable

class ServerRegister {

}


object ServerRegister {

  private[thyme] val httpServer: HttpServer = HttpServer.create()

  // path => server
  private[thyme] val routeMap: mutable.HashMap[String, String] = mutable.HashMap.empty

  def mount(path: String): Unit = {
    httpServer.createContext(path)
  }

  def run(port: Int, backlog: Int): Unit = {
    httpServer.bind(new InetSocketAddress(port), backlog)
    httpServer.start()
  }

  def bind(routes: Seq[Route]): Unit = {
    routes.foreach(route => RouteTree.buildRoute(route.path.result(), route.handle))
  }


  def main(args: Array[String]): Unit = {

    ServerRegister.bind(path("/api") {
      get(parameter("word")) { word =>
        Complete(200, Entity(ContentType.`application/xml`, s"Hello $word"))
      }
    } ~ path("/c/:name/b") {
      get { () =>
        Complete(200, Entity(ContentType.`application/xml`, s"Hello world"))
      }
    })

    // all handler will be register in root path
    ServerRegister.httpServer.createContext("/", (httpExchange: HttpExchange) => {
      //      val str = httpExchange.getRequestURI.getRawQuery
      val path = httpExchange.getRequestURI.getPath
      val route = RouteTree.matchRoute(path)
      if (route == null) {
        val resultString = "Not Found"
        httpExchange.sendResponseHeaders(404, resultString.length)
        httpExchange.getResponseBody.write(resultString.getBytes(StandardCharsets.UTF_8))
        httpExchange.getResponseBody.flush()
        httpExchange.getResponseBody.close()
      } else {
        val complete: Complete = route.handle(httpExchange)
        val resultString = complete.entity.responseBody
        val responseHeader = httpExchange.getResponseHeaders
        val contentTypeList = new util.LinkedList[String]()
        contentTypeList.add(complete.entity.contentType.contentType)
        responseHeader.put("Content-Type", contentTypeList)
        httpExchange.sendResponseHeaders(complete.statusCode, resultString.length)
        httpExchange.getResponseBody.write(resultString.getBytes(StandardCharsets.UTF_8))
        httpExchange.getResponseBody.flush()
        httpExchange.getResponseBody.close()
      }


    })
    ServerRegister.httpServer.setExecutor(Executors.newFixedThreadPool(10))
    ServerRegister.run(9090, 0)
  }
}

