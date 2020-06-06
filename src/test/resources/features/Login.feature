
Feature: Users should be able to login

  Scenario: Login
    Given the user is on the login page
    When the user enter "username" "password"
    Then the user should be able to login

