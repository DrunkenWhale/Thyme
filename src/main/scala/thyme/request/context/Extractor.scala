package thyme.request.context

import com.sun.net.httpserver.HttpExchange
import thyme.request.context.Context

class Extractor {

}

object Extractor {
  def extractor(httpExchange: HttpExchange): Context = {
    try {
      val header: Map[String, String] = {
        val headers = httpExchange.getRequestHeaders
        headers.keySet().toArray().map(key => (key.asInstanceOf[String], headers.get(key).toArray().mkString(" "))).toMap
      }

      val form: Map[String, String] = {

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


      Context(
        path = httpExchange.getRequestURI.getPath,
        method = httpExchange.getRequestMethod,
        header = header,
        form = form,
        parameter = parameter
      )
    } catch {
      case x: Exception => x.printStackTrace()
        null
    }

  }

}
