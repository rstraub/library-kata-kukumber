package nl.codecraftr.kata.librarykukumber.storage

import nl.codecraftr.kata.librarykukumber.listOfBooks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class InMemoryBookInventoryTest {
    private lateinit var books: List<String>
    private lateinit var results: List<String>
    private lateinit var inventory: InMemoryBookInventory

    @BeforeEach
    internal fun setUp() {
        books = emptyList()
        results = emptyList()
        inventoryWithBooks()
    }

    @Nested
    inner class GetBooks {
        @Test
        internal fun `should return all books stored in the inventory`() {
            books = listOfBooks()
            inventoryWithBooks()

            retrieveBooks()

            retrievedBooksShouldMatchSupplied()
        }
    }

    private fun inventoryWithBooks() {
        inventory = InMemoryBookInventory(books)
    }

    private fun retrieveBooks() {
        results = inventory.getBooks()
    }

    private fun retrievedBooksShouldMatchSupplied() {
        assertEquals(
            books,
            results,
            "Books retrieved from inventory do not match the supplied books"
        )
    }
}