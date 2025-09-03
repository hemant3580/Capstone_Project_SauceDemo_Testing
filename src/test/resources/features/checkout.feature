Feature: Checkout Functionality
  As a logged-in user with items in cart
  I want to complete the checkout process
  So that I can purchase products

  Background:
    Given I am on the SauceDemo login page
    When I login with valid credentials
    And I dismiss the Chrome password manager popup if it appears
    And I add product "sauce-labs-backpack" to cart
    And I click on cart icon
    And I click checkout

  Scenario: Checkout with valid information
    When I enter checkout information with first name "Hemant", last name "Bhase", and postal code "411020"
    Then I should see order summary with item details
    When I finish the order
    Then I should see order completion message "Thank you for your order"
    And order should be completed successfully

  Scenario: Checkout with blank fields
    When I leave checkout information blank and continue
    Then I should see checkout error message "First Name is required"

  Scenario: Cancel checkout
    When I cancel checkout
    Then I should be on cart page

  Scenario: Payment, Shipping & Itemized Summary
    When I enter checkout information with first name "Hemant", last name "Bhase", and postal code "411020"
    Then I should see order summary with item details
    And I should see itemized product list
    And I should see payment information
    And I should see shipping information
    And I should see total amount calculation

  Scenario: Checkout Completion Message
    When I enter checkout information with first name "Hemant", last name "Bhase", and postal code "411020"
    And I finish the order
    Then I should see order completion message "Thank you for your order"
    And I should see checkout complete text "Your order has been dispatched"
    And I should see back to products button
