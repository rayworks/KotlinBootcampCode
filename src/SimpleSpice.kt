class SimpleSpice {
    var name = "curry"
    var spiciness = "mild"

    var heat: Number = 0
        get() =
            if (spiciness == "mild")
                5
            else
                0

}

class Spice(val name: String, val spiciness: String = "mild") {
    var head: Number = 0
        get() = if (spiciness == "mild")
            5
        else
            0

    init {
        println("Name:${this.name}, spiciness:${this.spiciness}")
    }
}

fun gen(): List<Spice> = listOf(Spice("sort"), Spice("spc one", "great"))
fun makeSalt(): Spice = Spice("salt")

fun main(args: Array<String>) {
    println(gen())
    println(makeSalt())
}