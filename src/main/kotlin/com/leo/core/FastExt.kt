package com.leo.core


/**
 * obj to T object, suppress UNCHECKED_CAST
 */
@Suppress("UNCHECKED_CAST")
fun <T> cast(obj: Any?): T {
    if (obj == null) {
        throw FastDIException("cast obj is null. ")
    }
    return obj as T
}

const val GLOBAL_SCOPE = "global_scope"