
//import thyme.boot.ServerRegister

object Test {
  def main(args: Array[String]): Unit = {

    def te(LAM: (Int, String, Int))(x: ((Int, String, Int)) => Int) = {
      x(LAM)
    }

    println(te(1, "3", 2) { (a,b,c)=>
      a
    })


    //    ServerRegister
    //        .create()
    //        .mount[C]
    //        .mount[A]
    //        .mount[B]
    //        .register(9090, 7)
  }
}

trait D {

}

object D {

}

//class C {
//  @Route(method = Get, path = "/api/c/a")
//  def a(x: Int, c: String): Int = {
//    x + 7
//  }
//
//  @Route(method = Post, path = "/api/c/test")
//  def test(): Unit = {
//
//  }
//}
//
//class B {
//
//  @Route(method = Post, path = "/api/b/f")
//  def f(): Unit = {
//
//  }
//
//  @Route(method = Delete, path = "/api/b/u")
//  def u(): Unit = {
//
//  }
//}

class A {

}