Feature: Create a product.

  Background:
    Given I navigate to Login page
      And I login as "admin user" User

  Scenario: Verify that it possible to create a new product.
    When I go to Products page
      And I click New button Products
      And I fill the following information
      | Product Name | Product Code | Product Description            | Active |
      | Laptop       | Toshiba01    | Laptop model for Latin America | true  |
    Then The product information created should be displayed in the Product Detail Page

