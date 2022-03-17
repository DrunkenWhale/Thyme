package thyme.route

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.Complete

import scala.annotation.tailrec
import scala.collection.mutable

object RouteTree {

  def main(args: Array[String]): Unit = {
    buildRoute("/api/route/c/", (httpExchange: HttpExchange) => Complete("114"))
    buildRoute("/api/route/c/a", (httpExchange: HttpExchange) => Complete("114"))
    buildRoute("/api/route/c/da", (httpExchange: HttpExchange) => Complete("114"))
    buildRoute("/api/route", (httpExchange: HttpExchange) => Complete("114"))
    buildRoute("/", (httpExchange: HttpExchange) => Complete("114"))
    buildRoute("/aca/abc", (httpExchange: HttpExchange) => Complete("114"))
    println(matchRoute("/api/route/c/"))
    println(matchRoute("/api/route/c/a"))
    println(matchRoute("/api/route/c/da"))
    println(matchRoute("/api/route"))
    println(matchRoute("/aca"))
  }

  private[thyme] val rootRouteNode = RouteNode("", mutable.HashMap.empty)

  def buildRoute(path: String, handler: HttpExchange => Complete): Unit = {
    if (!path.startsWith("/")) {
      throw new IllegalArgumentException("path must start with '/'")
    }
    if (path == "/") {
      RouteTree.rootRouteNode.handler = handler
    } else {
      buildRouteImpl(RouteTree.rootRouteNode, path.split("/").toList.tail)(using handler)
    }
  }
}

@tailrec
private def buildRouteImpl(currentNode: RouteNode, routeNodePathList: List[String])(using handler: HttpExchange => Complete): Unit = {

  if (routeNodePathList.isEmpty) {
    currentNode.handler = handler
    return
  }

  val currentNodePath: String = routeNodePathList.head

  val childrenNodeOpt = currentNode.children.get(currentNodePath)

  if (childrenNodeOpt.isDefined) {

    val childrenNode = childrenNodeOpt.get
    buildRouteImpl(childrenNode, routeNodePathList.tail)

  } else {

    val childrenNode = RouteNode(currentNode.matchedPath + "/" + currentNodePath, mutable.HashMap.empty)
    currentNode.children.put(currentNodePath, childrenNode)
    buildRouteImpl(childrenNode, routeNodePathList.tail)

  }
}

def matchRoute(path: String): RouteNode = {
  if (!path.startsWith("/")) {
    throw new IllegalArgumentException("path must start with '/'")
  }
  if (path == "/") {
    RouteTree.rootRouteNode
  }
  else {
    val routeNodePathList = path.split("/")
    matchRouteImpl(RouteTree.rootRouteNode, routeNodePathList.toList.tail)
  }
}

@tailrec
private def matchRouteImpl(currentNode: RouteNode, routeNodePathList: List[String]): RouteNode = {

  if (routeNodePathList.isEmpty) {
    if (currentNode.handler != null) {
      return currentNode
    }
    else {
      return null
    }
  }

  if (currentNode.children.contains(routeNodePathList.head)) {
    matchRouteImpl(currentNode.children(routeNodePathList.head), routeNodePathList.tail)
  } else {
    null
  }
}
