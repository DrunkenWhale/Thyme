package thyme

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.RawHeader
import akka.http.scaladsl.server.{PathMatcher, Route}
import spray.json.{DefaultJsonProtocol, JsValue, RootJsonFormat, enrichAny}
import spray.json.DefaultJsonProtocol._
import thyme.Thyme.{defaultResponseHeaders, parseRoutePath}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn
import scala.util.parsing.json.{JSONFormat, JSONObject}
import akka.http.scaladsl.server.Directives._


class Thyme(
               private val name:String,
               private val port:Int,
               private val host:String
           ) {


    private var route = get {
        path("Hello World!") {
            complete("Hello World!")
        }
    }

    def POST(f: ThymeContext => JsValue, postPath: String): Thyme = {
        route = concat(route,
            post {
                listen(f,postPath)
            }
        )
        this
    }

    def GET(f: ThymeContext => JsValue, getPath: String): Thyme = {
        route = concat(route,
            get {
                listen(f,getPath)
            }
        )
        this
    }

    def PUT(f: ThymeContext => JsValue, putPath: String): Thyme = {
        route = concat(route,
            put {
                listen(f,putPath)
            }
        )
        this
    }

    def DELETE(f: ThymeContext => JsValue, deletePath: String): Thyme = {
        route = concat(route,
            delete {
                listen(f,deletePath)
            }
        )
        this
    }

    def OPTIONS(f: ThymeContext => JsValue, optionsPath: String): Thyme = {
        route = concat(route,
            options {
                listen(f,optionsPath)
            }
        )
        this
    }

    private def listen(f: ThymeContext => JsValue, pathString: String): Route ={
        (path(parseRoutePath(pathString)) & respondWithHeaders(defaultResponseHeaders)) {
            (extractRequest & formFieldMap & parameterMap) {
                (request, form, param) =>
                    val thymeContext = ThymeContext(
                        request.headers,
                        param = param,
                        body = form,
                        url = request.uri,
                        method = request.method,
                        protocol = request.protocol.value,
                    )
                    complete(HttpEntity(
                        ContentTypes.`application/json`,
                        f(thymeContext).toString()
                    ))
            }
        }
    }


    def run(port: Int = 2333, host: String = "localhost"): Unit = {
        implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "MySystem")
        implicit val executionContext: ExecutionContextExecutor = system.executionContext
        val bindingFuture = Http().newServerAt(host, port).bind(route)
        StdIn.readLine()
        bindingFuture
            .flatMap(_.unbind())
            .onComplete(_ => system.terminate())
    }

}

object Thyme {

    def apply(name:String="Thyme",port:Int=2333,host:String="localhost"): Thyme = {
        new Thyme(name,port,host)
    }

    private val defaultResponseHeaders = Seq(
        RawHeader("Access-Control-Allow-Origin", "*"),
        RawHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"),
        RawHeader("Access-Control-Allow-Headers", "Accept, Origin, Content-type, X-Json, X-Prototype-Version, X-Requested-With"),
        RawHeader("Access-Control-Allow-Credentials", "true")
    )

    private def parseRoutePath(routePath: String): PathMatcher[Unit] = {
        routePath.split('/').map(x => PathMatcher(x)).reduce((x, y) => x / y)
    }

}
