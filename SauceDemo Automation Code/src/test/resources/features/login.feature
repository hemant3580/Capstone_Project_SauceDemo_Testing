Feature: Login Functionality
  As a user
  I want to login to SauceDemo
  So that I can access the inventory

  Background:
    Given I am on the SauceDemo login page

  Scenario: Login with valid credentials
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I dismiss the Chrome password manager popup if it appears
    Then I should be redirected to the inventory page

  Scenario: Login with invalid password
    When I enter username "standard_user" and password "wrong_password"
    Then I should see error message "Username and password do not match"

  Scenario: Login with locked out user
    When I login with locked out user
    Then I should see error message "Sorry, this user has been locked out"

  Scenario: Login with blank username
    When I leave username blank and enter password
    Then I should see error message "Username is required"

  Scenario: Login with blank password
    When I enter username and leave password blank
    Then I should see error message "Password is required"
