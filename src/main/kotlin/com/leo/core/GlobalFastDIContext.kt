package com.leo.core

import com.leo.core.api.IFastDI
import com.leo.core.api.IFastDIContext

class GlobalFastDIContext: IFastDIContext {

    override val fastDI: IFastDI by lazy { FastDI() }

}