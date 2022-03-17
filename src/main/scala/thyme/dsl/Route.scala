package thyme.dsl

import thyme.dsl.Method.{Get, Post, Put, Delete}

object Route {

  def route[T <: Tuple](method: Method)(path: String)
                       (param: T)(lambda: T => CompleteType): CompleteType
  = lambda(param)

  def post[T <: Tuple](path: String)
                      (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Post)(path)(param)(lambda)

  def get[T <: Tuple](path: String)
                     (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Get)(path)(param)(lambda)

  def put[T <: Tuple](path: String)
                     (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Put)(path)(param)(lambda)

  def delete[T <: Tuple](path: String)
                        (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Delete)(path)(param)(lambda)

  def route[T <: SingleParamType](method: Method)(path: String)
                                 (param: T)(lambda: T => CompleteType): CompleteType
  = lambda(param)

  def post[T <: SingleParamType](path: String)
                                (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Post)(path)(param)(lambda)

  def get[T <: SingleParamType](path: String)
                               (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Get)(path)(param)(lambda)

  def put[T <: SingleParamType](path: String)
                               (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Put)(path)(param)(lambda)

  def delete[T <: SingleParamType](path: String)
                                  (param: T)(lambda: T => CompleteType): CompleteType
  = route[T](Delete)(path)(param)(lambda)

  def route(method: Method)(path: String)
           (lambda: () => CompleteType): CompleteType
  = lambda()

  def post(path: String)
          (lambda: () => CompleteType): CompleteType
  = route(Post)(path)(lambda)

  def get(path: String)
         (lambda: () => CompleteType): CompleteType
  = route(Get)(path)(lambda)

  def put(path: String)
         (lambda: () => CompleteType): CompleteType
  = route(Put)(path)(lambda)

  def delete(path: String)
            (lambda: () => CompleteType): CompleteType
  = route(Delete)(path)(lambda)


  type SingleParamType = Int | Long | String | Double | Boolean

  type CompleteType = Complete

}
