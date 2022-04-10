# Thyme

Delicate Web Framework

base on package `com.sun.net.httpserver`

|ू･ω･` )

## Quick Start

### Hello World

```scala
import thyme.boot.ThymeApplication
import thyme.response.{Complete, Entity, ContentTypes}

ThymeApplication.create().mount(
  path("/") {
    () =>
      Complete(200, Entity(ContentTypes.`text/plain`, "Hello World~"))
  }
).run(2333)

```

now ,use curl `http://localhost:2333/`

will get

```text

Hello World~

```

### get param from request

```scala

import thyme.boot.ThymeApplication
import thyme.response.{Complete, Entity, ContentTypes}

ThymeApplication.create().mount(
  path("/") {
    post(form("isOK").as[Boolean]) { is =>
      Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = s"{result:$is}"))
    }
  }

).run(2333)

```

this code will get `isOK` from http request form, and `is` will be thought as Option[Boolean]
if `isOK`'s value is not Boolean type, Option will be empty

## An Easy Web Application

```scala
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
        get { () =>
          Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = "{name:1}"))
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
```