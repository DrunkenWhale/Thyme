package thyme

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.{PathMatcher, Route}
import spray.json.{DefaultJsonProtocol, JsValue, RootJsonFormat, enrichAny}
import spray.json.DefaultJsonProtocol._
import thyme.Thyme.parseRoutePath

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn
import scala.util.parsing.json.{JSONFormat, JSONObject}

case class test(name: String, age: Int)

class Thyme {

    private var route = get {
        path("Hello World!") {
            complete("Hello World!")
        }
    }

    def POST(f:Map[String,String]=>JsValue,postPath: String): Thyme = {
        route = concat(route,
            post {
                path(parseRoutePath(postPath)) {
                    formFieldMap {
                        form => complete(HttpEntity(ContentTypes.`application/json`,f(form).toString()))
                    }
                }
            }
        )
        this
    }

    def GET(f:Map[String,String]=>JsValue,getPath: String): Thyme = {
        route = concat(route,
            get {
                path(parseRoutePath(getPath)) {
                    formFieldMap {
                        form => complete(HttpEntity(ContentTypes.`application/json`,f(form).toString()))
                    }
                }
            }
        )
        this
    }
    def PUT(f:Map[String,String]=>JsValue,putPath: String): Thyme = {
        route = concat(route,
            put {
                path(parseRoutePath(putPath)) {
                    formFieldMap {
                        form => complete(HttpEntity(ContentTypes.`application/json`,f(form).toString()))
                    }
                }
            }
        )
        this
    }
    def DELETE(f:Map[String,String]=>JsValue,deletePath: String): Thyme = {
        route = concat(route,
            delete {
                path(parseRoutePath(deletePath)) {
                    formFieldMap {
                        form => complete(HttpEntity(ContentTypes.`application/json`,f(form).toString()))
                    }
                }
            }
        )
        this
    }
    def OPTIONS(f:Map[String,String]=>JsValue,optionsPath: String): Thyme = {
        route = concat(route,
            options {
                path(parseRoutePath(optionsPath)) {
                    formFieldMap {
                        form => complete(HttpEntity(ContentTypes.`application/json`,f(form).toString()))
                    }
                }
            }
        )
        this
    }

    def run(port: Int = 2333, host: String = "localhost"): Unit = {
        implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")
        implicit val executionContext: ExecutionContextExecutor = system.executionContext
        val bindingFuture = Http().newServerAt(host, port).bind(route)
        StdIn.readLine()
        bindingFuture
            .flatMap(_.unbind())
            .onComplete(_ => system.terminate())
    }

}

object Thyme {

    def apply(): Thyme = {
        new Thyme()
    }

    private def parseRoutePath(routePath:String): PathMatcher[Unit] ={
        routePath.split('/').map(x=>PathMatcher(x)).reduce((x,y)=>x/y)
    }
}
