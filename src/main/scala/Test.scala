import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat3, mapFormat}
import spray.json.{JsValue, RootJsonFormat, enrichAny}
import thyme.{Thyme, ThymeContext, ThymeResponse}

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST((x)=>ThymeResponse(x.protocol.toJson),"test/test")
            .GET(test,"test")
            .run()
    }


    val test: ThymeContext => ThymeResponse = x => {
        ThymeResponse(x.body.toJson)
    }
}
