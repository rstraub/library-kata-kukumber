package nl.codecraftr.kata.librarykukumber

class LibraryApp : BookInventory {
    private val books = mutableListOf<String>()
    override fun getBooks() : List<String> {
        return books
    }

    override fun addBooks(booksToAdd: List<String>) {
        books.addAll(booksToAdd)
    }
}

fun main() {
    println("Starting Library")
    println("--------")
    val app = LibraryApp()
    app.addBooks(listOf("The Hobbit"))
    val books = app.getBooks()
    println("Books in library:")
    println(books)
    println("--------")
    println("Shutting Down Library")
}