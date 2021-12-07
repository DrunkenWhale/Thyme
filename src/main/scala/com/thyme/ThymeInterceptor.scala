package com.thyme

/**
 * global interceptor
 * */

class ThymeInterceptor(val excludePath: Seq[String],
                       val interceptor: ThymeContext => Boolean) {

    /**
     * For the lambda function 'interceptor'
     *
     * @return true  => receive this request
     * @return false => refuse this request
     * singleton interceptor
     * multiply interceptor are hard realization
     * all right, i finish a beta interceptor class and it support multiply interceptor
     * hhh
     * */

}


object ThymeInterceptor {

    def apply(excludePath: Seq[String] = Seq(), interceptor: ThymeContext => Boolean): ThymeInterceptor = {
        new ThymeInterceptor(excludePath = excludePath, interceptor = interceptor)
    }

    def work(thymeContext: ThymeContext, thymeInterceptor: ThymeInterceptor): Boolean = {

        // path in excludePath
        if (thymeInterceptor.excludePath.contains(thymeContext.url.path.toString())) {
            true
        } else {
           thymeInterceptor.interceptor(thymeContext)
        }
    }

}