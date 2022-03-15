package boot

import boot.ServerRegister.{invokeMethodWithParamSeq, stringToOtherType}
import com.sun.net.httpserver.{HttpExchange, HttpServer}

import java.io.ByteArrayInputStream
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import scala.collection.mutable.ListBuffer
import scala.reflect.ClassTag
import extarctor.extractAnnotationAndParamName
import request.ServerBlueprint

import java.lang.Integer
import java.lang.reflect.Method
import scala.language.postfixOps

class ServerRegister {

  private val controllerList: ListBuffer[List[ServerBlueprint]] = ListBuffer.empty

    inline
  def mount[T](implicit classTag: ClassTag[T]): ServerRegister = {
    val dataList = extractAnnotationAndParamName[T]
    this.controllerList.addOne(dataList.map(data => ServerBlueprint(data._1, data._2._1, data._2._2, data._3, classTag)))
    this
  }

  def register(port: Int, backlog: Int): Unit = {
    val httpServer: HttpServer = HttpServer.create(new InetSocketAddress(port), backlog)

    val serverBlueprintList = this.controllerList.toList.flatten

    serverBlueprintList.foreach(serverBlueprint =>
      httpServer.createContext(serverBlueprint.path, (httpExchange: HttpExchange) => {

        if (httpExchange.getProtocol == "HTTP/1.1") {
          if (httpExchange.getRequestMethod.equalsIgnoreCase(serverBlueprint.method)) {

            val tempClassInstanceOfClsTag = serverBlueprint.clsTag.runtimeClass.getDeclaredConstructors.head.newInstance()
            val method = serverBlueprint.clsTag.runtimeClass.getMethods.filter(m => m.getName == serverBlueprint.name).head
            val formParamString: String = String(httpExchange.getRequestBody.readAllBytes())
            val formParam = formParamString.split("&").map(x => {
              val a = x.split("=")
              (a(0), a(1))
            }).toMap

            val seq: Seq[Any] = method.getParameters.map(n => stringToOtherType(formParam(n.getName), n.getType.getSimpleName))

            val response = invokeMethodWithParamSeq(method, tempClassInstanceOfClsTag, seq)
            httpExchange.sendResponseHeaders(200, response.length)
            httpExchange.getResponseBody.write(response.getBytes(StandardCharsets.UTF_8))
          } else {
            val response = "Method Not Allow"
            httpExchange.sendResponseHeaders(405, response.length)
            httpExchange.getResponseBody.write(response.getBytes(StandardCharsets.UTF_8))
          }

        } else {
          // wrong protocol
          val response = "Unsupported Protocol"
          httpExchange.sendResponseHeaders(200, response.length)
          httpExchange.getResponseBody.write(response.getBytes(StandardCharsets.UTF_8))
        }
      })
    )

    httpServer.start()
  }

}

object ServerRegister {

  def create(): ServerRegister = {
    new ServerRegister
  }

  private def invokeMethodWithParamSeq(method: Method, obj: Object, parameter: Seq[Any]): String = {
    {
      parameter.size match {
        case 0 => method.invoke(obj)
        case 1 => method.invoke(obj, parameter(0))
        case 2 => method.invoke(obj, parameter(0), parameter(1))
        case 3 => method.invoke(obj, parameter(0), parameter(1), parameter(2))
        case 4 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3))
        case 5 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4))
        case 6 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5))
        case 7 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6))
        case 8 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7))
        case 9 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8))
        case 10 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9))
        case 11 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10))
        case 12 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11))
        case 13 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12))
        case 14 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13))
        case 15 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14))
        case 16 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15))
        case 17 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15), parameter(16))
        case 18 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15), parameter(16), parameter(17))
        case 19 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15), parameter(16), parameter(17), parameter(18))
        case 20 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15), parameter(16), parameter(17), parameter(18), parameter(19))
        case 21 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15), parameter(16), parameter(17), parameter(18), parameter(19), parameter(20))
        case 22 => method.invoke(obj, parameter(0), parameter(1), parameter(2), parameter(3), parameter(4), parameter(5), parameter(6), parameter(7), parameter(8), parameter(9), parameter(10), parameter(11), parameter(12), parameter(13), parameter(14), parameter(15), parameter(16), parameter(17), parameter(18), parameter(19), parameter(20), parameter(21))
        case _ => throw Exception("Illegal Arguments")
      }
    }.toString
  }

  private def stringToOtherType(value: String, tpe: String): Any = {

    tpe match {
      case "int" => java.lang.Integer.parseInt(value)
      case "long" => java.lang.Long.parseLong(value)
      case "float" => java.lang.Float.parseFloat(value)
      case "double" => java.lang.Double.parseDouble(value)
      case "boolean" => java.lang.Boolean.parseBoolean(value)
      case "String" => value
      case x => throw Exception(s" type: $x not be implement ")
    }
  }

}