package thyme

import scala.Boolean.unbox

class ThymeInterceptor(val excludePath: List[String],
                       val interceptor: ThymeContext => Boolean) {

    /**
     * For the lambda function 'interceptor'
     *
     * @return true  => receive this request
     * @return false => refuse this request
     * singleton interceptor
     * multiply interceptor are hard realization
     * */

}


object ThymeInterceptor {

    def apply(excludePath: List[String] = List(), interceptor: ThymeContext => Boolean): ThymeInterceptor = {
        new ThymeInterceptor(excludePath = excludePath, interceptor = interceptor)
    }

    def work(thymeContext: ThymeContext, thymeInterceptor: ThymeInterceptor): Boolean = {
        if (thymeInterceptor.excludePath.contains(thymeContext.url.path)) {
            true
        } else {
            unbox(thymeInterceptor.interceptor(thymeContext))
        }
    }

}