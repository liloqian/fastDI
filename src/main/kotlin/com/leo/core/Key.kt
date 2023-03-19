package com.leo.core

import java.lang.reflect.Type

/**
 * key for repo index
 */
class Key private constructor(type: Type, name: String = "") {

    private var type: Type? = type

    private var name: String? = name

    companion object {
        fun create(type: Type, name: String = ""): Key {
            return Key(type, name)
        }
    }

    override fun toString(): String {
        return "[type:${type?.typeName} ,name:$name]"
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is Key) {
            false
        } else {
            type == other.type && name == other.name
        }
    }

    override fun hashCode(): Int {
        val nameCode = if (this.name.isNullOrEmpty()) {
            0
        } else {
            this.name.hashCode()
        }
        return nameCode or this.type.hashCode()
    }

}