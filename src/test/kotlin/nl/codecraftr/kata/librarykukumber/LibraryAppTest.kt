package nl.codecraftr.kata.librarykukumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LibraryAppTest {
    private lateinit var app: LibraryApp
    private lateinit var books: List<String>
    private lateinit var results: List<String>

    @BeforeEach
    internal fun setUp() {
        app = LibraryApp()
        books = emptyList()
    }

    @Test
    internal fun `should return all books in the inventory`() {
        books = listOfBooks()

        addBooksToLibrary()
        getBooksFromLibrary()

        retrievedBooksShouldMatchLibrary()
    }

    private fun getBooksFromLibrary() {
        results = app.getBooks()
    }

    private fun addBooksToLibrary() {
        app.addBooks(books)
    }

    private fun retrievedBooksShouldMatchLibrary() {
        assertEquals(
            books,
            results,
            "Books retrieved from library do not match the supplied books"
        )
    }
}