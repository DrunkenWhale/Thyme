package thyme.route

import scala.collection.mutable

object RouteTree {
  private[thyme] val rootRouteNode = RouteNode("", mutable.HashMap.empty)
}
