package integration

import io.cucumber.java8.En
import nl.codecraftr.kata.librarykukumber.LibraryApp
import nl.codecraftr.kata.librarykukumber.listOfBooks
import org.junit.jupiter.api.Assertions.assertEquals

class BookInventoryStepDefs : En {
    private val libraryApp = LibraryApp.create()
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
            retrievedBooksShouldMatchLibrary()
        }
    }

    private fun addBooksToLibrary() = libraryApp.addBooks(books)

    private fun getBooksFromLibrary() {
        results = libraryApp.getBooks()
    }

    private fun retrievedBooksShouldMatchLibrary() {
        assertEquals(
            books,
            results,
            "Books retrieved from library do not match the supplied books"
        )
    }
}
