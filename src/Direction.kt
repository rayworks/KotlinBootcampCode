enum class Directions(val s: String) {

    NORTH("NORTH"),
    SOUTH("SOUTH"),
    EAST("EAST"),
    WEST("WEST"),
    START("START"),
    END("END");

    override fun toString(): String {
        return s
    }
}

class Location(val width: Int = 4, val height: Int = 4) {
    // [int][String]
    val map = Array(width) { arrayOfNulls<String>(height) }

    init {
        resetLocations()
    }

    fun resetLocations() {
        for (i in 0 until width)
            for (j in 0 until height)
                map[i][j] = "O"

        printMap()
    }

    private fun printMap() {
        println("Current location map :")

        for (p in 0..2 * width)
            print("*")
        println("")

        for (i in 0 until width) {
            for (j in 0 until height) {
                print(map[i][j])
                print(" ")
            }
            print("\n")
        }

        for (p in 0..2 * width)
            print("*")
        println("")
    }

    fun updateLocation(row: Int, column: Int): Boolean {
        return if (row in 0..(width - 1) && (column in 0..(height - 1))) {
            map[row][column] = "X"

            printMap()
            true
        } else {
            printMap()
            false
        }
    }
}

class Game {

    var path: MutableList<Directions> = mutableListOf(Directions.START)

    val location: Location = Location()

    var row: Int = 0
    var col: Int = 0

    init {
        location.updateLocation(row, col)
    }

    // NB:
    // def. like 'val north = { path.add(Directions.NORTH}()' will be executed at once.
    val north = {
        //println("north")

        if (location.updateLocation(row - 1, col)) {
            path.add(Directions.NORTH)
            row -= 1

            true
        } else {
            false
        }
    }
    val south = {
        //println("south");
        if (location.updateLocation(row + 1, col)) {
            path.add(Directions.SOUTH)
            row += 1

            true
        } else {
            false
        }
    }
    val east = {
        //println("east");
        if (location.updateLocation(row, col + 1)) {
            path.add(Directions.EAST)
            col += 1

            true
        } else {
            false
        }
    }
    val west = {
        //println("west");
        if (location.updateLocation(row, col - 1)) {
            path.add(Directions.WEST)
            col -= 1
            true
        } else {
            false
        }
    }

    val end = {

        path.add(Directions.END)
        print("Game Over: ")
        printPath()

        // reset the status
        location.resetLocations()
        row = 0
        col = 0

        path.clear()
        false
    }

    fun printPath() {
        println(path
                .joinToString(separator = ",", prefix = "[", postfix = "]"))
    }

    fun makeMove(str: String?) {
        when (str) {
            "NORTH" -> move(north)
            "SOUTH" -> move(south)
            "EAST" -> move(east)
            "WEST" -> move(west)

            else -> move(end)
        }
    }
}

fun move(where: () -> Boolean) {
    where()
}


fun main(args: Array<String>) {
    val game = Game()
    game.printPath()

    while (true) {
        print("Enter a direction: n/s/e/w:")
        val str = readLine()
        when (str) {
            "n" -> game.makeMove(Directions.NORTH.s)
            "s" -> game.makeMove(Directions.SOUTH.s)
            "e" -> game.makeMove(Directions.EAST.s)
            "w" -> game.makeMove(Directions.WEST.s)

            else -> game.makeMove("")
        }
    }

    /*game.north()
    game.south()
    game.east()
    game.west()
    game.end()*/
}