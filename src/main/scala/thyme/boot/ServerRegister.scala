package thyme.boot

import com.sun.net.httpserver.spi.HttpServerProvider
import com.sun.net.httpserver.{HttpExchange, HttpServer}

import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util.concurrent.{Executor, Executors}
import scala.collection.mutable

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


  def main(args: Array[String]): Unit = {
    // all handler will be register in root path
    ServerRegister.httpServer.createContext("/", (httpExchange: HttpExchange) => {
      //      val str = httpExchange.getRequestURI.getRawQuery
      val path = httpExchange.getRequestURI.getPath


      httpExchange.sendResponseHeaders(200, path.length)
      httpExchange.getResponseBody.write(path.getBytes(StandardCharsets.UTF_8))
      httpExchange.getResponseBody.flush()
      httpExchange.getResponseBody.close()
    })
    ServerRegister.httpServer.setExecutor(Executors.newFixedThreadPool(10))
    ServerRegister.run(9090, 0)
  }
}

