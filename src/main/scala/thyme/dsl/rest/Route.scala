package thyme.dsl.rest

import thyme.dsl.rest.util.HandleFactory
import thyme.request.context.Context
import thyme.request.Node
import thyme.response.Complete

object Route {

  def route(method: String)(lambda: () => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(lambda))
  }

  def route[A](method: String)(x0: Context => A)(lambda: A => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0)(lambda))
  }


  def route[A, B](method: String)(x0: Context => A, x1: Context => B)(lambda: (A, B) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1)(lambda))
  }


  def route[A, B, C](method: String)(x0: Context => A, x1: Context => B, x2: Context => C)(lambda: (A, B, C) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2)(lambda))
  }


  def route[A, B, C, D](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D)(lambda: (A, B, C, D) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3)(lambda))
  }


  def route[A, B, C, D, E](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E)(lambda: (A, B, C, D, E) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4)(lambda))
  }


  def route[A, B, C, D, E, F](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F)(lambda: (A, B, C, D, E, F) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5)(lambda))
  }


  def route[A, B, C, D, E, F, G](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G)(lambda: (A, B, C, D, E, F, G) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6)(lambda))
  }


  def route[A, B, C, D, E, F, G, H](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H)(lambda: (A, B, C, D, E, F, G, H) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I)(lambda: (A, B, C, D, E, F, G, H, I) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J)(lambda: (A, B, C, D, E, F, G, H, I, J) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K)(lambda: (A, B, C, D, E, F, G, H, I, J, K) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T, x20: Context => U)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T, x20: Context => U, x21: Context => V)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21)(lambda))
  }


  def route[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W](method: String)(x0: Context => A, x1: Context => B, x2: Context => C, x3: Context => D, x4: Context => E, x5: Context => F, x6: Context => G, x7: Context => H, x8: Context => I, x9: Context => J, x10: Context => K, x11: Context => L, x12: Context => M, x13: Context => N, x14: Context => O, x15: Context => P, x16: Context => Q, x17: Context => R, x18: Context => S, x19: Context => T, x20: Context => U, x21: Context => V, x22: Context => W)(lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W) => Complete): Node = {
    Node(method = method, handler = HandleFactory.getHandle(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22)(lambda))
  }


}
