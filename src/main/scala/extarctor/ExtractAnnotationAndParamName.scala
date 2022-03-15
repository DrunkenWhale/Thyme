package extarctor

import scala.quoted.*

inline def extractAnnotationAndParamName[E](x: E) = $ {
  extractRouteAnnotationImpl('x)
}


private def extractRouteAnnotationImpl[E](expr: Expr[E])(using quotes: Quotes, tpe: Type[E])
: Expr[List[((String, String), List[String])]] = {
  import quotes.reflect.*

  /**
   * be sure to call this function
   * the method must have `Route` annotation
   * */

  def extractMethodAndPath(method: Symbol): (String, String) = {

    val route = method.getAnnotation(TypeTree.of[Route].symbol).get match {
      case Apply(_, nameList) => nameList.map {
        case NamedArg(_, value) => value
      }
    }

    (route(0) match {
      case Ident(method) => method
    }, route(1) match {
      case Literal(x) => x.value.toString
    })

  }

  /**
   * get given method's param name
   * will be used in route
   * all name will be injected into method
   * */
  def extractMethodParamName[T](method: Symbol): List[String] = {
    method.paramSymss(0).map(x => x.name)
  }


  val methods = TypeTree.of[E].symbol.declaredMethods

  val routeList = methods.map(method => (extractMethodAndPath(method), extractMethodParamName(method)))

  Expr(routeList)
}


