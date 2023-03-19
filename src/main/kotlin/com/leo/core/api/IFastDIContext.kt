package com.leo.core.api

import com.leo.core.FastDIConfig

/**
 * DI Context support for business
 */
interface IFastDIContext {

    /** global scope */
    val globalFastDI: IFastDICore

    /** config */
    val fastConfig: FastDIConfig

    /** self scope */
    fun scopeDI(scope: String): IFastDICore

}