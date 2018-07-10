package spices

// Making Spice a sealed class helps keep all the spices together in one file.
sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) :
        SpiceColor by color {
    var head: Number = 0
        get() = if (spiciness == "mild")
            5
        else
            0

    init {
        println("Name:${this.name}, spiciness:${this.spiciness}")
    }

    abstract fun prepareSpice()
}

class Pepper : Spice("Pepper", color = RedColor) {
    override fun prepareSpice() {
        println("prepare pepper")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

object RedColor : SpiceColor {
    override val color: Color = Color.RED
}

class Curry(spiciness: String) :
        Spice("Curry", spiciness, YellowSpiceColor), Grinder {

    override fun grind() {
        println("grind now")
    }

    override fun prepareSpice() {
        println("Prepare the spice")
    }
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}


enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}

fun main(args: Array<String>) {
    val curry: Curry = Curry("A little")
    println("Spice Color : ${curry.color}")

    val spiceContainer = SpiceContainer(curry)
    println(spiceContainer.label)

    val pepper = Pepper()
    val spiceContainer2 = SpiceContainer(pepper)
    println(spiceContainer2.label)
}