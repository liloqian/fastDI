package com.leo.core.api

import com.leo.core.ProviderHolder

/**
 * DI logic impl
 */
interface IFastRepo {

    /**
     * inject provider to repo by class
     */
    fun <T> inject(clazz: Class<T>, provider: ProviderHolder<T>)

    /**
     * inject provider to repo by class and name
     */
    fun <T> inject(name: String, clazz: Class<T>, provider: ProviderHolder<T>)

    /**
     * get object by class, will create by provider
     */
    fun <T> get(name: String, clazz: Class<T>): T

    /**
     * opt object by class, will create by provider, this will return null when object not inject
     */
    fun <T> opt(name: String, clazz: Class<T>): T?
}