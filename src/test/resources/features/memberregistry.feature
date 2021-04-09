Feature: Member Registry
  Scenario: The one where the user asks for the members in the registry
    Given The library has members
    When The user asks for the members
    Then The members in the library are shown