Feature: Book Inventory
  Scenario: The one where the user asks for the books in the inventory
    Given The library has books
    When The user asks for the books
    Then The books in the library are shown