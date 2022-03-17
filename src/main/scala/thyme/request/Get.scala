package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.{Complete, Method}


/**
 * This Implement is Not a Noble Way !
 * The code be generated from a python code:
 * for i in range(1,26):
 * ...:     a = ""
 * ...:     for j in range(i):
 * ...:         a += l[j]+","
 * ...:     a = a[:-1]
 * ...:     b=""
 * ...:     for j in range(i):
 * ...:         b += "x%s:ContextParam[%s]," % (str(j),l[j])
 * ...:     b = b[:-1]
 * ...:
 * ...:     c = ""
 * ...:     for j in range(i):
 * ...:         c += "x%s," % str(j)
 * ...:     c = c[:-1]
 * ...:     t = temp % (a,b,"("+a+")",c)
 * ...:     print(t)
 *
 * Ah!
 * */
object Get {

  def get(lambda: () => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda()
    }

    Route(method = "GET", handle = handle)

  }

  def get[A](x0: ContextParam[A])(lambda: A => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B](x0: ContextParam[A], x1: ContextParam[B])(lambda: (A, B) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C])(lambda: (A, B, C) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D])(lambda: (A, B, C, D) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E])(lambda: (A, B, C, D, E) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F])(lambda: (A, B, C, D, E, F) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G])(lambda: (A, B, C, D, E, F, G) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H])(lambda: (A, B, C, D, E, F, G, H) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I])(lambda: (A, B, C, D, E, F, G, H, I) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J])(lambda: (A, B, C, D, E, F, G, H, I, J) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K])(lambda: (A, B, C, D, E, F, G, H, I, J, K) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P], x16: ContextParam[Q])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P], x16: ContextParam[Q], x17: ContextParam[R])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P], x16: ContextParam[Q], x17: ContextParam[R], x18: ContextParam[S])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P], x16: ContextParam[Q], x17: ContextParam[R], x18: ContextParam[S], x19: ContextParam[T])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P], x16: ContextParam[Q], x17: ContextParam[R], x18: ContextParam[S], x19: ContextParam[T], x20: ContextParam[U])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20)
    }

    Route(method = "GET", handle = handle)

  }

  def get[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](x0: ContextParam[A], x1: ContextParam[B], x2: ContextParam[C], x3: ContextParam[D], x4: ContextParam[E], x5: ContextParam[F], x6: ContextParam[G], x7: ContextParam[H], x8: ContextParam[I], x9: ContextParam[J], x10: ContextParam[K], x11: ContextParam[L], x12: ContextParam[M], x13: ContextParam[N], x14: ContextParam[O], x15: ContextParam[P], x16: ContextParam[Q], x17: ContextParam[R], x18: ContextParam[S], x19: ContextParam[T], x20: ContextParam[U], x21: ContextParam[V])(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => Complete): Route = {

    def handle = (httpExchange: HttpExchange) => {
      lambda(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21)
    }

    Route(method = "GET", handle = handle)

  }
}
