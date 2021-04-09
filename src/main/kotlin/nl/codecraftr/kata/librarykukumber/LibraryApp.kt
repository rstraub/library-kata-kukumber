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
    println("starting")
}