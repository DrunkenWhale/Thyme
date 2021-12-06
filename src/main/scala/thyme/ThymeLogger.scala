package thyme

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import io.AnsiColor._

object ThymeLogger {

    def work(context: ThymeContext): Unit = {
        logger(context)
    }


    private var logger: ThymeContext => Unit = (context: ThymeContext) => {
        val now = DateTimeFormatter.ofPattern("yyyy_MM_dd : HH:mm").format(LocalDateTime.now)
        printf("[ %s%s ]:    %s%s   %s%7s      %s%s\n",BLUE,now,GREEN,context.protocol,MAGENTA,context.method.value,WHITE,context.url.path)
     }

    def modifyLogger(logger: ThymeContext => Unit): Unit = {
        this.logger = logger
    }
}
