package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.Complete

case class Route(path: StringBuilder = new StringBuilder,
                 method: String,
                 handle: HttpExchange => Complete)
