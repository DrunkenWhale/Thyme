package thyme.route

import com.sun.net.httpserver.HttpExchange
import thyme.response.Complete

import scala.annotation.tailrec
import scala.collection.mutable

object RouteTree {

  private[thyme] val rootRouteNode = RouteNode("", mutable.HashMap.empty)

  def buildRoute(path: String, handler: HttpExchange => Complete): Unit = {
    if (!path.startsWith("/")) {
      throw new IllegalArgumentException("path must start with '/'")
    }
    if (path == "/") {
      RouteTree.rootRouteNode.handle = handler
    } else {
      buildRouteImpl(RouteTree.rootRouteNode, path.split("/").toList.tail)(using handler)
    }
  }


  @tailrec
  private def buildRouteImpl(currentNode: RouteNode, routeNodePathList: List[String])(using handler: HttpExchange => Complete): Unit = {

    if (routeNodePathList.isEmpty) {
      currentNode.handle = handler
      return
    }

    val currentNodePath: String = {
      val path = routeNodePathList.head
      if (path.startsWith(":")) {
        ":"
      } else {
        path
      }
    }
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
      if (currentNode.handle != null) {
        return currentNode
      }
      else {
        return null
      }
    }
    val path = routeNodePathList.head
    val currentNodePath = if (path.startsWith(":")) {
      ":"
    } else {
      path
    }
    if (currentNode.children.contains(currentNodePath)) {
      matchRouteImpl(currentNode.children(routeNodePathList.head), routeNodePathList.tail)
    } else {
      null
    }
  }
}
