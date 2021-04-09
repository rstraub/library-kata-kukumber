package integration

import io.cucumber.java8.En
import nl.codecraftr.kata.librarykukumber.LibraryApp
import nl.codecraftr.kata.librarykukumber.listOfBooks
import org.junit.jupiter.api.Assertions.assertEquals

class BookInventoryStepDefs : En {
    private val libraryApp = LibraryApp()
    private val books = listOfBooks()
    private var results = emptyList<String>()

    init {
        Given("The library has books") {
            addBooksToLibrary()
        }
        When("The user asks for the books") {
            getBooksFromLibrary()
        }
        Then("The books in the library are shown") {
            retrievedBooksShouldMatch(results)
        }
    }

    private fun addBooksToLibrary() = libraryApp.addBooks(books)

    private fun getBooksFromLibrary() {
        results = libraryApp.getBooks()
    }

    private fun retrievedBooksShouldMatch(expected: List<String>) {
        assertEquals(
            books,
            expected,
            "Books retrieved from library do not match the supplied books"
        )
    }
}
