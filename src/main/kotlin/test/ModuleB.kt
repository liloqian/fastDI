package test

import com.leo.core.api.IDI
import com.leo.core.api.IFastRepo
import com.leo.dsl.inject

class ModuleB(override val diCore: IFastRepo) : IDI {

    private val moduleA by inject<ModuleA>()

    private val house by inject<House>()

    fun test() {
        println("---moduleB-----")
        println(house)
        moduleA.test()
    }
}