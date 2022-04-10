# Thyme

讲道理啊 我这英文水平 自己写的`README`隔两天自己都看不懂了

这是一个非常简陋而且脆弱的`web框架`捏

是基于`com.sum.net.httpserver`硬套出来的

|ू･ω･` )

## 快速开始

### 简单的例子

```scala
import thyme.boot.ThymeApplication
import thyme.dsl.Path.path
import thyme.response.{Complete, Entity, ContentTypes}

ThymeApplication.create().mount(
  path("/") {
    () =>
      Complete(200, Entity(ContentTypes.`text/plain`, "Hello World~"))
  }
).run(2333)

```

启动之后, 使用`curl`访问`http://localhost:2333`

就能得到这样的返回

```text

Hello World~

```

是不是很简单捏 =.=

### 从请求中获取参数

举个栗子

```scala

import thyme.boot.ThymeApplication
import thyme.response.{Complete, Entity, ContentTypes}
import thyme.dsl.DSL.*

ThymeApplication.create().mount(
  path("/") {
    post(form("isOK").as[Boolean]) { is =>
      Complete(200, Entity(contentType = ContentTypes.`application/json`, responseBody = s"{result:$is}"))
    }
  }

).run(2333)

```

你可以使用`json`,`form`,`param`等看起来和作用就很像的函数, 将他们写在请求方法(post/get/put/delete/route("request method"))的参数里,
并且在后续的函数体中以匿名函数的方式将其作为参数使用, 就能得到你想要的参数啦。

上面的代码中, 将读入http请求表单中将"isOK"作为键的值, 他会在参数合法且为指定类型(`Boolean`)的时候, 返回一个正常的`Option[Boolean]`, 否则将返回`Option.empty`

### 一个简单的Web应用

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

上面就是一个简单的栗子, 其中, 你既可以对路由进行分组, 也可以通过`interceptor`函数将类型为
`Context => Boolean`的有限个函数挂载到某一路由分组上, 这个函数的执行将在请求被指定路由接受前执行, 当你的函数返回`true`时, 请求将正常执行, 返回`false`时, 请求将被拦截, 并且返回`404`

对了, 路由中,若是某一个变量以":"开头,例如 “:name”,在当前节点,将匹配任意规则的路由, 你可以在请求方法的第一个参数列表中, 使用`route("name")`函数, 从`Context`中获取匹配到的值

定义的`interceptor`等函数将会在`handler`挂载至路由树之前, 与`handler`进行组合, 组合成一个新的`Context=>Complete`类型的函数, 并捕捉指定的请求.