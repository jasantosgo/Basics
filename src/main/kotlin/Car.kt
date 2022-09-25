class Car(brand : String) : Vehicle {

    //Al declararlo en el cuerpo de la clase, en su constructor no puede declararse, aunque sí llamarse por lo que no lleva "val"
    private var brand: String = brand
    var model: String = ""
    var year: Int? = null
    var engine : Car.Engine? = null

    //bloque de inicialización. Se puede eliminar por la inicialización en la propia declaración.
//    init {
//        this.brand = ""
//    }

    //constructor secundario.
    constructor(brand: String, model: String, year: Int?, engine : Car.Engine) : this(brand) {
        this.model = model
        this.year = year
        this.engine = engine
    }

    //clase anidada (NestedClass) -> No puede acceder a atributos de la clase externa.
    class Engine(private val manufacturer : String, private val horsePower : Int) {

        //getter
        val Manufacturer : String
            get() = manufacturer
        val HorsePower : Int
            get() = horsePower

    }

    //clase interna (InnerClass) -> Puede acceder a atributos de la clase externa.
    inner class InsuranceCarrier (private val myInsurance : Insurance, private val amount : Float){

        //getters
        val MyInsurance : String
            get() = myInsurance.title
        val Amount : String
            get() = "El precio del seguro del coche $brand $model del año $year es ${amount} euros. La aseguradora es $MyInsurance"
        val AmountFloat : Float
            get() = amount
    }

    //Implementaciones de la interfaz.
    override val vehicle: String
        get() = "coche: $brand $model del año $year"

    override fun navigate() {
        println("El coche está circulando por la carretera.")
    }

    override fun toString(): String {
        return "coche: $brand $model de $year."
    }

}