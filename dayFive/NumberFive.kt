package dayFive

import java.io.File

fun main() {
//    val csv = "NAME, CATEGORY, PRICE\n" +
//            "Xiaomi Redmi 5A, Smartphone, 1199000\n" +
//            "Macbook Air, Laptop, 13775000\n" +
//            "Samsung Galaxy J7, Smartphone, 3549000\n" +
//            "DELL XPS 13, Laptop, 26799000\n" +
//            "Xiaomi Mi 6, Smartphone, 5399000\n" +
//            "LG V30 Plus, Smartphone, 10499000"

    val csv = File("src/main/kotlin/day/four/assets/data.csv").readText()
    val data = csv.split("\n")
    val headers = data.first().split(", ").map { it.toLowerCase() }
    val items = data.subList(1, data.lastIndex)

    val result = mutableListOf<ProductModel>()
    items.forEach {
        val product = it.split(", ")
        val productModel = ProductModel(product[0],product[1], product[2])

        result.add(productModel)
    }
    result.forEach { println("$it\n") }
}

data class ProductModel(var name: String, var price: String, var category: String)