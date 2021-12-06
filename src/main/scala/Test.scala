import spray.json.DefaultJsonProtocol.{StringJsonFormat, mapFormat}
import spray.json.enrichAny
import thyme.{Thyme, ThymeContext, ThymeResponse}

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST("test/test",test)
            .GET ("test",test)
            .run()
    }

    val test: ThymeContext => ThymeResponse = x => {
        ThymeResponse(x.body.toJson)
    }
}
