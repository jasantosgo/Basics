data class Worker(
    val name : String = "",
    val age : Int = 0,
    val salary : Float = 0f,
    val cars : MutableList<Car> = mutableListOf()
) {
    //implementación de funciones.
    fun showSalary() {
        println("$name gana $salary Euros.")
    }
}
