fun <E> List<out E>.filter3(predicate: (E) -> Boolean): List<E> {
    return this.filter(predicate).toMutableList()
}

fun main(args: Array<String>) {
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    println(numbers
            .filter3 { i: Int -> i % 3 == 0 }
            .joinToString(separator = ",", prefix = "[", postfix = "]"))
}

// answer:
fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}