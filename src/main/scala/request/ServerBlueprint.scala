package request

case class ServerBlueprint(method: String, path: String, params: List[String])

object ServerBlueprint {
  
  given tupleToServerBlueprint: Conversion[((String, String), List[String]), ServerBlueprint] with {
    override def apply(x: ((String, String), List[String])): ServerBlueprint =
      ServerBlueprint(x._1._1, x._1._2, x._2)
  }
  
}