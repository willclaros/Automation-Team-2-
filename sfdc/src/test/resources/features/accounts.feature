Feature: create account in Salesforce

  Background:
    Given I navigate to Login page
    And I login as "user admin" User

  Scenario: verify that it possible to create an Account
    When I go to Account page
    And I click new button
    And I fill the following information
      | account Name | Phone    | fax   | account Number | webSite | account Site | ticker | employees | annual Revenue | sicCode | sector | billingStreet | billingCity | billingState | billingZip | billingCountry | shippingStreet | shippingCity | shippingState | shippingZip | shippingCountry | slaExpirationDate | slaSerialNumber | numberOfLocations | description |
      | rasec        | 67680441 | 45785 | 74587458       | hello   | helo@ja.com  | aasda  | 789874    | 5456           | 44454   | sud    | dasdas        | cbbs        | new          | 7458745    | Bolivia        | barrio manaco  | quillacollo  | normal        | normal      | sud             | 28/08/2018        | na              | 7458747878        | hello world |
    Then the created account should be displayed in account details page
