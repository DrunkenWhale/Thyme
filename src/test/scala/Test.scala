import thyme.boot.ThymeApplication
import thyme.request.Path.*
import thyme.request.rest.Get.*
import thyme.response.{Complete, ContentType, Entity}

object Test {
  def main(args: Array[String]): Unit = {
    val route =
      path("/api") {
        get { () =>
          Complete(200, Entity(contentType = ContentType.`application/json`, responseBody = "{name:1}"))
        }
      }
    ThymeApplication
        .create()
        .mount(route)
        .run(9090)
  }
}