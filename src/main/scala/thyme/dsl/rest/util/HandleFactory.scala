package thyme.dsl.rest.util

import thyme.request.context.Context
import thyme.response.Complete

/**
 * the code in this file was generated from a python code
 * */

private[thyme] object HandleFactory {

  def getHandle
  (lambda: () => Complete): Context => Complete = {
    (context: Context) => lambda()
  }

  def getHandle[A]
  (x0: Context => A)
  (lambda: A => Complete): Context => Complete = {
    (context: Context) => lambda(x0(context))

  }


  def getHandle[A, B]
  (x0: Context => A,
   x1: Context => B)
  (lambda: (A, B) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context))

  }


  def getHandle[A, B, C]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C)
  (lambda: (A, B, C) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context))

  }


  def getHandle[A, B, C, D]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D)
  (lambda: (A, B, C, D) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context))

  }


  def getHandle[A, B, C, D, E]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E)
  (lambda: (A, B, C, D, E) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context))

  }


  def getHandle[A, B, C, D, E, F]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F)
  (lambda: (A, B, C, D, E, F) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context))

  }


  def getHandle[A, B, C, D, E, F, G]
  (x0: Context => A,
   x1: Context => B,
   x2: Context => C,
   x3: Context => D,
   x4: Context => E,
   x5: Context => F,
   x6: Context => G)
  (lambda: (A, B, C, D, E, F, G) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context))

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
  (lambda: (A, B, C, D, E, F, G, H) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context),
        x17(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context),
        x17(context),
        x18(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context),
        x17(context),
        x18(context),
        x19(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context),
        x17(context),
        x18(context),
        x19(context),
        x20(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context),
        x17(context),
        x18(context),
        x19(context),
        x20(context),
        x21(context))

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
  (lambda: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W) => Complete): Context => Complete = {
    (context: Context) =>
      lambda(x0(context),
        x1(context),
        x2(context),
        x3(context),
        x4(context),
        x5(context),
        x6(context),
        x7(context),
        x8(context),
        x9(context),
        x10(context),
        x11(context),
        x12(context),
        x13(context),
        x14(context),
        x15(context),
        x16(context),
        x17(context),
        x18(context),
        x19(context),
        x20(context),
        x21(context),
        x22(context))
  }

}
