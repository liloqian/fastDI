package com.leo.core.impl

import com.leo.core.api.IFastDICore

class FastDICore(override val scope: String) : IFastDICore {

    override val instanceRepo by lazy {
        FastDIRepo()
    }

}