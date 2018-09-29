@Contact
Feature: create contact in Salesforce
  Background:
    Given I navigate to Login page
      And I login as "william" User

  @afterContactDelete
  Scenario: Verify that it possible to create a contacts
    When I go to Contact page
      And I click New button for create Contact
      And I create a Contact with the following information
      | firstName | lastName | homePhone | title     | email            |
      | Brayan    | Arias    | 123456578 | title two | brayan@gmail.com |
    #ui
    Then I should see the created Contact displayed in Contact Details page
    #api
      And the Contact should be saved

  @afterContactDelete
  Scenario: Verify that it possible to edit a contacts
    #api
    Given I have created the Contact with the following information fill
      | firstName | lastName | homePhone | title     | email            |
      | Brayan    | Arias    | 123456578 | title two | brayan@gmail.com |
    When I go to Contact page
    #list of contacts
      And I select the Contact
      And I go to Contact Edit page
      And I edit the following information in actual Contact
      | firstName | lastName | homePhone | title     | email                  |
      | Yerel     | Hurtado  | 555555    | title one | estalinyerel@gmail.com |
    #UI
    Then I should see the edited Contact displayed in Contact Details page
    #api
      And the Contact should be updated

  Scenario: Verify that is possible to delete a Contact to created
    #api
    Given I have created the Contact with the following information fill
      | firstName | lastName | homePhone | title     | email            |
      | yerel     | Arias    | 123456578 | title two | brayan@gmail.com |
    When I go to Contact page
     And I select the Contact
     And I delete the Contact created
    #UI
    Then I should see the actual Contact deleted
    #api
     And the Contact should be deleted
