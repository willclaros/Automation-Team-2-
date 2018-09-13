Feature: create account in Salesforce

  Background:
    Given I navigate to Login page
    And I login as "user admin" User

  Scenario: verify that it possible to create an Account
    When I go to Account page
    And I click new button
    And I fill the following information in accounts
      | account Name | Phone    | fax   | account Number | webSite | account Site   | ticker | employees | annual Revenue | sicCode | sector | billingStreet | billingCity | billingState | billingZip | billingCountry | shippingStreet | shippingCity | shippingState | shippingZip | shippingCountry | slaExpirationDate | slaSerialNumber | numberOfLocations | description | rating |
      | rasec12      | 67680741 | 45715 | 1              | hel11   | helo@jala.com  | aas4a  | 489874    | 5456           | 44454   | sud    | dasdas        | cbbs        | new          | 7458745    | Bolivia        | barrio manaco  | quillacollo  | normal        | normal      | sud             | 16/10/2018        | na              | 715               | hello world | Hot    |
    Then the created account should be displayed in account details page