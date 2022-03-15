import boot.ServerRegister
import extarctor.Method.{Delete, Get, Post}
import extarctor.Route

object Test {
  def main(args: Array[String]): Unit = {
    ServerRegister
        .create()
        .mount[C]
        .mount[A]
        .mount[B]
        .register(9090,7)
  }

}

class C {
  @Route(method = Get, path = "/api/c/a")
  def a(x: Int, c: String): Int = {
    x + 7
  }

  @Route(method = Post, path = "/api/c/test")
  def test(): Unit = {

  }
}

class B{

  @Route(method = Post, path = "/api/b/f")
  def f(): Unit ={

  }

  @Route(method = Delete,path = "/api/b/u")
  def u(): Unit ={

  }
}

class A{

}