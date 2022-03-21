package thyme.boot

import com.sun.net.httpserver.spi.HttpServerProvider
import com.sun.net.httpserver.{HttpExchange, HttpServer}
import thyme.request.Node
import thyme.response.{Complete, Entity}
import thyme.dsl.Path.*
import thyme.response.ContentType
import thyme.route.RouteTree

import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util
import java.util.concurrent.{Executor, Executors}
import scala.collection.mutable

private class ServerRegister {

}


object ServerRegister {

  private[thyme] val httpServer: HttpServer = HttpServer.create()

  private[thyme] val routeMap: mutable.HashMap[String, String] = mutable.HashMap.empty

  def run(port: Int, backlog: Int): Unit = {
    httpServer.bind(new InetSocketAddress(port), backlog)
    httpServer.start()
  }

  def bind(routes: Seq[Node]): Unit = {
    routes.foreach(route => RouteTree.buildRoute(route.path.result(), route.handle))
  }

  def bind(route: Node): Unit = {
    RouteTree.buildRoute(route.path.result(), route.handle)
  }

  // side effect
  private def res(httpExchange: HttpExchange, statusCode: Int, responseBody: String): Unit = {
    httpExchange.sendResponseHeaders(statusCode, responseBody.length)
    httpExchange.getResponseBody.write(responseBody.getBytes(StandardCharsets.UTF_8))
    httpExchange.getResponseBody.flush()
    httpExchange.getResponseBody.close()
  }


//  def main(args: Array[String]): Unit = {
//
//    ServerRegister.bind(path("/api") {
//      get(parameter("word")) { word =>
//        Complete(200, Entity(ContentType.`application/xml`, s"Hello $word"))
//      }
//    } ~ path("/c/:name/b") {
//      get { () =>
//        Complete(200, Entity(ContentType.`application/xml`, s"Hello world"))
//      }
//    }
//    )
//
//    // all handler will be register in root path
//    ServerRegister.httpServer.createContext("/", (httpExchange: HttpExchange) => {
//
//      val path = httpExchange.getRequestURI.getPath
//      val route = RouteTree.matchRoute(path)
//      // path don't match any node in routeTree
//      if (route == null) {
//        res(httpExchange, 404, "Not Found")
//      } else {
//        val complete: Complete = route.handle(httpExchange)
//        val responseHeader = httpExchange.getResponseHeaders
//        val contentTypeList = new util.LinkedList[String]()
//        contentTypeList.add(complete.entity.contentType.contentType)
//        responseHeader.put("Content-Type", contentTypeList)
//        res(httpExchange, complete.statusCode, complete.entity.responseBody)
//      }
//    })
//    ServerRegister.httpServer.setExecutor(Executors.newFixedThreadPool(10))
//    ServerRegister.run(9090, 0)
//  }
}

