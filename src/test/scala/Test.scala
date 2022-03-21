import thyme.boot.ThymeApplication
import thyme.dsl.rest.Get.get
import thyme.response.{Complete, ContentType, Entity}
import thyme.dsl.Path.path

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