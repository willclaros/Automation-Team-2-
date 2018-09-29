@Opportunity
Feature: Create a Opportunity.

  Background:
    Given I navigate to Login page
    And I login as "william" User

  Scenario: Verify that it possible to create a Quote

    When I go to Opportunity page
    And I click New button Opportunity
    And I create an Opportunity
      | Name Opportunity   | Stage       | Close Date |
      | Sales for internet | Prospecting | 09/26/2018 |
    Then the created opportunity should be displayed in the Opportunity Detail Page
    And I create a New Quote
