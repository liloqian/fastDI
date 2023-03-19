package com.leo

import com.leo.core.GlobalFastDIContext
import com.leo.core.api.IFastDIContext
import com.leo.core.api.IFastRepo
import com.leo.core.api.ValueHolder

fun IFastRepo.inject(config: IFastRepo.() -> Unit) {
    config.invoke(this)
}

fun IFastDIContext.repo(config: IFastRepo.() -> Unit) {
    fastDI.instanceRepo.config()
}

inline fun <reified T : Any> IFastRepo.inject(key: String) = lazy { get(key) }

fun main() {
    val di = GlobalFastDIContext()
    di.repo {
        inject("one", ValueHolder { "ValueOne" })
        inject("two", ValueHolder { "ValueTwo" })
        inject("three", ValueHolder { "ValueThree" })
    }
    di.repo {
        val value: String = get("one") as String
        val value2: String = get("two") as String
        val value3: String = get("three") as String
        val value4 by inject<String>("one")
        println(value)
        println(value2)
        println(value3)
        println(value4)

    }
}