package com.leo.dsl

import com.leo.core.impl.FastDIContext

object DI {

    val fastDIContext by lazy {
        FastDIContext()
    }

}