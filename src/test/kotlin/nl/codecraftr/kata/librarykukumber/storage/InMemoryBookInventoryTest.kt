package nl.codecraftr.kata.librarykukumber.storage

import nl.codecraftr.kata.librarykukumber.listOfBooks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class InMemoryBookInventoryTest {
    private lateinit var results: List<String>
    private lateinit var inventory: InMemoryBookInventory

    @BeforeEach
    internal fun setUp() {
        results = emptyList()
        inventory = InMemoryBookInventory()
    }

    @Test
    internal fun `should add books to the inventory given collection of books`() {
        val books = listOfBooks()

        addBooks(books)
        retrieveBooks()

        retrievedBooksShouldMatch(books)
    }

    @Test
    internal fun `should add new books to existing books given collection of books`() {
        val books = listOfBooks()
        val newBooks = listOf("Other Book")

        addBooks(books)
        addBooks(newBooks)
        retrieveBooks()

        retrievedBooksShouldMatch(books + newBooks)
    }

    @Test
    internal fun `should return empty list given no books were added`() {
        retrieveBooks()

        retrievedBooksShouldMatch(emptyList())
    }

    private fun retrieveBooks() {
        results = inventory.getBooks()
    }

    private fun addBooks(books: List<String>) {
        inventory.addBooks(books)
    }

    private fun retrievedBooksShouldMatch(books: List<String>) {
        assertEquals(
            books,
            results,
            "Books retrieved from inventory do not match the supplied books"
        )
    }
}