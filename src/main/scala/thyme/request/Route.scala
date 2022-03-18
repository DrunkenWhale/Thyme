package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.response.Complete

case class Route(path: StringBuilder = new StringBuilder,
                 method: String,
                 handle: HttpExchange => Complete)
