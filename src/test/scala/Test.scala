import extarctor.Method.{Get, Post}
import extarctor.Route

object Test {  
  def main(args: Array[String]): Unit = {
    val l: Int => Int  = (x: Int) => x * 7
    println(extarctor.extract(new   c))
  }  

}

class  c {
  @Route(method = Get, path = "/api/route")
  def a(x: Int,c:String): Int = {
    x + 7
  }

  @Route(method = Post, path = "/api/route")
  def test(): Unit ={

  }
} 
   