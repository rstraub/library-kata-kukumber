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
        inventoryWithBooks(emptyList())
    }

    @Nested
    inner class GetBooks {
        @Test
        internal fun `should return all books stored in the inventory`() {
            val books = listOfBooks()
            inventoryWithBooks(books)

            retrieveBooks()

            retrievedBooksShouldMatch(books)
        }
    }

    @Nested
    inner class AddBooks {
        @Test
        internal fun `should add books to the inventory`() {
            val books = listOfBooks()

            addBooks(books)
            retrieveBooks()

            retrievedBooksShouldMatch(books)
        }
    }

    private fun inventoryWithBooks(books: List<String>) {
        inventory = InMemoryBookInventory(books)
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