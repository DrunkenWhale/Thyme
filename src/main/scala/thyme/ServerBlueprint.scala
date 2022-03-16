package thyme

import thyme.dsl.Complete

case class ServerBlueprint(lambda: () => Complete)

object ServerBlueprint {}