package nl.codecraftr.kata.librarykukumber

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import nl.codecraftr.kata.librarykukumber.domain.BookInventory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LibraryAppTest {
    private lateinit var app: LibraryApp
    private lateinit var books: List<String>
    private lateinit var results: List<String>
    private lateinit var inventory: BookInventory

    @BeforeEach
    internal fun setUp() {
        inventory = mockk(relaxed = true)
        app = LibraryApp(inventory)
        books = emptyList()
    }

    @Test
    internal fun `should return all books in the inventory`() {
        books = listOfBooks()
        inventoryReturnsBooks()

        getBooksFromLibrary()

        retrievedBooksShouldMatchLibrary()
    }

    @Test
    internal fun `should add books to the inventory`() {
        books = listOfBooks()

        addBooksToLibrary()

        verifyBooksWereAddedToInventory()
    }

    private fun inventoryReturnsBooks() {
        every { inventory.getBooks() } returns books
    }

    private fun addBooksToLibrary() {
        app.addBooks(books)
    }

    private fun getBooksFromLibrary() {
        results = app.getBooks()
    }

    private fun retrievedBooksShouldMatchLibrary() {
        assertEquals(
            books,
            results,
            "Books retrieved from library do not match the supplied books"
        )
    }

    private fun verifyBooksWereAddedToInventory() {
        verify(exactly = 1) { inventory.addBooks(books) }
    }
}