package extarctor

import quoted.*

inline def te() = $ {
  teImpl
}

private def teImpl(using quotes: Quotes) = {
  import quotes.reflect.*
  val res = TypeTree.of[Route].symbol.children
  Expr(res.toString)
}
