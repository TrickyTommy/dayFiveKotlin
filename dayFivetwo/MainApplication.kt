package dayFivetwo

import java.lang.StringBuilder

fun main(){
    val list = listOf(1,2,3,4)

    val iterator = list.iterator()

    list.forEach{ println(it)}

//    while (list.iterator().hasNext()){
//        println(iterator.next())
//
//    }

    ///squence

    val sequence = sequenceOf(1,2,3,4)
    val squencelist = list.asSequence()
    ///
    var generate = generateSequence(1){it + 1}
    generate.take(100).forEach{ println("generate $it") }
    ///

    generate.filter {it %2 == 0}
        .map { "Genap $it" }
        .take(10)
        .drop(2)
        .forEach { println(it) }

    ////
    println("batas ooyoyoy")
    val data = listOf("1","2","3").asSequence()
    data.map{ it.toInt() * 3}.forEach { println(it) }
    data.mapIndexed{ index, s -> s.toInt() * index  }.forEach (::println )
    data.mapNotNull { if(it.toInt() % 2 == 0) null else it.toInt() }
        .forEach { println("not null$it") }
    data.mapIndexedNotNull{ index, s -> if (index % 2 == 0) null else s.toInt()  }.forEach { println("map indexednotnull $it") }
///
    val numbers = listOf(1,2,3).asSequence()
    val caracters = listOf("1","2","3","0").asSequence()

    val combine = numbers zip caracters
    println("ziiip${combine.toList()}")

    ///tanpa infix
    val combinea= numbers.zip(caracters) {
        number, char -> "Number: $number -> char: $char"

    }
    println("ziiip not infix${combine.toList()}")

    ///
    val a =(1..100).asSequence().map { "Value $it"  }
    mapOf("value 1" to 8)
    println(a.associateWith { it.length })
    println("associateby ${a.associateBy { it.last() }}")


    ////
    val b = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
    println(b)
    println("flatten ${b.flatten()}")
    ///stringrepesentation
    val ba = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
    println(ba)
    println("joinTostring ${ba.flatten().joinToString(" ")}")
////
    val baa = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
    println(baa)
    println("joinTo ${ba.flatten().joinTo(StringBuilder("List:"))}")
    println("joinToString postfix ${ba.flatten().joinToString(prefix = "List: ",postfix = "done")}")
    println("joinToString postfix dengan limit ${ba.flatten().joinToString(prefix = "List: ",postfix = "done", limit = 4)}")

///filtering
    println("Filtering")
val c = (1..100).filter { it % 5 == 0 }
    println(c)

    val d = listOf("one","two","tree","four","five")
    val (match, rest) = d.partition { it.length > 3 }

    println("Data yang cocok: $match")
    println("tidak cocok $rest")

}