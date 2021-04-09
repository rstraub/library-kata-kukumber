Feature: Book Inventory
  Scenario: The one where the user asks for the books in the inventory
    Given The library has books
    When The user asks for the books
    Then The books in the library are shown

  Scenario: The one where a new book is added to the inventory
    Given The library has books
    When The librarian adds a new book to the inventory
    And The user asks for the books
    Then The old and new books in the library are shown
