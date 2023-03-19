package com.leo.core.api

interface IFastRepo {

    fun inject(key: String, holder: ValueHolder<Any>)

    fun get(key: String): Any
}

class ValueHolder<T>(
    val instance: () -> T
)