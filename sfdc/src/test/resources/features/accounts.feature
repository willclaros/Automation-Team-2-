@Account
Feature: create account in Salesforce

  Background:
    Given I navigate to Login page
    And I login as "william" User

  @DeleteAccount
  Scenario: verify that it possible to create an Account
    When I go to Account page
    And I click new button
    And I fill the following information in accounts
      | account Name | Phone    | fax   | account Number | ticker |
      | rasec12      | 67680741 | 45715 | 1              | aas4a  |
    Then the created account should be displayed in account details page
    And  the Account should be saved

  @DeleteAccount
  Scenario: Verify that it possible to edit an Account
    Given I have created the Account with the following information
      | account Name | Phone | fax | account Number | ticker  |
      | cesar        | 7854  | 745 | 87458          | 5874wfs |
    When I go to Account page
    And I select the Account
    And I go to Account Edit page
    And I change the account information
      | account Name | Phone | fax | account Number | ticker |
      | cesar123     | 01    | 1   | 47             | 00     |
    Then the Account should be edited by the new data
    And the Account should be updated

  @DeleteAccount
  Scenario: Verify that is possible to delete a Account to created
    Given I have created the Account with the following information.
      | account Name | Phone | fax | account Number | ticker  |
      | cesarDelete  | 7854  | 745 | 87458          | 5874wfs |
    When I go to Account page
      And I select the Account
      And I delete the Account created
    Then I should see the Account is delete
      And the Account should be deleted

