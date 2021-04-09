package nl.codecraftr.kata.librarykukumber

interface BookInventory {
    fun getBooks(): List<String>
    fun addBooks(booksToAdd: List<String>)
}