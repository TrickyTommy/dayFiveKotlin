package dayFive

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val orders = listOf(
        OrderModel(
            orderId = "SO-921",
            createdAt = "2018-02-17T03:24:12",
            customer = CustomerModel(id = 33, name = "Ari"),
            items = listOf(
                ItemModel(
                    id = 24,
                    name = "Sapu Lidi",
                    qty = 2,
                    price = 13200
                ),
                ItemModel(
                    id = 73,
                    name = "Sprei 160x200 polos",
                    qty = 1,
                    price = 149000
                )
            )
        ),
        OrderModel(
            orderId = "SO-922",
            createdAt = "2018-02-20T13:10:32",
            customer = CustomerModel(id = 40, name = "Ririn"),
            items = listOf(
                ItemModel(
                    id = 83,
                    name = "Rice Cooker",
                    qty = 1,
                    price = 258000
                ),
                ItemModel(
                    id = 24,
                    name = "Sapu Lidi",
                    qty = 1,
                    price = 13200
                ),
                ItemModel(
                    id = 30,
                    name = "Teflon",
                    qty = 1,
                    price = 190000
                )
            )
        ),
        OrderModel(
            orderId = "SO-926",
            createdAt = "2018-03-05T16:23:20",
            customer = CustomerModel(id = 58, name = "Annis"),
            items = listOf(
                ItemModel(
                    id = 24,
                    name = "Sapu Lidi",
                    qty = 1,
                    price = 13200
                )
            )
        )
    )
    val feb = orders.filter {
        val dateFormat = "yyyy-MM-dd'T'HH:mm:ss"
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        val date = formatter.parse(it.createdAt)
        val calender = Calendar.getInstance()
        calender.time = date
        calender.get(Calendar.MONTH) == 1


    }
    feb.forEach { println(it.customer.name) }
    val ari = orders.filter { it.customer.name == "Ari" }
    val grandTotalAri = ari.map {
        it.items
            .map { item -> item.price * item.qty }
            .reduce{ acc, i -> acc + i  }
    }
        .reduce{ acc, i -> acc + i }
    print("gran total $grandTotalAri")
}

