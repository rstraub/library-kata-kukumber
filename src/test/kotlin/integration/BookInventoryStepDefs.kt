package integration

import io.cucumber.java8.En
import io.cucumber.java8.PendingException
import nl.codecraftr.kata.librarykukumber.LibraryApp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class BookInventoryStepDefs: En {
    init {
        val libraryApp = LibraryApp()
        val books = listOf(
            "The Gunslinger",
            "The Drawing of the Three"
        )
        var results = listOf<String>()

        Given("The library has books") {
            libraryApp.addBooks(books)
        }
        When("The user asks for the books") {
            results = libraryApp.getBooks()
        }
        Then("The books in the library are shown") {
            assertEquals(
                books,
                results,
                "Books retrieved from library do not match the supplied books"
            )
        }
    }
}