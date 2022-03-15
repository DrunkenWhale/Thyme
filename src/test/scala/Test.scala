import boot.ServerRegister
import extarctor.Method.{Get, Post}
import extarctor.Route

object Test {
  def main(args: Array[String]): Unit = {
    println (extarctor.te())
//      new ServerRegister(port = 9090)
  }

}

class c {
  @Route(method = Get, path = "/api/route")
  def a(x: Int, c: String): Int = {
    x + 7
  }

  @Route(method = Post, path = "/api/route")
  def test(): Unit = {

  }
}
