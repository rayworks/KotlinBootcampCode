import java.util.*

const val MAX_BORROWED_BOOKS = 10;


open class Book(var title: String, val author: String, val year: Int = 2018) {

    var pages: Int = 0;

    companion object { //default name is 'Companion'
        val BASE_URL: String = "http://books/base/"
    }

    private var currentPage: Int = 0

    private var borrowedCnt = 0;
    open fun readPage() {
        ++currentPage
    }

    fun borrow(): Boolean {
        if (borrowedCnt < MAX_BORROWED_BOOKS) {
            ++borrowedCnt;
            return true
        }
        return false
    }

    fun canBorrow(): Boolean = borrowedCnt < MAX_BORROWED_BOOKS

    fun printUrl() {
        println("url : ${BASE_URL}$title.html")
    }

    fun getInfo(): Pair<String, String> = Pair(title, author)
    fun getFullInfo(): Triple<String, String, Int> = Triple(title, author, year)
}

fun Book.getWeight(): Double = pages * 1.5

fun Book.tornPages(tornPageNum: Int) =
        if (pages >= tornPageNum)
            pages -= tornPageNum
        else
            pages = 0


class Puppy {
    fun playWithBook(book: Book) {
        // book.pages = 10000

        var rand: Random = Random()

        while (book.pages > 0) {
            val tornPageNum = rand.nextInt(12)
            book.tornPages(tornPageNum)
        }
    }
}

class eBook(title: String, author: String, val format: String = "text") : Book(
        title, author) {
    private var wordCount = 0

    override fun readPage() {
        wordCount += 250
    }
}

fun main(args: Array<String>) {
    val book: Book = Book("Tom", "Mark", 1842)
    var info = book.getFullInfo()

    book.printUrl()

    //val (t, a, col) = info

    println("Here is your book ${info.first} written by ${info.second} in ${info.third}")

    val allBooks = setOf("Twelfth Night", "King Lear", "Hamlet", "A Midsummer Night's Dream")
    val library = allBooks to "William Shakespeare"
    val contained: Boolean = library.first.any { it.contains("Hamlet") }
    println("set contains 'Hamlet' : ${contained}")


    var moreBooks: MutableMap<String, String> = mutableMapOf<String, String>()
    moreBooks.put("The Winter's Tale", "William Shakespeare")
    moreBooks.getOrPut("Hamlet") { "William Shakespeare" }

    println(moreBooks.keys)
    println(moreBooks.values)
}