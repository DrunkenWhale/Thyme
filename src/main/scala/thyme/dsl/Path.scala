package thyme.dsl

import thyme.request.Node

object Path {

  extension (self: Node) {
    def ~(routes: Node*): Seq[Node] = {
      routes.appended(self)
    }
    def ~(route: Node): Seq[Node] = {
      Seq(route, self)
    }
  }

  extension (self: Seq[Node]) {
    def ~(routes: Seq[Node]): Seq[Node] = {
      routes.appendedAll(self)
    }
    def ~(route: Node): Seq[Node] = {
      self.appended(route)
    }
  }

  def path(path: String)(routes: Seq[Node]): Seq[Node] = {
    routes.foreach(route => route.path.insert(0, path))
    routes
  }

  def path(path: String)(route: Node): Node = {
    route.path.insert(0, path)
    route
  }

}
