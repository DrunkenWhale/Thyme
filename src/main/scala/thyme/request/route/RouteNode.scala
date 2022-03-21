package thyme.request.route

import com.sun.net.httpserver.HttpExchange
import thyme.response.Complete

import scala.collection.mutable

case class RouteNode(matchedPath: String,
                     children: mutable.HashMap[String, RouteNode],
                     var handle: HttpExchange => Complete | Null = null)


object RouteNode {

}