package nl.codecraftr.kata.librarykukumber

import io.mockk.every
import io.mockk.mockk
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
        inventory = mockk()
        app = LibraryApp(inventory)
        books = emptyList()
    }

    @Test
    internal fun `should return all books in the inventory`() {
        books = listOfBooks()
        every { inventory.getBooks() } returns books

        getBooksFromLibrary()

        retrievedBooksShouldMatchLibrary()
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
}