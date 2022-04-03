import thyme.boot.ThymeApplication
import thyme.dsl.rest.Get.get
import thyme.response.{Complete, ContentTypes, Entity}
import thyme.dsl.Path.*
import thyme.dsl.ContextParam.*
import thyme.dsl.rest.Post.post
import thyme.dsl.Middleware.middleware
import thyme.log.ThymeLogger

object Test {
  def main(args: Array[String]): Unit = {

    val router =
      path("/api") {
        get { () =>
          Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = "{name:1}"))
        }
      } ~ path("/:name/:age/pigeon/:114514/:1919810/ls") {
        post(route("name"), routes) {
          (name, r) =>
            Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = s"{$name:114}"))
        }
      } ~ path("/apis") {
        middleware(context => context.header.contains("Pass")) {
          get(parameter("name").as[Double]) { name =>
            println(name.get)
            Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = s"{$name:114}"))
          }
        }
      }

    ThymeApplication
        .create()
        .mount(router)
        .run(9090)
  }
}