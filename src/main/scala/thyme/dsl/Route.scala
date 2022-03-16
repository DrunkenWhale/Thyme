package thyme.dsl

import thyme.dsl.Method.{Get, Post, Put, Delete}

object Route {


  def route[T <: Tuple](method: Method)(param: T)(lambda: T => CompleteType): CompleteType
  = lambda(param)

  def post[T <: Tuple](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Post)(param)(lambda)

  def get[T <: Tuple](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Get)(param)(lambda)

  def put[T <: Tuple](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Put)(param)(lambda)

  def delete[T <: Tuple](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Delete)(param)(lambda)

  def route[T <: SingleParamType](method: Method)(param: T)(lambda: T => CompleteType): CompleteType
  = lambda(param)

  def post[T <: SingleParamType](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Post)(param)(lambda)

  def get[T <: SingleParamType](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Get)(param)(lambda)

  def put[T <: SingleParamType](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Put)(param)(lambda)

  def delete[T <: SingleParamType](param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Delete)(param)(lambda)

  def route(method: Method)(lambda: () => CompleteType): CompleteType
  = lambda()

  def post(lambda: () => CompleteType): CompleteType
  = route(Post)(lambda)

  def get(lambda: () => CompleteType): CompleteType
  = route(Get)(lambda)

  def put(lambda: () => CompleteType): CompleteType
  = route(Put)(lambda)

  def delete(lambda: () => CompleteType): CompleteType
  = route(Delete)(lambda)


  type SingleParamType = Int | Long | String | Double | Boolean

  type CompleteType = Complete

  def main(args: Array[String]): Unit = {
    post(114514, "????") { (a, b) =>
      a + b
      new Complete
    }
  }

}
