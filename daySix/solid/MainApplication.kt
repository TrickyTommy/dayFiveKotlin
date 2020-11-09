package daySix.solid

fun main(){
    val mainApplication = MainApplication()
    val user = mainApplication.getUsers()
    mainApplication.showuser(user)

}
class MainApplication {
    fun getUsers() : List<String>{
        return (1..100).toList().asSequence().map { "user $it" }.toList()
    }

    fun showuser(user: List<String>){
        print(user)
    }
}