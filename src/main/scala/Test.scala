import akka.http.scaladsl.model.Uri.Path
import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat3, listFormat, mapFormat, tuple2Format}
import spray.json.{JsValue, RootJsonFormat, enrichAny}
import thyme.{Thyme, ThymeContext, ThymeResponse}

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST("test/test",test)
            .GET("test",test)
            .run()
    }


    val test: ThymeContext => ThymeResponse = x => {
        ThymeResponse(x.body.toJson)
    }
}
