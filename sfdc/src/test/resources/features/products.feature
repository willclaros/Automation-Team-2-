Feature: Create a product.

  Background:
    Given I navigate to Login page
    And I login as "admin user" User

  Scenario Outline: Verify that it possible to create a new product.
    When I go to app list product
      And I go to Products page
      And I click New button Products
      And Fill the following information "<Product name>"
      And I click the Save button
    Then I verify that product is created "<Product name>"

    Examples:
      | Product name |
      | Laptop       |