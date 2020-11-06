package dayFive

import java.io.File

data class FruitModel(
	val id: Int,
	val name: String,
	val price: Int
){
	override fun toString(): String {
		return "{\"id\": $id,\"name\": \"$name\",\"price\": $price}"
	}

}

fun main(){
	val fruits = listOf(
		FruitModel(21,"pears",69),
		FruitModel(21,"pears",69),
		FruitModel(21,"pears",69),
		FruitModel(21,"pears",69),
		FruitModel(21,"pears",69),
		FruitModel(21,"pears",69)
	)

	fruits.map { it.toString()}.forEach { println(it) }

	val file =File("/home/pc-6/dayFive1/src/main/kotlin/dayFive/file.json")
	file.createNewFile()
	file.writeText(fruits.toString())
	///
	val berrys =fruits.filter { it.name.contains("berry",true) }
	berrys.forEach{ println(it)}

	///
	val betweenFifty= fruits.filter { it.price in 50..100}
	betweenFifty.forEach{ println(it)}


}

