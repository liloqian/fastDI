package com.leo.dsl

import com.leo.core.ProviderHolder
import com.leo.core.api.IDI
import com.leo.core.api.IFastDIContext
import com.leo.core.api.IFastDICore
import com.leo.core.api.IFastRepo

fun DI.repo(config: IFastRepo.() -> Unit) {
    fastDIContext.globalFastDI.instanceRepo.config()
}

fun DI.diCore(config: IFastDICore.() -> Unit) {
    fastDIContext.globalFastDI.config()
}

fun IFastDICore.repo(config: IFastRepo.() -> Unit) {
    instanceRepo.config()
}

/**
 * default repo is global, can inject or get anything
 * make code more fast :)
 */
fun IFastDIContext.repo(config: IFastRepo.() -> Unit) {
    globalFastDI.instanceRepo.config()
}

/**
 * DSL instance only support one object for this class, the latter covers the front
 */
inline fun <reified T> IFastRepo.instance(crossinline provider: () -> T) {
    inject(T::class.java, ProviderHolder { provider.invoke() })
}

/**
 * DSL instance support more than one object for this class
 */
inline fun <reified T> IFastRepo.inject(crossinline provider: () -> T) {
    inject(T::class.java, ProviderHolder { provider.invoke() })
}

/**
 * DSL instance support more than one object for this class
 */
inline fun <reified T> IFastRepo.inject(name: String, crossinline provider: () -> T) {
    inject(name, T::class.java, ProviderHolder { provider.invoke() })
}

/**
 *  DSL get object, this will throw exception when object not inject
 */
inline fun <reified T> IFastRepo.get(name: String = ""): T {
    return get(name, T::class.java)
}

/**
 *  DSL opt object, this will return null when object not inject
 *  more safely
 */
inline fun <reified T> IFastRepo.opt(name: String = ""): T? {
    return opt(name, T::class.java)
}

/**
 * support quick get for DI
 */
inline fun <reified T> IDI.inject(key: String = "") = lazy { diCore.get(key, T::class.java) }


/**
 * support quick opt for DI
 */
inline fun <reified T> IDI.injectOrNull(key: String = "") = lazy { diCore.opt(key, T::class.java) }

