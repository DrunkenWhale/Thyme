package com.test

import com.thyme.{Thyme, ThymeContext, ThymeResponse}
import spray.json.DefaultJsonProtocol.{StringJsonFormat, mapFormat}
import spray.json.enrichAny

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST("/test/test", test)
            .GET("/test", test)
            .GET("/hello", x => ThymeResponse("Hello World!".toJson))
            .run()
    }

    val test: ThymeContext => ThymeResponse = x => {
        ThymeResponse(x.body.toJson)
    }
}
