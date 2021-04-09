package nl.codecraftr.kata.librarykukumber.storage

import nl.codecraftr.kata.librarykukumber.domain.BookInventory

class InMemoryBookInventory(initialBooks: List<String> = emptyList()) : BookInventory {
    private val books = initialBooks.toMutableList()
    override fun getBooks() : List<String> {
        return books
    }

    override fun addBooks(booksToAdd: List<String>) {
        books.addAll(booksToAdd)
    }
}