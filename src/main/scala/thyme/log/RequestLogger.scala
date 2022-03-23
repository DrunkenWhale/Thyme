package thyme.log

object RequestLogger extends ThymeLogger {

  override val color: String = Console.BLUE

  def logRequest(method: String, path: String, code: Int): Unit = {
    val codeColor = code match {
      case 200 => Console.GREEN
      case 400 => Console.RED
      case 401 => Console.WHITE
      case 402 => Console.BLINK
      case 403 => Console.YELLOW
      case 404 => Console.MAGENTA
      case 405 => Console.YELLOW
      case 500 => Console.RED
      case _ => Console.BLACK
    }
    val methodColor = method match {
      case "GET" => Console.GREEN
      case "POST" => Console.MAGENTA
      case "PUT" => Console.BLUE
      case "DELETE" => Console.RED
      case _ => Console.WHITE
    }
    logger(f"$methodColor$method%-7s  $codeColor$code%-7d  $color$path%s")
  }

}
