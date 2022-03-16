package thyme.boot

import com.sun.net.httpserver.spi.HttpServerProvider
import com.sun.net.httpserver.{HttpExchange, HttpServer}

import java.net.InetSocketAddress
import java.util.concurrent.{Executor, Executors}

object ServerRegister {

  private[thyme] val httpServer: HttpServer = HttpServer.create()

  def mount(path: String): Unit = {
    httpServer.createContext(path)
  }

  def run(port: Int, backlog: Int): Unit = {
    httpServer.bind(new InetSocketAddress(port), backlog)
    httpServer.start()
  }


  def main(args: Array[String]): Unit = {
    ServerRegister.httpServer.createContext("/", (httpExchange:HttpExchange)=> {
      httpExchange.sendResponseHeaders(200, 7)
      httpExchange.getResponseBody.write("asbdsaq".getBytes())
      httpExchange.getResponseBody.close()

    })
    ServerRegister.httpServer.setExecutor(Executors.newFixedThreadPool(10))
    ServerRegister.run(9090,0)
  }
}

