package nl.codecraftr.kata.librarykukumber

import nl.codecraftr.kata.librarykukumber.domain.BookInventory
import nl.codecraftr.kata.librarykukumber.storage.InMemoryBookInventory

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

