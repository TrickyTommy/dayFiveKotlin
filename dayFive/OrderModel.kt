package dayFive

data class OrderModel(
	val createdAt: String,
	val orderId: String,
	val items: List<ItemModel>,
	val customer: CustomerModel
)

data class CustomerModel(
	val name: String,
	val id: Int
)

data class ItemModel(
	val price: Int,
	val qty: Int,
	val name: String,
	val id: Int
)

