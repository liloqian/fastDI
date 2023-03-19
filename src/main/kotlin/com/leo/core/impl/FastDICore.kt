package com.leo.core.impl

import com.leo.core.FastDIConfig
import com.leo.core.api.IFastDICore

class FastDICore(override val scope: String, override val fastConfig: FastDIConfig = FastDIConfig()) : IFastDICore {

    override val instanceRepo by lazy {
        FastDIRepo()
    }

}