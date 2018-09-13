Feature: create account in Salesforce

  Background:
    Given I navigate to Login page
    And I login as "user admin" User

  Scenario: Verify that it possible to edit an Account
   When I create a account with the following information
    | account Name | Phone    | fax   | account Number |   ticker |
    | cesar        | 7854     | 745   |   87458        | 5874wfs  |
    And I change the account information
      | account Name | Phone    | fax   | account Number |   ticker |
      | cesar123     | 00       | 1     |   47           | 00       |
    Then the account should be edited by the new data

