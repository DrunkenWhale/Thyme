package thyme.request

import com.sun.net.httpserver.HttpExchange
import thyme.dsl.Method
import thyme.extarctor.Context
import thyme.response.Complete

object Delete {

  def get(lambda: () => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(lambda))
  }

  def delete[A](x0: Context => A)(lambda: A => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0)(lambda))
  }


  def delete[A, B](x0: Context => A, x1: Context => B)(lambda: (A, B) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1)(lambda))
  }


  def delete[A, B, C](x0: Context => A, x1: Context => B, x2: Context => C)(lambda: (A, B, C) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2)(lambda))
  }


  def delete[A, B, C, D](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D)(lambda: (A, B, C, D) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3)(lambda))
  }


  def delete[A, B, C, D, E](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E)(lambda: (A, B, C, D, E) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4)(lambda))
  }


  def delete[A, B, C, D, E, F](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F)(lambda: (A, B, C, D, E, F) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5)(lambda))
  }


  def delete[A, B, C, D, E, F, G](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G)(lambda: (A, B, C, D, E, F, G) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H)(lambda: (A, B, C, D, E, F, G, H) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I)(lambda: (A, B, C, D, E, F, G, H, I) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J)(lambda: (A, B, C, D, E, F, G, H, I, J) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K)(lambda: (A, B, C, D, E, F, G, H, I, J, K) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T, x20: Context => U)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T, x20: Context => U, x21: Context => V)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21)(lambda))
  }


  def delete[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W](x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T, x20: Context => U, x21: Context => V, x22: Context => W)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W) => Complete): Route = {
    Route(method = "DELETE", handle = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22)(lambda))
  }


}
