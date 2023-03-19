package test

import com.leo.core.api.IDI
import com.leo.core.api.IFastRepo

class ModuleA(override val diCore: IFastRepo) : IDI {
    private val book by get<Book>()
}