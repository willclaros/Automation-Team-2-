Feature: Create a price book.

  Background:
    Given I navigate to Login page
    And I login as "admin user" User

  Scenario Outline: Verify that it possible to create a price book
    When I go to app list Price Books
    And I go to Price Book page
    And I click New button Price Book
    And Fill the following information "<Price Book Name>", "<Description>","<Active>"
    Then I verify that Price Book is created "<Price Book Name>"

    Examples:
      | Price Book Name      | Description | Active |
      | Selenium for dummies | Good book   | true   |