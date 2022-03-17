package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.Complete

object Path {

  extension (self: Route) {
    def ~(routes: Route*): Seq[Route] = {
      routes.appended(self)
    }
    def ~(route: Route): Seq[Route] = {
      Seq(route, self)
    }
  }

  extension (self: Seq[Route]) {
    def ~(routes: Seq[Route]): Seq[Route] = {
      routes.appendedAll(self)
    }
    def ~(route: Route): Seq[Route] = {
      self.appended(route)
    }
  }

  def path(path: String)(routes: Seq[Route]): Seq[Route] = {
    routes.foreach(route => route.path.insert(0, path))
    routes
  }

  def path(path: String)(route: Route): Route = {
    route.path.insert(0, path)
    route
  }
  
}
