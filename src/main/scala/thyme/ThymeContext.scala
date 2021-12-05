package thyme

import akka.http.scaladsl.model.{HttpHeader, HttpMethod, Uri}

class ThymeContext(
                             val header: Map[String, String],
                             val param  : Map[String, String],
                             val body   : Map[String, String],
                             val method : HttpMethod,
                             val url    : Uri,
                             val protocol: String
                         ) {
    var attribute:Map[String,String] = Map()
}

object ThymeContext {
    def apply(
                 headersList: Seq[HttpHeader],
                 param      : Map[String, String],
                 body       : Map[String, String],
                 url        : Uri,
                 method     : HttpMethod,
                 protocol   : String
             ): ThymeContext = {

        val header: Map[String, String] = headersList.map(x => (x.name(), x.value())).toMap

        new ThymeContext(
            header = header,
            param = param,
            body = body,
            method = method,
            url = url,
            protocol = protocol
        )

    }
}
