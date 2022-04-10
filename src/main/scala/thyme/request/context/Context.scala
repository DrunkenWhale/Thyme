package thyme.request.context

import rosemary.parser.model.{JsonObject, JsonValue}

private[thyme] final case class Context(
                                           path: String,
                                           method: String,
                                           header: Map[String, String] = Map.empty,
                                           form: Map[String, String] = Map.empty,
                                           parameter: Map[String, String] = Map.empty,
                                           json: JsonValue = JsonObject(),
                                           attribute: Map[String, String] = Map.empty,
                                           route: Map[String, String] = Map.empty
                                       )

object Context {

}