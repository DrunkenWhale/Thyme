package thyme.dsl

import com.sun.net.httpserver.HttpExchange

class Extractor {

}

object Extractor {
  def extractor(httpExchange: HttpExchange): Unit = {

    val header: Map[String, List[String]] = httpExchange.getRequestHeaders.asInstanceOf[Map[String, List[String]]]

    val form: Map[String, String] = {
      val formString: String = String(httpExchange.getRequestBody.readAllBytes())
      formString.trim.split("&").map(str => {
        val tuple = str.split("=")
        (tuple(0), tuple(1))
      }).toMap
    }
        
  }

}
