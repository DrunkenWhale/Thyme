package extarctor

import scala.quoted.*

inline def extractAnnotationAndParamName[E]: List[(String, (String, String), List[String])] = $ {
  extractRouteAnnotationImpl[E]
}


private def extractRouteAnnotationImpl[T](using quotes: Quotes, tpe: Type[T])
: Expr[List[(String, (String, String), List[String])]] = {
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
  def extractMethodParamName(method: Symbol): List[String] = {
    method.paramSymss(0).map(x => x.name)
  }

  /**
   * given a method:Symbol, return its name
   * */
  def extractMethodName(method: Symbol): String = {
    method.name
  }

  val methods = TypeTree.of[T].symbol.declaredMethods

  val routeList = methods.map(method => (extractMethodName(method), extractMethodAndPath(method), extractMethodParamName(method)))

  Expr(routeList)

}


