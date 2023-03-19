package com.leo.core

/**
 * self exception
 * */
class FastDIException(override val message: String = "") : Exception(message) {

    override fun toString(): String {
        return "FastDIException ${super.toString()}"
    }
}