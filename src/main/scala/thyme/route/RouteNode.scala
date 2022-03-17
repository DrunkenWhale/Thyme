package thyme.route

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.Complete

import scala.collection.mutable

case class RouteNode(matchedPath: String,
                     children: mutable.HashMap[String, RouteNode],
                     var handler: HttpExchange => Complete | Null = null)


object RouteNode {

}