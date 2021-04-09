package nl.codecraftr.kata.librarykukumber

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import nl.codecraftr.kata.librarykukumber.domain.BookInventory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class LibraryAppTest {
    private lateinit var app: LibraryApp
    private lateinit var results: List<String>
    private lateinit var inventory: BookInventory

    @BeforeEach
    internal fun setUp() {
        inventory = mockk(relaxed = true)
        app = LibraryApp(inventory)
    }

    @Nested
    inner class GetBooks {
        @Test
        internal fun `should return all books in the inventory`() {
            val books = listOfBooks()
            inventoryReturnsBooks(books)

            getBooksFromLibrary()

            retrievedBooksShouldMatch(books)
        }
    }

    @Nested
    inner class AddBooks {
        @Test
        internal fun `should add books to the inventory`() {
            val books = listOfBooks()

            addBooksToLibrary(books)

            verifyBooksWereAddedToInventory(books)
        }
    }

    private fun inventoryReturnsBooks(books: List<String>) {
        every { inventory.getBooks() } returns books
    }

    private fun addBooksToLibrary(books: List<String>) {
        app.addBooks(books)
    }

    private fun getBooksFromLibrary() {
        results = app.getBooks()
    }

    private fun retrievedBooksShouldMatch(books: List<String>) {
        assertEquals(
            books,
            results,
            "Books retrieved from library do not match the supplied books"
        )
    }

    private fun verifyBooksWereAddedToInventory(books: List<String>) {
        verify(exactly = 1) { inventory.addBooks(books) }
    }
}