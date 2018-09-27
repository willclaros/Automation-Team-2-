Feature: Create a product.

  Background:
    Given I navigate to Login page
    And I login as "william" User

#    Create UI - Validate UI - Validate API
#  @DeleteProduct
  Scenario: Verify that it is possible to create a new product.
    When I go to Products page
    And I click New Product button
    And I create a Product with the following information
      | Product Name | Product Code | Product Description            |
      | Desktop      | Asus         | Laptop model for Latin America |
    Then the created product should be displayed in the Product Detail Page
    And the Product should be created

#    Create API - Validate UI - Validate API
  @DeleteProduct
  Scenario: Verify that it possible to edit a product.
    Given I have created a product with the following information
      | Product Name | Product Code | Product Description            |
      | Hard Disk    | Toshiba      | Laptop model for Latin America |
    When I go to Products page
    And I go by URL to the Product Details page
    And I click Edit Product button
    And I edit the Product information
      | Product Name | Product Code | Product Description            |
      | PC           | HP           | Laptop model for Latin America |
    Then the edited product should be displayed in the Product Detail Page
    And the Product should be updated

#    Create API - Validate UI - Validate API
  Scenario: Verify that it possible to delete a product.
    Given I have created a product with the following information
      | Product Name      | Product Code | Product Description            |
      | Electric familyyy | Philips      | Laptop model for Latin America |
    When I go to Products page
    And  I go by URL to the Product Details page
    And I click Delete Product button
    Then the Product deleted shouldn't be displayed in the Product Detail Page
    And the Product should be deleted
