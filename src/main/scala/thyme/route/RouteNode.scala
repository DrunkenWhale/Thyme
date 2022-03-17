package thyme.route

import thyme.dsl.Complete
import com.sun.net.httpserver.HttpExchange

import scala.annotation.tailrec
import scala.collection.mutable

case class RouteNode(
                        matchedPath: String,
                        children: mutable.HashMap[String, RouteNode],
                        var handler: HttpExchange => Complete | Null = null
                    )


object RouteNode {

  def main(args: Array[String]): Unit = {
    buildRoute("/api/route/c/", (httpExchange: HttpExchange) => Complete("114"))
    println(matchRoute("/api/route/c"))
  }

  def buildRoute(path: String, handler: HttpExchange => Complete): Unit = {
    buildRouteImpl(RouteTree.rootRouteNode, path.split("/").toList.tail)(using handler)
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
    val routeNodePathList = path.split("/")
    matchRouteImpl(RouteTree.rootRouteNode, routeNodePathList.toList.tail)
  }

  @tailrec
  private def matchRouteImpl(currentNode: RouteNode, routeNodePathList: List[String]): RouteNode = {
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