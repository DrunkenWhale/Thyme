package thyme

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

object ThymeLogger {

    def work(context: ThymeContext): Unit = {
        logger(context)
    }


    private var logger: ThymeContext => Unit = (context: ThymeContext) => {
        val now = DateTimeFormatter.ofPattern("yyyy_MM_dd : HH:mm").format(LocalDateTime.now)
        println(s"[ $now ]:   ${context.protocol}   ${context.method.value}   ${context.url.path}")
    }

    def modifyLogger(logger: ThymeContext => Unit): Unit = {
        this.logger = logger
    }
}
