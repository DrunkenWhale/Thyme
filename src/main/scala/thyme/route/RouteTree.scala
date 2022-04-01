package thyme.route

import com.sun.net.httpserver.HttpExchange
import thyme.response.Complete
import thyme.route.node.{DynamicRouteNode, RouteNode, StaticRouteNode}

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

// be careful , don't overload the route register before

object RouteTree {

  val rootRouteNode: RouteNode = StaticRouteNode("")

  def buildRoute(path: String, method: String, handler: HttpExchange => Complete): Try[_] = {
    if (!path.startsWith("/")) {
      return Failure(new IllegalArgumentException("path must start with '/'"))
    }
    if (path == "/") {
      RouteTree.rootRouteNode.handlers.put(method, handler)
    } else {
      buildRouteImpl(RouteTree.rootRouteNode, path.split("/").toList.tail)(using method, handler)
    }
    Success(null)
  }


  @tailrec
  private def buildRouteImpl(currentNode: RouteNode, routeNodePathList: List[String])
                            (using method: String, handler: HttpExchange => Complete): Unit = {

    // all elements are matched
    // register handler with method
    if (routeNodePathList.isEmpty) {
      currentNode.handlers.put(method, handler)
      return
    }

    val currentNodePath: String = routeNodePathList.head

    val childrenNodeOpt = currentNode.children.get(currentNodePath)

    if (childrenNodeOpt.isDefined) {

      val childrenNode = childrenNodeOpt.get
      buildRouteImpl(childrenNode, routeNodePathList.tail)

    } else {

      val childrenNode: RouteNode = {

        if (currentNodePath.startsWith(":")) {
          // pre check will make sure this path slice's length > 1 and != ":"
          val dynamicParamName: String = currentNodePath.substring(1)
          DynamicRouteNode(paramName = dynamicParamName, matchedPath = currentNode.matchedPath + "/" + dynamicParamName)
        } else {
          StaticRouteNode(currentNode.matchedPath + "/" + currentNodePath)
        }

      }
      currentNode.children.put(
        if (currentNodePath.startsWith(":")) {
          ":"
        } else {
          currentNodePath
        },
        childrenNode
      )

      buildRouteImpl(childrenNode, routeNodePathList.tail)

    }
  }

  def matchRoute(path: String, method: String): (Option[HttpExchange => Complete], List[(String, String)]) = {
    if (!path.startsWith("/")) {
      return (Option.empty, List())
    }
    if (path == "/") {
      (Some(RouteTree.rootRouteNode.handlers(method)), List())
    }
    else {
      val routeNodePathList = path.split("/")
      val dynamicParamListBuffer: ListBuffer[(String, String)] = ListBuffer.empty
      val handlerOpt = matchRouteImpl(RouteTree.rootRouteNode, routeNodePathList.toList.tail)(using method, dynamicParamListBuffer)
      if (handlerOpt.isEmpty) {
        (Option.empty, List())
      } else {
        (handlerOpt, dynamicParamListBuffer.result())
      }
    }
  }

  @tailrec
  private def matchRouteImpl(currentNode: RouteNode, routeNodePathList: List[String])
                            (using method: String, paramListBuffer: ListBuffer[(String, String)]): Option[HttpExchange => Complete] = {
    // match all path slice
    if (routeNodePathList.isEmpty) {

      if (currentNode.handlers.contains(method)) {

        return Some(currentNode.handlers(method))

      }

      else {
        // unregister node
        return Option.empty

      }

    }
    val currentNodePath = routeNodePathList.head

    val childrenNodeOpt = currentNode.children.get(currentNodePath)

    if (childrenNodeOpt.isDefined) {

      matchRouteImpl(currentNode.children(routeNodePathList.head), routeNodePathList.tail)

    } else {

      val currentNodeChildrenDynamicNodeOpt = currentNode.children.get(":")

      if (currentNodeChildrenDynamicNodeOpt.isDefined) {

        val currentNodeChildrenDynamicNode: DynamicRouteNode = currentNodeChildrenDynamicNodeOpt.get.asInstanceOf[DynamicRouteNode]

        paramListBuffer.addOne((currentNodeChildrenDynamicNode.paramName, routeNodePathList.head))

        matchRouteImpl(currentNodeChildrenDynamicNode, routeNodePathList.tail)

      } else {
        // unregister node
        Option.empty

      }
    }
  }
}
