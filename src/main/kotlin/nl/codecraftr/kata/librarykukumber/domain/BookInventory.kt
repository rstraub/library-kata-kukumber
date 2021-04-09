package nl.codecraftr.kata.librarykukumber.domain

interface BookInventory {
    fun getBooks(): List<String>
    fun addBooks(booksToAdd: List<String>)
}