package thyme.dsl

import com.sun.net.httpserver.HttpExchange
import thyme.request.Node
import thyme.response.ContentType
import thyme.request.context.{Context, Extractor}
import thyme.response.{Complete, Entity}

object Middleware {

  def middleware(middlewares: (Context => Boolean)*)(route: Node*): Seq[Node] = {
    route.map { r =>
      Node(path = r.path, method = r.method, handler =
        (context: Context) =>
          var count = 0
          for (middleware <- middlewares
               if middleware(context)) {
            count += 1
          }
          if (count == middlewares.length) {
            r.handler(context)
          } else {
            // refactor
            Complete(404, Entity(ContentType.`text/plain`, "Not Found"))
          }
      )
    }
  }
}
