package nl.codecraftr.kata.librarykukumber.storage

import nl.codecraftr.kata.librarykukumber.domain.BookInventory

class InMemoryBookInventory() : BookInventory {
    private val books = mutableListOf<String>()
    override fun getBooks()  = books.toList()

    override fun addBooks(booksToAdd: List<String>) {
        books.addAll(booksToAdd)
    }
}