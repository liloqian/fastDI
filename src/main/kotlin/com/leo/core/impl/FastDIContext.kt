package com.leo.core.impl

import com.leo.core.FastDIConfig
import com.leo.core.GLOBAL_SCOPE
import com.leo.core.api.IFastDICore
import com.leo.core.api.IFastDIContext

class FastDIContext(override val fastConfig: FastDIConfig = FastDIConfig()) : IFastDIContext {

    private val diCoreMap = mutableMapOf<String, IFastDICore>()

    override val globalFastDI: IFastDICore by lazy {
        FastDICore(GLOBAL_SCOPE).apply {
            diCoreMap[scope] = this
        }
    }

    override fun scopeDI(scope: String): IFastDICore {
        diCoreMap[scope]?.also {
            return it
        }
        return FastDICore(scope).apply {
            diCoreMap[scope] = this
        }
    }

}