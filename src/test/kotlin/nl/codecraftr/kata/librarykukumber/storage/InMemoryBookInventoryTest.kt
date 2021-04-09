package nl.codecraftr.kata.librarykukumber.storage

import nl.codecraftr.kata.librarykukumber.listOfBooks
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class InMemoryBookInventoryTest {
    private lateinit var books: List<String>
    private lateinit var results: List<String>

    @BeforeEach
    internal fun setUp() {
        books = emptyList()
        results = emptyList()
    }

    @Test
    internal fun `should return all books stored in the inventory`() {
        books = listOfBooks()
        val inventory = InMemoryBookInventory(books)

        results = inventory.getBooks()

        retrievedBooksShouldMatchSupplied()
    }

    private fun retrievedBooksShouldMatchSupplied() {
        assertEquals(
            books,
            results,
            "Books retrieved from inventory do not match the supplied books"
        )
    }
}