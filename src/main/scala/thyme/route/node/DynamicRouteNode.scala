package thyme.route.node

import com.sun.net.httpserver.HttpExchange
import thyme.response.Complete
import thyme.route.node.RouteNode

import scala.collection.mutable

final case class DynamicRouteNode(
                                     paramName: String,
                                     override val matchedPath: String,
                                     override val children: mutable.HashMap[String, RouteNode] = mutable.HashMap.empty,
                                     override val handlers: mutable.HashMap[String, HttpExchange => Complete] = mutable.HashMap.empty
                                 ) extends RouteNode
