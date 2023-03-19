package com.leo.core

class ProviderHolder<T>(
    private val instance: () -> T
) {

    private val _value: T by lazy {
        instance.invoke()
    }

    fun value(): T {
        return _value
    }
}