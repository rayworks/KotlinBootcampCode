import java.util.*

fun main(args: Array<String>) {
    /*for (s in args)
        println(s)

    println("Hello Kt!")

    println(getList().toTypedArray().joinToString())*/

    var spice = SimpleSpice()
    println("name:${spice.name} | heat:${spice.heat}")
}

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    var co: Collection<Int> = listOf(1, 3, 5);
    val contained = co.any({ it % 2 == 0 })
    println("With even : $contained")

    return arrayList.sortedDescending()
    //Collections.sort(arrayList, kotlin.Comparator { o1, o2 -> o1 - o2 })
    //return arrayList
}

fun toJSON(collection: Collection<Int>): String {
    val cnt: Int = collection.size;
    var builder: StringBuilder = StringBuilder("[")
    collection.forEachIndexed { index, i ->
        run {
            builder.append(i)
            if (index != cnt - 1) {
                builder.append(", ")
            }
        }
    }
    builder.append("]")

    return builder.toString()
}

class LazyProperty(val initializer: () -> Int) {

    var count = 0

    val lazy: Int
        get() {
            if (count == 0)
                count = initializer.invoke()
            return count
        }
}

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()