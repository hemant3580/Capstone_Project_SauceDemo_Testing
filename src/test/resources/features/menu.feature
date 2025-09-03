Feature: Menu Navigation
  As a logged-in user
  I want to use the navigation menu
  So that I can access different sections

  Background:
    Given I am on the SauceDemo login page
    When I login with valid credentials
    And I dismiss the Chrome password manager popup if it appears
    Then I should be redirected to the inventory page

  Scenario: All Items menu navigation
    When I click on menu button
    And I click on All Items from menu
    Then I should remain on inventory page

  Scenario: About menu navigation
    When I click on menu button
    And I click on About from menu
    Then I should be redirected to Sauce Labs website

  Scenario: Logout functionality
    When I click on menu button
    And I click on Logout from menu
    Then I should be redirected to login page

  Scenario: Reset app state
    When I add product "sauce-labs-backpack" to cart
    And I click on menu button
    And I click on Reset App State from menu
    Then cart should be reset to empty
