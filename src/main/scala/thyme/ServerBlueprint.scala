package thyme

import scala.reflect.ClassTag

case class ServerBlueprint(name: String, method: String, path: String, params: List[String],clsTag:ClassTag[_])

object ServerBlueprint {}