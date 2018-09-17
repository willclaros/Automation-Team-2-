Feature: create contact in Salesforce
  Background:
    Given I navigate to Login page
    And I login as "yerel" User

  Scenario: verify that it possible to create a contacts
    When I go to Contact page
    And I click on button New
    And I fill all the following information
      | Salutation | firstName | lastName | homePhone | accountName | mobile | title     | otherPhone | departament | fax | birthdate | email                  | reportTo | assistant | leadSource | asstPhone | mailingStreet | mailingZip | mailingCity | mailingState | mailingCountry | otherStreet     | otherZip | otherCity  | otherState | otherCountry | languages | level     | description |
      | Mr.        | Estalin   | yerel    | 123456    | yerel132    |        | title one |            |             |     |           | estalinyerel@gmail.com |          |           | Web        | 5874123   |               |            |             |              |                | av. perez olgin | 07036    | cochabamba | Bolivia    | Cercado      |           | Secondary |             |
    Then I should see the contact created correctly
