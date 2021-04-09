package integration

import io.cucumber.java8.En
import io.cucumber.java8.PendingException
import org.junit.jupiter.api.Assertions.assertTrue

class CanaryStepDefs: En {
    init {
        Given("I run a test") {
            throw PendingException()
        }
        Then("I see the results") {
            assertTrue(false)
        }
    }
}