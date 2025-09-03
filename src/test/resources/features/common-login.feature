Feature: Common Login Flow

  Scenario: Login as standard user and dismiss Chrome popup
    Given I am on the SauceDemo login page
    When I enter valid username and password
    And I click the login button
    And I dismiss the Chrome password manager popup if it appears
    Then I should be redirected to the inventory page
