package com.leo.core

import com.leo.core.api.IFastRepo
import com.leo.core.api.ValueHolder
import java.lang.Exception

class InstanceRepo: IFastRepo {

    private val safeMap = hashMapOf<String, ValueHolder<*>>()

    override fun inject(key: String, holder: ValueHolder<Any>) {
        safeMap[key] = holder
    }

    override fun get(key: String): Any {
        safeMap[key]?.also {
            return it.instance.invoke() as Any
        } ?: kotlin.run {
            throw Exception("$key do not inject....")
        }
        return Object()
    }
}