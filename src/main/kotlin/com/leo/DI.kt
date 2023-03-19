package com.leo

import com.leo.core.impl.FastDIContext

object DI {

    val fastDIContext by lazy {
        FastDIContext()
    }

}