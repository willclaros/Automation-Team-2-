Feature: Create a price book.

  Background:
    Given I navigate to Login page
    And I login as "william" User

  Scenario: Create quotes.

    Given I fill the following information in accounts
      | Account Name | Account Number | Phone   | Fax       | ticker |
      | Fely         | 222            | 3333337 | 987654321 | 4545   |
    And I have created a product with the following information
      | Product Name  | Product Code | Product Description | Active |
      | Computers IOs | 69489750     | desktop             | true   |
#    And I add the Product to the "Standard" Price Book
    When I go to Opportunity page
    And I click New button Opportunity
    And I create an Opportunity
      | Name Opportunity  | Close Date | Stage       |
      | Naomi                    | 09/27/2018 | Prospecting |
    Then the created opportunity should be displayed in the Opportunity Detail Page
    When I create a new Quote with "Test Quote" Name
    And I add the following line item
      | Product Name  | price | quantity |
      | Computers IDs | 0     | 50       |