package nl.codecraftr.kata.librarykukumber

class LibraryApp(private val bookInventory: BookInventory) : BookInventory by bookInventory {
    companion object {
        fun create(): LibraryApp {
            return LibraryApp(InMemoryBookInventory())
        }
    }
}

fun main() {
    println("Starting Library")
    println("--------")
    val app = LibraryApp.create()
    app.addBooks(listOf("The Hobbit"))
    val books = app.getBooks()
    println("Books in library:")
    println(books)
    println("--------")
    println("Shutting Down Library")
}

class InMemoryBookInventory : BookInventory {
    private val books = mutableListOf<String>()
    override fun getBooks() : List<String> {
        return books
    }

    override fun addBooks(booksToAdd: List<String>) {
        books.addAll(booksToAdd)
    }
}