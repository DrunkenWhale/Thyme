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

this code will get `isOK` from http request form, and refuse it if isOK is not a Boolean value

## An Easy Web Application

```scala

import thyme.boot.ThymeApplication
import thyme.dsl.rest.Get.get
import thyme.response.{Complete, ContentTypes, Entity}
import thyme.dsl.Path.{path, ~}
import thyme.dsl.ContextParam.{as, header}
import thyme.dsl.rest.Post.post
import thyme.dsl.Middleware.middleware

object Main {
  val router =
    path("/api") {
      get { () =>
        Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = "{name:1}"))
      }
    } ~ path("/") {
      post {
        () =>
          Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = "{name:114}"))
      }
    } ~ path("/apis") {
      middleware(context => context.header.contains("Pass")) {
        get(parameter("name").as[Boolean]) { name =>
          println(name)
          Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = s"{$name:114}"))
        }
      }
    }

  ThymeApplication
      .create()
      .mount(router)
      .run(9090)
}
```