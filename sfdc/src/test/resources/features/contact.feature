Feature: create contact in Salesforce
  Background:
    Given I navigate to Login page
    And I login as "yerel" User
    And I go to Contact page
    And I click New button

  Scenario: verify that it possible to create a contacts
    When I create a Contact with the following information
      | Salutation | firstName | lastName | homePhone | accountName | mobile | title     | otherPhone | departament | fax | birthdate | email                  | reportTo | assistant | leadSource | asstPhone | mailingStreet | mailingZip | mailingCity | mailingState | mailingCountry | otherStreet     | otherZip | otherCity  | otherState | otherCountry | languages | level     | description |
      | Mr.        | Estalin   | yerel    | 123456    | yerel132    |        | title one |            |             |     |           | estalinyerel@gmail.com |          |           | Web        | 5874123   |               |            |             |              |                | av. perez olgin | 07036    | cochabamba | Bolivia    | Cercado      |           | Secondary |             |
    Then I should see the contact created correctly

  Scenario: verify that it possible to edit a contacts
    When I create a Contact with the following information
      | firstName | lastName | homePhone | title     | email                  | otherStreet     |  otherCity  | otherState | otherCountry |
      | Yerel     | Hurtado  | 123456    | title one | estalinyerel@gmail.com | av. perez olgin |  cochabamba | Bolivia    | Cercado      |
    And I go to Contact edit page
    And I edit the following information in actual Contact
      | firstName | lastName | homePhone | title     | email                  |
      | Yerel     | Arias    | 123457    | title dos | estalinyerel@gmail.com |
    Then I should see the contact edited correctly

  Scenario: Verify that is possible to delete a Contact to created
    When I create a Contact with the following information
      | Salutation | firstName | lastName | homePhone | accountName | mobile | title     | otherPhone | departament | fax | birthdate | email                  | reportTo | assistant | leadSource | asstPhone | mailingStreet | mailingZip | mailingCity | mailingState | mailingCountry | otherStreet     | otherZip | otherCity  | otherState | otherCountry | languages | level     | description |
      | Mr.        | Yerel     | Hurtado  | 123456    |             |        | title one |            |             |     |           | estalinyerel@gmail.com |          |           | Web        | 5874123   |               |            |             |              |                | av. perez olgin | 07036    | cochabamba | Bolivia    | Cercado      |           | Secondary |             |
    And I delete this Contact create
    Then I should see the actual Contact is delete