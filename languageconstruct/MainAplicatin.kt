package languageconstruct

import java.lang.IllegalArgumentException


//castoperator
fun main(){
    val any: Any = booleanArrayOf()
    val string =any as? String ?: "" //cara aman
    println(string?.length)

    //null safety
    val text: String? = null
    if (text !=null){
        println(text.length)
    }else{
        println("empty")
    }
    //cara simple elvis operator
    print(text?.length ?:0)

    //scoopfunction
    text?.let { println(it) }

    //exceptiom
    fun getexeption(number: Int): String {
        when {
            number % 5 == 0 -> return "nice"
            number % 4 == 0 -> throw IllegalArgumentException("modulo empat")
            number % 3 == 0 -> throw RuntimeException("modulo empat")
            number % 2 == 0 -> throw ArithmeticException("modulo empat")
            else -> throw Exception("else")
        }
//        try {
//
//            val random = (1..100).random()
//
//            print(random)
//            getexeption(4)
//
//        }catch (exc: IllegalArgumentException) {
//            exc.printStackTrace()
//            println("illegal ${exc.message}")
//        }catch (exc: Exception){
//            exc.printStackTrace()
//            print("exceptiion ${exc.message}")
//
//        }finally {
//            print("always execute")
//
//        }

        //scoope function
        (1..100).asSequence().let { println(it.filter { item -> item % 2 == 0  }.toList()) }
        (1..100).asSequence().run {
            print(filter { it % 2 == 0 }.toList())
        }
        with((1..100).asSequence()){
            print(filter { it % 2 == 0 }.toList())
        }

        val d = (1..100).asSequence().apply {
            map { it + 1 }
            filter { it % 2 == 0 }
        }
        print(d.toList())

        val e = (1..100).asSequence().also {
            println("${it.map { item -> item + 1 }.toList()}")
            println("${it.filter {item -> item % 2 == 0 }.toList()}")
        }

        print(e.toList())

    }

}