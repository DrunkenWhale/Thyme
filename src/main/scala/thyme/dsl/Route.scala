package thyme.dsl

import thyme.dsl.Method.{Get, Post}

object Route {
  def route(method: Method)()(lambda: () => Complete): Complete = {
    lambda()
  }

  def route[T](method: Method)(tuple: T)(lambda: T => Complete): Complete = {
    lambda(tuple)
  }

  def get()(lambda: () => Complete): Complete
  = route(Get)()(lambda)

  def get[T](tuple: T)(lambda: T => Complete): Complete
  = route[T](Get)(tuple)(lambda)

  def main(args: Array[String]): Unit = {
    route(Post)() { () =>
      new Complete
    }
  }
}
