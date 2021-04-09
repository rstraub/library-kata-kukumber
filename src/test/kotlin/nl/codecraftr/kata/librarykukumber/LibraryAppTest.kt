package nl.codecraftr.kata.librarykukumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LibraryAppTest {
    private lateinit var app: LibraryApp

    @BeforeEach
    internal fun setUp() {
        app = LibraryApp()
    }

    @Test
    internal fun `should return all books in the inventory`() {
        val books = listOfBooks()
        app.addBooks(books)

        val results = app.getBooks()

        results.shouldMatch(books)
    }

    private fun List<String>.shouldMatch(expected: List<String>) {
        assertEquals(
            expected,
            this,
            "Books retrieved from library do not match the supplied books"
        )
    }
}