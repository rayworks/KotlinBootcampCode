import java.util.*

var rollDice: (Int) -> Int = { side -> if (side == 0) 0 else Random().nextInt(12) + 1 }

var rollDice2: (Int) -> Int = rollDice

/***
 * Answer:
 * val rollDice0 = { sides: Int ->
 *     if (sides == 0) 0
 *     else Random().nextInt(sides) + 1
 * }
 */
fun main(args: Array<String>) {
    //println(rollDice2(2))

    gamePlay(rollDice2)
}

fun gamePlay(roll: (Int) -> Int) {
    println(roll(2))
}

data class RationalNumber(val numerator: Int, val denominator: Int)

fun Int.r():RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first, this.second)