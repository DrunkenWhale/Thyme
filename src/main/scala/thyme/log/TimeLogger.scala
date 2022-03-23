package thyme.log

import java.sql.Timestamp

trait TimeLogger {
  final def logTime(): String = {
    Console.CYAN + f"[ ${new Timestamp(System.currentTimeMillis())}%-23s ]" + Console.RESET
  }
}
