package com.leo.core.impl

import com.leo.core.FastDIException
import com.leo.core.Key
import com.leo.core.ProviderHolder
import com.leo.core.api.IFastRepo
import com.leo.core.cast

class FastDIRepo : IFastRepo {

    private val providerMap = hashMapOf<Key, ProviderHolder<*>>()
    override fun <T> inject(clazz: Class<T>, provider: ProviderHolder<T>) {
        val key = Key.create(clazz)
        providerMap[key] = provider
    }

    override fun <T> inject(name: String, clazz: Class<T>, provider: ProviderHolder<T>) {
        val key = Key.create(clazz, name)
        providerMap[key] = provider
    }

    override fun <T> get(name: String, clazz: Class<T>): T {
        val key = Key.create(clazz, name)
        providerMap[key]?.also {
            return cast(it.value())
        } ?: kotlin.run {
            throw FastDIException("$key do not inject....")
        }
        return cast(Object())
    }

    override fun <T> opt(name: String, clazz: Class<T>): T? {
        val key = Key.create(clazz, name)
        providerMap[key]?.also {
            return cast(it.value())
        } ?: kotlin.run {
            return null
        }
        return cast(Object())
    }
}