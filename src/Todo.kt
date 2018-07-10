fun main(args: Array<String>) {
    println(whatShouldIDoToday())
}

fun whatShouldIDoToday(weather: String = "sunny", temperature: Int = 24): String {
    val mood = getMood()

    return when {
        isGoodForAWalk(mood, weather) -> "go for a walk"
        inBed(mood, weather, temperature) -> "stay in bed"
        needToGoSwimming(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}


private fun needToGoSwimming(temperature: Int) = temperature > 35

private fun isGoodForAWalk(mood: String, weather: String) = mood == "happy" && weather == "Sunny"

private fun inBed(mood: String, weather: String, temperature: Int) =
        mood == "sad" && weather == "rainy" && temperature == 0

private fun getMood(): String = readLine()!!