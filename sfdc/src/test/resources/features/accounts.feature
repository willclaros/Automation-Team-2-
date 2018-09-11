Feature: create account in Salesforce
  Background:
    Given I navigate to Login page
    And I login as "user admin" User

  Scenario Outline: verify that it possible to create an Account
    When I go to app list
      And I go to Account page
      And I click new button
      And I fill the following information "<Account Name>"
      And I click Save button
    Then the created account "<Account Name>" should be displayed in details account page


    Examples:
      | Account Name |
      | cesar        |