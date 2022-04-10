package thyme.request.context

import com.sun.net.httpserver.HttpExchange
import rosemary.parser.model.JsonObject
import rosemary.parser.Parser.parse
import thyme.boot.ThymeApplication
import thyme.request.context.Context


object Extractor {
  def extractor(httpExchange: HttpExchange, dynamicRouteParam: List[(String, String)] = List()): Option[Context] = {
    try {
      val header: Map[String, String] = {
        val headers = httpExchange.getRequestHeaders
        headers.keySet().toArray().map(key => (key.asInstanceOf[String], headers.get(key).toArray().mkString(" "))).toMap
      }

      val parameter: Map[String, String] = {

        val tempString = httpExchange.getRequestURI.getRawQuery

        if (tempString != null) {
          val rawQueryString: String = String(httpExchange.getRequestURI.getRawQuery)

          if (rawQueryString.length >= 3) {

            rawQueryString.trim
                .split("&")
                .map(str => {
                  val tuple = str.split("=")
                  (tuple(0), tuple(1))
                })
                .toMap

          } else {
            Map.empty
          }
        } else {
          Map.empty
        }

      }

      val contentTypeOpt = {
        val tmpOpt: Option[(String, String)] = header.find((k, v) => k.equalsIgnoreCase("content-type"))
        if (tmpOpt.nonEmpty) {
          Some(tmpOpt.get._2)
        } else {
          Option.empty
        }
      }

      val form: Map[String, String] = {
        if (contentTypeOpt.isEmpty || contentTypeOpt.get.contains("form")) {
          val tempArray: Array[Byte] = httpExchange.getRequestBody.readAllBytes()
          if (tempArray.isEmpty) {
            Map.empty
          } else {
            val rawFormString: String = String(httpExchange.getRequestBody.readAllBytes())
            if (rawFormString.length >= 3) {
              rawFormString.trim
                  .split("&")
                  .map(str => {
                    val tuple = str.split("=")
                    (tuple(0), tuple(1))
                  })
                  .toMap
            } else {
              Map.empty
            }
          }
        } else {
          Map.empty
        }
      }

      val json = {
        if (contentTypeOpt.nonEmpty && contentTypeOpt.get.contains("application/json")) {
          val byteArray = httpExchange.getRequestBody.readAllBytes()
          if (byteArray.nonEmpty) {
            parse(String(byteArray))
          } else {
            JsonObject()
          }
        } else {
          JsonObject()
        }
      }

      Option(
        Context(
          path = httpExchange.getRequestURI.getPath,
          method = httpExchange.getRequestMethod,
          header = header,
          form = form,
          parameter = parameter,
          json = json,
          route = dynamicRouteParam.toMap
        )
      )
    } catch {
      case x: Exception => x.printStackTrace()
        // http header illegal
        Option.empty

    }

  }

}
