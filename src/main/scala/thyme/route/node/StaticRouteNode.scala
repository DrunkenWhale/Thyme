package thyme.route.node

import thyme.request.context.Context
import thyme.response.Complete
import thyme.route.node.RouteNode

import scala.collection.mutable

final case class StaticRouteNode(
                                    override val matchedPath: String,
                                    override val children: mutable.HashMap[String, RouteNode] = mutable.HashMap.empty,
                                    override val handlers: mutable.HashMap[String, Context => Complete] = mutable.HashMap.empty
                                ) extends RouteNode
