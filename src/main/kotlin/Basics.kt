import kotlin.concurrent.thread

fun main() {

    println("Hello World")

    basics()

    workWithClasses()
}

fun workWithClasses() {
    //Creación de motores
    val motor1 = Car.Engine("Ferrari", 2000)
    val motor2 = Car.Engine("Opel",3000)
    val motor3 = Car.Engine("Ford",5000)


    //Creación de coches
    val fiatCar = Car("Fiat","500",1953,motor1)
    val porscheCar = Car("Porsche")
    porscheCar.model="911"
    porscheCar.year=1965
    porscheCar.engine=motor1
    val fordCar = Car("Ford", "Mustang", 1964, motor2)
    val mercedesCar = Car("Mercedes", "Gullwing", 1954, motor2)
    val volksCar = Car("Volkswagen", "Beetle", 1978, motor2)
    val jaguarCar = Car("Jaguar","E-Type",1961, motor3)

    //Creación de seguros.
    val insurance1 = fiatCar.InsuranceCarrier(Insurance.MAPFRE,3000f)
    val insurance2 = porscheCar.InsuranceCarrier(Insurance.ALLIANZ,2500f)
    val insurance3 = fordCar.InsuranceCarrier(Insurance.MUTUA, 1800f)
    val insurance4 = mercedesCar.InsuranceCarrier(Insurance.VERTI, 800f)
    val insurance5 = volksCar.InsuranceCarrier(Insurance.MAPFRE,2200f)
    val insurance6 = jaguarCar.InsuranceCarrier(Insurance.MUTUA,5000.50f)

    println(insurance1.Amount)
    println(insurance2.Amount)
    println(insurance3.Amount)
    println(insurance4.Amount)
    println(insurance5.Amount)
    println(insurance6.Amount)


    //Creación de programadores
    val master1 = Programmer("Santos",39, mutableListOf(fiatCar,porscheCar),ProgrammingLang.KOTLIN)
    println(master1)

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
