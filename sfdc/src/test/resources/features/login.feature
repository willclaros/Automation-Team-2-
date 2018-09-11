@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  Scenario Outline: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "<User Name>" with password "<Password>"
    Then I should login unsuccessfully login "<MessageError>"

    Examples: Short pass
      | User Name               | Password     | MessageError                                                                                               |
      | will@williamcompany.com | Wallace#2211 | Please check your username and password. If you still can't log in, contact your Salesforce administrator. |


  @SmokeTest @Logout
  Scenario: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "admin user" User
    Then I should login successfully


