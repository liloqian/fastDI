package com.leo.core.api

/**
 * DI basic interface
 */
interface IFastDICore {

    /** scope name */
    val scope: String

    /** repo */
    val instanceRepo: IFastRepo
}