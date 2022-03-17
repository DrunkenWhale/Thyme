package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.{Complete, Method}

object Route {
  def route(method: Method)(param:String)(path: String)(lambda: (String) => Complete) = {
    def l(httpExchange:HttpExchange)= {
      lambda(param)
    }
  }
}
