package thyme.request.rest

import com.sun.net.httpserver.HttpExchange
import thyme.request.context.Context
import thyme.request.context.Extractor.extractor
import thyme.response.Complete

/**
 * the code in this file was generated from a python code
 * */

object HandleFactory {

  def getHandle
  (lambda: () => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) => lambda()
  }

  def getHandle[A]
  (x0: Context => A)
  (lambda: A => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) => lambda(x0(extractor(httpExchange)))

  }


  def getHandle[A, B]
  (x0: Context => A,
   x1: Context => B)
  (lambda: (A, B) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)))

  }


  def getHandle[A, B, C]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C)
  (lambda: (A, B, C) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D)
  (lambda: (A, B, C, D) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E)
  (lambda: (A, B, C, D, E) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F)
  (lambda: (A, B, C, D, E, F) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G)
  (lambda: (A, B, C, D, E, F, G) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H)
  (lambda: (A, B, C, D, E, F, G, H) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I)
  (lambda: (A, B, C, D, E, F, G, H, I) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J)
  (lambda: (A, B, C, D, E, F, G, H, I, J) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q,
   x17: Context => R)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)),
        x17(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q,
   x17: Context => R,
   x18: Context => S)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)),
        x17(extractor(httpExchange)),
        x18(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q,
   x17: Context => R,
   x18: Context => S,
   x19: Context => T)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)),
        x17(extractor(httpExchange)),
        x18(extractor(httpExchange)),
        x19(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q,
   x17: Context => R,
   x18: Context => S,
   x19: Context => T,
   x20: Context => U)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)),
        x17(extractor(httpExchange)),
        x18(extractor(httpExchange)),
        x19(extractor(httpExchange)),
        x20(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q,
   x17: Context => R,
   x18: Context => S,
   x19: Context => T,
   x20: Context => U,
   x21: Context => V)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)),
        x17(extractor(httpExchange)),
        x18(extractor(httpExchange)),
        x19(extractor(httpExchange)),
        x20(extractor(httpExchange)),
        x21(extractor(httpExchange)))

  }


  def getHandle[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G,
   x7: Context => H,
   x8: Context => I,
   x9: Context => J,
   x10: Context => K,
   x11: Context => L,
   x12: Context => M,
   x13: Context => N,
   x14: Context => O,
   x15: Context => P,
   x16: Context => Q,
   x17: Context => R,
   x18: Context => S,
   x19: Context => T,
   x20: Context => U,
   x21: Context => V,
   x22: Context => W)
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W) => Complete): HttpExchange => Complete = {
    (httpExchange: HttpExchange) =>
      lambda(x0(extractor(httpExchange)),
        x1(extractor(httpExchange)),
        x2(extractor(httpExchange)),
        x3(extractor(httpExchange)),
        x4(extractor(httpExchange)),
        x5(extractor(httpExchange)),
        x6(extractor(httpExchange)),
        x7(extractor(httpExchange)),
        x8(extractor(httpExchange)),
        x9(extractor(httpExchange)),
        x10(extractor(httpExchange)),
        x11(extractor(httpExchange)),
        x12(extractor(httpExchange)),
        x13(extractor(httpExchange)),
        x14(extractor(httpExchange)),
        x15(extractor(httpExchange)),
        x16(extractor(httpExchange)),
        x17(extractor(httpExchange)),
        x18(extractor(httpExchange)),
        x19(extractor(httpExchange)),
        x20(extractor(httpExchange)),
        x21(extractor(httpExchange)),
        x22(extractor(httpExchange)))
  }

}
