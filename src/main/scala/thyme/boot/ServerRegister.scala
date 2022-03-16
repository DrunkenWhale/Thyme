package thyme.boot

import com.sun.net.httpserver.HttpServer

import java.net.InetSocketAddress

object ServerRegister {
 
  private[thyme] val httpServer: HttpServer = HttpServer.create()
 
  def mount(path:String): Unit ={
    httpServer.createContext(path)
  }
  
  def run(port: Int, backlog: Int): Unit = {
    httpServer.bind(new InetSocketAddress(port), backlog)
  }

  

}