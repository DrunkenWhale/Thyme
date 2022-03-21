package thyme.request.context

final case class Context(
                            header: Map[String, String] = Map.empty,
                            form: Map[String, String] = Map.empty,
                            parameter: Map[String, String] = Map.empty,
                            url: String
                        )

object Context{
  
}