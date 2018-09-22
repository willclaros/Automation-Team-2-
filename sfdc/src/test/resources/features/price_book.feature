Feature: Create a price book.

  Background:
    Given I navigate to Login page
    And I login as "william" User

  Scenario: Verify that it possible to create a price book
    When I go to Price Book page
    And I click New button Price Book
    And I create a Price Book
      | Price Book name      | Description | Status |
      | Selenium for dummies | Good book   | true   |
    Then The Price Book is information created should be displayed in the Price Book Detail Page