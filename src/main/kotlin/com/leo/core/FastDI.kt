package com.leo.core

import com.leo.core.api.IFastDI

class FastDI: IFastDI {

    override val instanceRepo by lazy {
        InstanceRepo()
    }

}