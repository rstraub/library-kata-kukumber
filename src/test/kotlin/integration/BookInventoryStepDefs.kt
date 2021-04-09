package integration

import io.cucumber.java8.En
import nl.codecraftr.kata.librarykukumber.LibraryApp
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

private fun listOfBooks() =
    listOf(
        "The Dark Tower I: The Gunslinger",
        "The Dark Tower II: The Drawing of the Three",
        "The Dark Tower III: The Waste Lands",
        "The Dark Tower IV: Wizard and Glass",
        "The Dark Tower V: Wolves of the Calla",
        "The Dark Tower VI: Song of Susannah",
        "The Dark Tower VII: The Dark Tower"
    )