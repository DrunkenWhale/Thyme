package boot

import com.sun.net.httpserver.{HttpExchange, HttpServer}

import java.io.ByteArrayInputStream
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets

class ServerRegister(port: Int, backlog: Int = 7) {
  val httpServer: HttpServer = HttpServer.create(new InetSocketAddress(port), backlog)

  httpServer.createContext("/api", (httpExchange: HttpExchange) => {
    val response = "Hello World"
    println(String(httpExchange.getRequestBody.readAllBytes()))
    httpExchange.sendResponseHeaders(200, response.length)
    httpExchange.getResponseBody.write(response.getBytes(StandardCharsets.UTF_8))
  })

  httpServer.start()
}
