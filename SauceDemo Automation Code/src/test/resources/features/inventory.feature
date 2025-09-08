Feature: Inventory Page Functionality
  As a logged-in user
  I want to view and interact with products
  So that I can browse the inventory

  Background:
    Given I am on the SauceDemo login page
    When I login with valid credentials
    And I dismiss the Chrome password manager popup if it appears
    Then I should be redirected to the inventory page

  Scenario: Product tile display
    Then I should see product "Sauce Labs Backpack" displayed

  Scenario: Sort by name A-Z
    When I sort products by "Name (A to Z)"
    Then products should be sorted alphabetically A-Z

  Scenario: Sort by name Z-A
    When I sort products by "Name (Z to A)"
    Then products should be sorted alphabetically Z-A

  Scenario: Sort by price low to high
    When I sort products by "Price (low to high)"
    Then products should be sorted by price low to high

  Scenario: Sort by price high to low
    When I sort products by "Price (high to low)"
    Then products should be sorted by price high to low
