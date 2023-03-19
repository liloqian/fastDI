package test

import com.leo.dsl.*

fun main() {
    // basic use
    DI.repo {
        instance { "new" }
        instance { "two" }
        instance { Book("Hello Ktor", 1.1f) }
        instance { House("instance", 1.1f) }
        inject("one") { House("one", 1.1f) }
        inject("two") { House("two", 1.1f) }
        inject("three") { House("three", 1.1f) }

    }
    DI.repo {
        val valueNew = get<String>()
        println(valueNew)
        println(opt<Book>())
        println(opt<House>("one"))
        println(opt<House>())
        println(opt<House>("two"))
        println(opt<House>())
    }
    // between module
    DI.diCore {
        repo {
            instance { ModuleA(this) }
            instance { ModuleB(this) }
        }
    }
    println("---------1---------")
    val moduleA = DI.fastDIContext.globalFastDI.instanceRepo.get<ModuleA>()
    val moduleB = DI.fastDIContext.globalFastDI.instanceRepo.get<ModuleB>()
    println("---------2---------")
    moduleA.test()
    moduleB.test()
}

data class Book(val name: String, val price: Float)
data class House(val name: String, val price: Float)
data class People(val name: String, val price: Float)