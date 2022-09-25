fun main() {

    println("Hello World")

    basics()

    workWithClasses()
}

fun workWithClasses() {
    val myCar= Car("Seat")
}

fun basics() {
    val myArray: ArrayList<String> = arrayListOf()
    print("Escribe una palabra:")
    val palabra = readLine()

    println(palabra?.length)
    myArray.add("jose")
    myArray.add("santos")

    myArray.forEach { elemento ->
        println(elemento)
    }

    val myMap: MutableMap<Int, String> = mutableMapOf(1 to "Jose", 2 to "santos")


    myMap.forEach {key, value ->
        println("Clave ${key} cuyo valor es ${value}")
    }

    var myVar : Int? = null

    myVar = 1
    myVar?.let {
        println(it)
    }
}
