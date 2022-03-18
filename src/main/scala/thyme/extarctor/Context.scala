package thyme.extarctor

case class Context(
                      header: Map[String, String] = Map.empty,
                      form: Map[String, String] = Map.empty,
                      parameter: Map[String, String] = Map.empty
                  )
