Feature: Create a product.

  Background:
    Given I navigate to Login page
    And I login as "william" User
    And I go to Products page
    And I click New button of Products

  Scenario: Verify that it is possible to create a new product.
    And I create an product with information
      | Product Name | Product Code | Product Description            | Active | Product Family |
      | Laptop       | Toshiba01    | Laptop model for Latin America | true   | None           |
    Then The product should be displayed in the Product Detail Page


  Scenario: Verify that it possible to edit a product.
    And I create an product with information
      | Product Name | Product Code | Product Description            | Active | Product Family |
      | Laptop       | Toshiba      | Laptop model for Latin America | true   |                |
    When I click Edit button
    And I edit information of Product
      | Product Name | Product Code | Product Description            |
      | PCc          | Toshibabbb   | Laptop model for Latin America |
    Then The product should be displayed in the Product Detail Page


  Scenario: Verify that it possible to delete a product.
    And I create an product with information
      | Product Name | Product Code | Product Description            | Active | Product Family |
      | Laptop159    | Toshiba01    | Laptop model for Latin America | false  | None           |
    When I click Delete button
    Then The product deleted shouldn't be displayed in the Product Detail Page