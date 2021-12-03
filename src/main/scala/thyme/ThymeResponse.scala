package thyme

import akka.http.scaladsl.model.HttpHeader
import spray.json.JsValue

class ThymeResponse(val body: JsValue,
                    val cors: Boolean,
                    val header: Seq[HttpHeader]
                   ) {
}

object ThymeResponse {

    def apply(body: JsValue = null,
              cors: Boolean = false,
              header: Seq[HttpHeader] = Seq()): ThymeResponse =
        new ThymeResponse(body = body, cors = cors, header = header)

    def mount(thymeResponse: ThymeResponse, body: JsValue): ThymeResponse = {
        new ThymeResponse(body, thymeResponse.cors, thymeResponse.header)
    }
    def setHeader(thymeResponse: ThymeResponse, header: HttpHeader): ThymeResponse = {
        new ThymeResponse(thymeResponse.body, thymeResponse.cors, thymeResponse.header.appended(header))
    }

    def setHeaders(thymeResponse: ThymeResponse, headers: HttpHeader*): ThymeResponse = {
        new ThymeResponse(thymeResponse.body, thymeResponse.cors, thymeResponse.header.appendedAll(headers))
    }
    def setCors(thymeResponse: ThymeResponse, cors: Boolean): ThymeResponse = {
        new ThymeResponse(thymeResponse.body, cors, thymeResponse.header)
    }

}
