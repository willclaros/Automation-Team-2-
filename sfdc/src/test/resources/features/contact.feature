Feature: create contact in Salesforce
  Background:
    Given I navigate to Login page
    And I login as "yerel" User

  Scenario Outline: verify that it possible to create a contacts
    When I go to app list Contact
    And I go to Contact page
    And I click on button New
    And I fill all the following information "<Last Name>"
  Then I should see the contact created correctly "<Last Name>"

  Examples:
    |Last Name|
    | userdos |
