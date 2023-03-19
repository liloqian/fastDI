package test

import com.leo.core.api.IDI
import com.leo.core.api.IFastRepo
import com.leo.dsl.inject
import com.leo.dsl.injectOrNull

class ModuleA(override val diCore: IFastRepo) : IDI {

    private val book by inject<Book>()

    private val people by injectOrNull<People>()

    fun test() {
        println("-----module A------")
        println("book:$book")
        println("people:$people")
    }

}