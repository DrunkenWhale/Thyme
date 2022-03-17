package thyme.extarctor

import com.sun.net.httpserver.HttpExchange

class Extractor {

}

object Extractor {
  def extractor(httpExchange: HttpExchange): Unit = {

    val header: Map[String, String] =
      httpExchange
          .getRequestHeaders
          .asInstanceOf[Map[String, List[String]]]
          .map((key, valueList) => (key, valueList.mkString(" ")))
          .toMap

    val form: Map[String, String] = {
      String(httpExchange.getRequestBody.readAllBytes())
          .trim
          .split("&")
          .map(str => {
            val tuple = str.split("=")
            (tuple(0), tuple(1))
          })
          .toMap
    }

    val arg: Map[String, String] = {
      String(httpExchange.getRequestURI.getRawQuery)
          .trim
          .split("&")
          .map(str => {
            val tuple = str.split("=")
            (tuple(0), tuple(1))
          })
          .toMap
    }

    Context(header = header, form = form, arg = arg)

  }

}
