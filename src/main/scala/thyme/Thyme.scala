package thyme

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.{PathMatcher, Route}
import spray.json.{DefaultJsonProtocol, RootJsonFormat, enrichAny}
import spray.json.DefaultJsonProtocol._

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

    def POST(postPath: String): Thyme = {
        route = concat(route,
            post {
                path(postPath.split('/').map(x=>PathMatcher(x)).reduce((x,y)=>x/y)) {
                    formFieldMap {
                        form =>
                            implicit val impl: RootJsonFormat[test] = jsonFormat2(test)
                            complete(test("秀吉", 114514).toJson.prettyPrint)
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
}
