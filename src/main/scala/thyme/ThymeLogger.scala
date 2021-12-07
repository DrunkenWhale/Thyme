package thyme

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import io.AnsiColor._

object ThymeLogger {

    def work(context: ThymeContext,statusCode :Int): Unit = {
        logger(context,statusCode)
    }


    private var logger: (ThymeContext,Int) => Unit = (context: ThymeContext,statusCode:Int) => {
        val now = DateTimeFormatter.ofPattern("yyyy_MM_dd : HH:mm").format(LocalDateTime.now)
        printf("[ %s%s ]:    %s%s   %s%-7s   %s%s   %s%d\n",
            BLUE, now, GREEN, context.protocol, MAGENTA, context.method.value, WHITE, context.url.path,CYAN,statusCode)
    }

    def modifyLogger(logger: (ThymeContext,Int) => Unit): Unit = {
        this.logger = logger
    }
}
