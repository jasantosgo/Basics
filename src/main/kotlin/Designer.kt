class Designer(name: String, age : Int) : Person(name,age) {

    override fun introducePerson() {
        println("Soy muy original, mi nombre es $name y soy diseñador.")
    }

    override fun toString(): String {
        return "$name, diseñador de $age años. Follow me!"
    }
}