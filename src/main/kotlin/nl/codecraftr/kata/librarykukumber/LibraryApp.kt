package nl.codecraftr.kata.librarykukumber

class LibraryApp {
    private val books = mutableListOf<String>()
    fun getBooks() : List<String> {
        return books
    }

    fun addBooks(books: List<String>) {
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