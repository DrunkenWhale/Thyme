import thyme.boot.ThymeApplication
import thyme.dsl.rest.Get.get
import thyme.response.{Complete, ContentTypes, Entity}
import thyme.dsl.Path.*
import thyme.dsl.ContextParam.*
import thyme.dsl.rest.Post.post
import thyme.dsl.Middleware.interceptor
import thyme.log.ThymeLogger
import rosemary.stringify.Stringify.*

object Test {

  case class DTO(code: Int, message: String, data: Map[String, _] = Map.empty)

  def main(args: Array[String]): Unit = {

    val router =
      path("/api") {
        get(headers, json) { (header, json) =>
          println(json)
          Complete(200, Entity(contentType = ContentTypes.`text/plain`, responseBody = header.toString))
        }
      } ~ path("/:name/:age/pigeon/:114514/:1919810/ls") {
        post(route("name"), routes) {
          (name, r) =>
            Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = s"{$name:114}"))
        }
      } ~ path("/apis") {
        interceptor(context => context.header.contains("Pass")) {
          get(parameter("name").as[Double]) { name =>
            println(name.get)
            val res = DTO(200, "Succeed",
              Map("name" -> Map(
                "name" -> "野兽前辈",
                "age" -> 114514,
                "number" -> 1919810
              ))).toJson
            Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = res))
          }
        }
      }

    ThymeApplication
        .create()
        .mount(router)
        .run(9090)
  }
}