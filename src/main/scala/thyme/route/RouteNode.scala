package thyme.route

import com.sun.net.httpserver.HttpExchange
import thyme.request.context.Context
import thyme.response.Complete

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
 * @param matchedPath : request url matched path until this route node
 * @param children    : this node's children nodes
 * @param handlers    : handlers map , Request Method String => Handler
 *                    (The Handler is a lambda which type is HttpExchange=>Complete)
 */

case class RouteNode(matchedPath: String,
                     children: mutable.HashMap[String, RouteNode],
                     handlers: mutable.HashMap[String, HttpExchange => Complete] = mutable.HashMap.empty)


object RouteNode {
}