package thyme.route

import thyme.dsl.Complete
import com.sun.net.httpserver.HttpExchange

import scala.annotation.tailrec
import scala.collection.mutable

case class RouteNode(
                        matchedPath: String,
                        children: mutable.HashMap[String, RouteNode],
                        var handler: HttpExchange => Complete = null
                    )


object RouteNode {

  def buildRoute(path: String, handler: HttpExchange => Complete): Unit = {
    buildRouteImpl(RouteTree.rootRouteNode, path.split("/").toList)(using handler: HttpExchange => Complete)
  }

  @tailrec
  def buildRouteImpl(currentNode: RouteNode, routeNodePathList: List[String])(using handler: HttpExchange => Complete): Unit = {
    val isNextNodeExist: Boolean = routeNodePathList.size == 1
    val currentNodePath = routeNodePathList.head
    if (isNextNodeExist) {
      if (currentNode.children.contains(currentNodePath)) {
        buildRouteImpl(currentNode.children(currentNodePath), routeNodePathList.tail)
      } else {
        currentNode.children.put(currentNodePath, RouteNode(currentNode.matchedPath + '/' + currentNodePath, mutable.HashMap.empty))
      }
    } else {
      if (currentNode.children.contains(currentNodePath)) {
        currentNode.children(currentNodePath).handler = handler
      } else {
        currentNode.children.put(currentNodePath, RouteNode(currentNode.matchedPath + '/' + currentNodePath, mutable.HashMap.empty))
      }
    }
  }

  def matchRoute(path: String): Unit = {
    val routeNodePathList = path.split("/")
    matchRouteImpl(RouteTree.rootRouteNode, routeNodePathList.toList)
  }

  @tailrec
  def matchRouteImpl(currentNode: RouteNode, routeNodePathList: List[String]): RouteNode = {
    if (routeNodePathList.isEmpty) {
      return currentNode
    }
    if (currentNode.children.contains(routeNodePathList.head)) {
      matchRouteImpl(currentNode.children(routeNodePathList.head), routeNodePathList.tail)
    } else {
      null
    }
  }

}