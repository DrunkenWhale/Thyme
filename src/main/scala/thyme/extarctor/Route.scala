package thyme.extarctor

import thyme.dsl.Method

case class Route(method: Method, path: String) extends annotation.ConstantAnnotation