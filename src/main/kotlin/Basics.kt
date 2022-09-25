import kotlin.concurrent.thread

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
    //val palabra = readLine()

    //println(palabra?.length)
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

    //Uso de lambda del sistema.
    var intValues = 1..10
    val filteredNumbers = intValues.filter {x ->
        x>6
    }
    println(filteredNumbers)

    //Creación de funciones que pueden ser llamadas.
    val sumList = fun (lista : IntRange) : Int = lista.sumOf { it }
    val productList = fun (lista : IntRange) : Int {
        var product=1
        lista.forEach {
            product*=it
        }
        return product
    }

    //lamadas a las funciones anteriores.
    val resultSum = sumList(intValues)
    val resultProd = productList(intValues)

    //Bajo esta función se ha creado la función lambda. Aquí se llama a esa función Lambda, con parámetros.
    val resultSum2 = lambdaListFun(intValues, sumList)
    val resultProd2 = lambdaListFun(intValues, sumList)

    //Uso de Lambda sin llamar a las funciones específicas, usando {} y le damos el comportamiento que queramos.
    var counter=0
    val resultSum3 = lambdaListFun(intValues) {
        for(elem in it) {
            if(elem.mod(2)==0)
                counter+=elem
        }
        counter
    }

    println("La suma final es: $resultSum3")

    //Muestra los resultados.
    println("Suma: $resultSum \nProducto: $resultProd")
    println("Suma: $resultSum2 \nProducto: $resultProd2")



}

private fun lambdaListFun (list : IntRange, operateList: (list : IntRange)->Int) : Int {
    return operateList(list)
}
