package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.response.Complete

case class Node(path: StringBuilder = new StringBuilder,
                method: String,
                handler: HttpExchange => Complete)
