package integration

import assertk.all
import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.containsAll
import assertk.assertions.isEqualTo
import io.cucumber.java8.En
import nl.codecraftr.kata.librarykukumber.LibraryApp
import nl.codecraftr.kata.librarykukumber.listOfBooks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class BookInventoryStepDefs : En {
    private val libraryApp = LibraryApp.create()
    private val books = listOfBooks()
    private var results = emptyList<String>()

    init {
        Given("The library has books") {
            addBooksToLibrary(books)
        }
        When("The user asks for the books") {
            getBooksFromLibrary()
        }
        When("The librarian adds a new book to the inventory") {
            addBookToLibrary("newBook")
        }
        Then("The books in the library are shown") {
            retrievedBooksShouldMatch(books)
        }
        Then("The old and new books in the library are shown") {
            retrievedBooksShouldMatch(books + "newBook")
        }
    }

    private fun addBookToLibrary(book: String) = libraryApp.addBooks(listOf(book))
    private fun addBooksToLibrary(books: List<String>) = libraryApp.addBooks(books)

    private fun getBooksFromLibrary() {
        results = libraryApp.getBooks()
    }

    private fun retrievedBooksShouldMatch(books: List<String>) {
        assertThat(results, "Books retrieved from library do not match the supplied books").isEqualTo(books)
    }
}
