class Programmer(nombre: String, edad: Int, carsList : MutableList<Car>, private val language : ProgrammingLang) : Person(nombre, edad, carsList) {

    private var programsCreated : MutableList<String> = mutableListOf()

    override fun introducePerson() {
        super.introducePerson()
        println("Además, soy programador especialista en $language")
    }

    fun createProgram(program : String) {
        programsCreated.add(program)
    }

    fun showPrograms() {
        if(programsCreated.size==0) {
            println("Todavía no he creado ningún programa.")
        } else {
            println("Ya he creado ${programsCreated.size} programas. Estos programas son:")
            programsCreated.forEach {
                println(it)
            }
        }
    }

    override fun toString(): String {
        //return super.toString()
        var presentation = "Hola mundo, soy $name.\n"
        if(carsList.size==0) {
            presentation+="Soy un tieso y no tengo carros.\n"
        } else {
            presentation+="Estos son mis tesoros:\n"
            carsList.forEach {
                presentation+="${it.toString()}\n"
            }
        }
        presentation+="Soy un master coder del lenguaje $language."
        if(programsCreated.size==0) {
            presentation+="Todavía no he creado ningún programa."
        } else {
            presentation+="Ya he creado ${programsCreated.size} programas. Estos programas son:"
            programsCreated.forEach {
                presentation+="$it\n"
            }
        }
        return presentation
    }
}

enum class ProgrammingLang {
    JAVA,
    CPP,
    KOTLIN,
    PYTHON
}