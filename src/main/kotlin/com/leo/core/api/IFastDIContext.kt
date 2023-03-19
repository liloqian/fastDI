package com.leo.core.api

/**
 * DI Context support for business
 */
interface IFastDIContext {

    /** global scope */
    val globalFastDI: IFastDICore

    /** self scope */
    fun scopeDI(scope: String): IFastDICore

}