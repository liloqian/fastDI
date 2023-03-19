package com.leo.core.api

import com.leo.core.FastDIConfig

/**
 * DI basic interface
 */
interface IFastDICore {

    /** scope name */
    val scope: String

    /** repo */
    val instanceRepo: IFastRepo

    /** config */
    val fastConfig: FastDIConfig
}