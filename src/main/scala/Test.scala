import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat3, mapFormat}
import spray.json.{JsValue, RootJsonFormat, enrichAny}
import thyme.{Thyme, ThymeContext}

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST(test,"test/test")
            .GET(test,"test")
            .run()
    }

    val test: ThymeContext => JsValue = x => {
        x.body.toJson
    }
}
