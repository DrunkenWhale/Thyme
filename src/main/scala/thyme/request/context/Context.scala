package thyme.request.context

final case class Context(
                            path: String,
                            method: String,
                            header: Map[String, String] = Map.empty,
                            form: Map[String, String] = Map.empty,
                            parameter: Map[String, String] = Map.empty
                        )

object Context {

}