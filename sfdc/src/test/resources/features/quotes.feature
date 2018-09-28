Feature: Create a price book.

  Background:
    Given I navigate to Login page
    And I login as "william" User

  Scenario: Create quotes.

    Given I have created a product with the following information
      | Product Name  | Product Code | Product Description | Active |
      | Computers IOs | 69489750     | desktop             | true   |
    And I have created the Account with the following information
      | Account Name | Account Number | Phone   | Fax       | ticker |
      | Jonas        | 222            | 3333337 | 987654321 | 4545   |
    And I add the Product to the Standard Price Book
    When I go to Opportunity page
    And I click New button Opportunity
    And I create an Opportunity
      | Name Opportunity | Close Date | Stage       |
      | Sales            | 09/30/2018 | Prospecting |
    Then the created opportunity should be displayed in the Opportunity Detail Page
    When I create a new Quote Name
      | Quote Name |
      | Automation |
    And I add the following line item
      | Price | Quantity |
      | 10    | 50       |
    Then I verify that the sum of all the prices is correct in the Quote Detail Page
    And I verify that the sum of all the prices is correct by API