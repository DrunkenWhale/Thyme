package thyme

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.RawHeader
import akka.http.scaladsl.server.{PathMatcher, Route}
import spray.json.JsValue
import thyme.Thyme.{defaultResponseHeaders, parseRoutePath}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn
import scala.language.implicitConversions


class Thyme(private val name: String) {


    private var route = get {
        path("Hello World!") {
            respondWithHeaders(defaultResponseHeaders) {
                complete("Hello World!")
            }
        }
    }

    def POST(f: ThymeContext => ThymeResponse, postPath: String): Thyme = {
        route = concat(route,
            post {
                listen(f, postPath)
            }
        )
        this
    }

    def GET(f: ThymeContext => ThymeResponse, getPath: String): Thyme = {
        route = concat(route,
            get {
                listen(f, getPath)
            }
        )
        this
    }

    def PUT(f: ThymeContext => ThymeResponse, putPath: String): Thyme = {
        route = concat(route,
            put {
                listen(f, putPath)
            }
        )
        this
    }

    def DELETE(f: ThymeContext => ThymeResponse, deletePath: String): Thyme = {
        route = concat(route,
            delete {
                listen(f, deletePath)
            }
        )
        this
    }

    def OPTIONS(f: ThymeContext => ThymeResponse, optionsPath: String): Thyme = {
        route = concat(route,
            options {
                listen(f, optionsPath)
            }
        )
        this
    }


//    private def listen(f: ThymeContext => JsValue, pathString: String): Route = {
//        path(parseRoutePath(pathString)) {
//            (extractRequest & formFieldMap & parameterMap) {
//                (request, form, param) =>
//
//                    // Change Http data to `ThymeContext`
//                    // user can get all(maybe) data from `ThymeContext`
//                    // and mount their response on `ThymeResponse`
//
//
//                    val thymeContext = ThymeContext(
//                        request.headers,
//                        param = param,
//                        body = form,
//                        url = request.uri,
//                        method = request.method,
//                        protocol = request.protocol.value,
//                    )
//
//                    respondWithHeaders(request.headers) {
//                        complete(HttpEntity(
//                            ContentTypes.`application/json`,
//                            ThymeResponse(f(thymeContext)).toString
//                        ))
//                    }
//
//            }
//        }
//    }

    private def listen(f: ThymeContext => ThymeResponse, pathString: String): Route = {
        path(parseRoutePath(pathString)) {
            (extractRequest & formFieldMap & parameterMap) {
                (request, form, param) =>

                    // Change Http data to `ThymeContext`
                    // user can get all(maybe) data from `ThymeContext`
                    // and mount their response on `ThymeResponse`

                    val thymeContext = ThymeContext(
                        request.headers,
                        param = param,
                        body = form,
                        url = request.uri,
                        method = request.method,
                        protocol = request.protocol.value,
                    )

                    val response = f(thymeContext)



                    respondWithHeaders(response.header.appendedAll
                    (if (response.cors) defaultResponseHeaders
                    else defaultResponseHeaders)) {
                        complete(HttpEntity(
                            ContentTypes.`application/json`,
                            response.toString
                        ))
                    }

            }
        }
    }


    def run(port: Int = 2333, host: String = "localhost"): Unit = {
        implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, name)
        implicit val executionContext: ExecutionContextExecutor = system.executionContext
        val bindingFuture = Http().newServerAt(host, port).bind(route)
        StdIn.readLine()
        bindingFuture
            .flatMap(_.unbind())
            .onComplete(_ => system.terminate())
    }

}

object Thyme {

    def apply(name: String = "Thyme"): Thyme = {
        new Thyme(name)
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
