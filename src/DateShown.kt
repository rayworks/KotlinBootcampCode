import java.util.*

fun main(args: Array<String>) {
    // Run - Edit configuration to set the params
    //println("${if (args[0].toInt() < 12) "Good morning" else "Good night"} Kotlin")

    var fortuneCookie: String
    //for (i in 1..10)
    var count = 0;
    while (count < 10) {
        fortuneCookie = getFortune(getBirthday()) //getFortuneCookie()
        println("\nYour fortune is: $fortuneCookie")

        if (fortuneCookie.startsWith("Take it easy"))
            break

        ++count

    }

    /*println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))*/


}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    var size: Double =
            if (hasDecorations) {
                0.8 * tankSize
            } else {
                tankSize
            }

    /*for (i in currentFish) {
        size -= i.toDouble()
    }*/

    return (size - currentFish.sum() - fishSize) >= 0
}

fun getFortuneCookie(): String {
    val birthday = getBirthday()

    return fortuneFrom(birthday)
}

private fun fortuneFrom(birthday: Int): String {
    val list = listOf("You will have a great day!", "Things will go well for you today",
            "Enjoy a wonderful day of success.", "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    var index = birthday / list.size //- 1
    //index = Math.max(0, index)
    index = Math.min(index, list.size - 1)
    return list[index]
}

// ext
fun getFortune(birthday: Int): String {
    return when (birthday) {
        28, 31 -> "N/A"
        in (1..7) -> "N/A"
        else -> fortuneFrom(birthday)
    }
}

private fun getBirthday(): Int {
    print("Enter your birthday: ")

    val input: String? = readLine() //?.toIntOrNull()
    val birthday = input?.toIntOrNull() ?: 1
    return birthday
}

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    println(when (day) {
        Calendar.SUNDAY -> ("SUNDAY")
        Calendar.MONDAY -> ("MONDAY")
        Calendar.TUESDAY -> ("TUESDAY")
        Calendar.WEDNESDAY -> ("WEDNESDAY")
        Calendar.THURSDAY -> ("THURSDAY")
        Calendar.FRIDAY -> ("FRIDAY")
        Calendar.SATURDAY -> ("SATURDAY")
        else -> ("Time has stopped")
    })
}