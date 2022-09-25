open class Person (protected var name : String, protected var age : Int) {

    protected var carsList : MutableList<Car> = mutableListOf()


    val CarList : MutableList<Car>
        get() = carsList

    constructor(name : String, age : Int, carsList : MutableList<Car> ) : this(name,age) {
        this.carsList = carsList
    }

    open fun introducePerson() {
        println("Hola, mi nombre es $name y mi edad es $age")
    }


}