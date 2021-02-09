@login @wip
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @positiveLogin
  Scenario: Login
    When the user enter "username" "password"
    Then the user should be able to login

  @negativeLogin
  Scenario Outline:The user should not be able to login with invalid credentials
    Then the user should not be able to login with invalid credentials "<username>" "<password>"
    Examples:
      | username  | password      |
      | wrongUser | password      |
      | username  | wrongPassword |
      |           | password      |
      | username  |               |
