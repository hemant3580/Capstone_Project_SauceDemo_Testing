Feature: Cart Functionality
  As a logged-in user
  I want to manage my shopping cart
  So that I can add, remove, and view products

  Background:
    Given I am on the SauceDemo login page
    When I login with valid credentials
    And I dismiss the Chrome password manager popup if it appears
    Then I should be redirected to the inventory page

  Scenario: Add product to cart and verify
    When I add product "sauce-labs-backpack" to cart
    Then cart badge should show "1"
    When I click on cart icon
    Then I should be on cart page
    And I should see product "Sauce Labs Backpack" in cart

  Scenario: Remove product from cart
    When I add product "sauce-labs-backpack" to cart
    And I click on cart icon
    And I remove product "sauce-labs-backpack" from cart
    Then cart should be empty

  Scenario: Remove all products from cart
    When I add product "sauce-labs-backpack" to cart
    And I add product "sauce-labs-bike-light" to cart
    And I click on cart icon
    And I remove all products from cart
    Then cart should be empty

  Scenario: Continue shopping
    When I add product "sauce-labs-backpack" to cart
    And I click on cart icon
    And I click continue shopping
    Then I should be redirected to the inventory page

  Scenario: Checkout button navigation
    When I add product "sauce-labs-backpack" to cart
    And I click on cart icon
    And I click checkout
    Then I should be on checkout page
