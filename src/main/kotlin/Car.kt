class Car(brand : String) {

    //Al declararlo en el cuerpo de la clase, en su constructor no puede declararse, aunque sí llamarse por lo que no lleva "val"
    private val brand: String
    var model: String = ""
    var year: Int? = null

    //bloque de inicialización. Se puede eliminar por la inicialización en la propia declaración.
    init {
        this.brand = ""
    }

    //constructor secundario.
    constructor(brand: String, model: String, year: Int?) : this(brand) {
        this.model = model
        this.year = year
    }

    //clase anidada (NestedClass) -> No puede acceder a atributos de la clase externa.
    class Engine(private val horsePower : Int) {

        //getter
        val HorsePower : Int
            get() = horsePower

    }

    //clase interna (InnerClass) -> Puede acceder a atributos de la clase externa.
    inner class InsuranceCarrier (private val myInsurance : Insurance, private val amount : Float){

        //getters
        val MyInsurance : String
            get() = myInsurance.title
        val Amount : String
            get() = "El precio del seguro del coche $brand $model del año $year es ${amount} euros."
    }
}