Feature: edit contact in Salesforce
  Background:
    Given I navigate to Login page
    And I login as "yerel" User

  Scenario: verify that it possible to edit a contacts
    When I go to   Contact  page
    And I click on button  New
    And I fill all the following  information
      | Salutation | firstName | lastName | homePhone | accountName | mobile | title     | otherPhone | departament | fax | birthdate | email                  | reportTo | assistant | leadSource | asstPhone | mailingStreet | mailingZip | mailingCity | mailingState | mailingCountry | otherStreet     | otherZip | otherCity  | otherState | otherCountry | languages | level | description |
      |            | Estalin   | yerel    | 123456    | yerel132    |        | title one |            |             |     |           | estalinyerel@gmail.com |          |           |            | 5874123   |               |            |             |              |                | av. perez olgin |          | cochabamba | Bolivia    | Cercado      |           |       |             |

    And I go to Contact edit page
    And I edit the following information in actual Contact
      | Salutation | firstName | lastName | homePhone | accountName | mobile | title     | otherPhone | departament | fax | birthdate | email                  | reportTo | assistant | leadSource | asstPhone | mailingStreet | mailingZip | mailingCity | mailingState | mailingCountry | otherStreet     | otherZip | otherCity  | otherState | otherCountry | languages | level | description |
      |            | Estalin   | Arias    | 67551151  | estalin     |        | title dos |            |             |     |           | helloWord@gmail.com    |          |           |            | 5874123   |               |            |             |              |                | av. perez olgin |          | cochabamba | Bolivia    | Cercado      |           |       |             |
    Then I should see the contact edited correctly

