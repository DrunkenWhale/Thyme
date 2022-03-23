package thyme.log

import scala.io.AnsiColor

trait ThymeLogger extends TimeLogger {

  val color: String

  def logger(message: String): Unit = {
    println(f"${super.logTime()}%10s     $color$message${Console.RESET}%10s ")
  }

}
