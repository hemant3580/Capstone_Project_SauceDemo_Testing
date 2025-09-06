# Capstone_Project_SauceDemo_Testing
A test automation project for SauceDemo website using Selenium WebDriver, Cucumber BDD, and Page Object Model design pattern.

## Project Overview

This capstone project automates testing for the SauceDemo e-commerce application. It covers all major functionality including login, product browsing, shopping cart, checkout process, and navigation.

**Website:** https://www.saucedemo.com/

# Project Files

## 1. SauceDemo Defect Report
[View SauceDemo Defect Report.xlsx](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/Defects/SauceDemo_Defect_Report.xlsx)

---

## 2. Test Cases - Automation
[View Test Cases - Automation.xlsx](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/Test%20Cases/Test%20Cases%20-%20Automation.xlsx)

---

## 3. Test Cases - Manual
[View Test Cases - Manual.xlsx](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/Test%20Cases/Test%20Cases%20-%20Manual.xlsx)

---

## 4. Test Plan SauceDemo
[View Test Plan SauceDemo.xlsx](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/Test%20Plan/Test%20Plan%20SauceDemo.xlsx)

---

## 5. HTML Report PDF
[View HTML Report PDF](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/sauceDemo-Test-Report-pdf.pdf)

---

## 6. Jira List of tasks 
[View list PDF](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/Jira%20-%20Sauce%20Demo.pdf)

---

## 7. Jenkin Console
[View console output](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/Jenkin/Jenkin_console_output.txt)

---

## 8. Test Analysis Report
[View test analysis report](https://github.com/hemant3580/Capstone_Project_SauceDemo_Testing/blob/main/SauceDemo%20test%20Analysis%20Report.xlsx)

---
## Technologies Used

- **Java** 
- **Maven**  
- **Selenium WebDriver** 
- **Cucumber** 
- **JUnit** 
- **Page Object Model** 
- **ChromeDriver**

## Project Structure

```
src/test/java/
├── pages/
│   ├── LoginPage.java
│   ├── InventoryPage.java
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   └── MenuPage.java
├── stepdefinitions/
│   ├── CommonSteps.java
│   ├── LoginSteps.java
│   ├── InventorySteps.java
│   ├── CartSteps.java
│   ├── CheckoutSteps.java
│   ├── MenuSteps.java
│   └── Hooks.java
├── runners/
│   └── TestRunner.java
└── utility/
    └── Common.java

src/test/resources/features/
├── login.feature
├── inventory.feature
├── cart.feature
├── checkout.feature
└── menu.feature
```

## Test Coverage

This project includes **24 test scenarios** covering:

### Login Module (5 tests)
- Login with valid credentials
- Login with invalid password
- Login with locked out user
- Login with blank username
- Login with blank password

### Inventory Module (5 tests)
- Product display verification
- Sort products by name (A-Z)
- Sort products by name (Z-A)
- Sort products by price (low to high)
- Sort products by price (high to low)

### Cart Module (5 tests)
- Add products to cart
- Remove products from cart
- Remove all products from cart
- Continue shopping functionality
- Checkout button navigation

### Checkout Module (5 tests)
- Complete checkout with valid information
- Checkout with blank fields validation
- Cancel checkout process
- Payment, shipping and itemized summary
- Order completion verification

### Menu Navigation Module (4 tests)
- All Items menu navigation
- About page external link
- Logout functionality
- Reset app state

### Optional Tests (2 tests)
- Chrome password popup handling
- Page navigation verification

## File Descriptions

### Page Object Classes

**LoginPage.java**
- Handles login page interactions
- Methods: `enterUsername()`, `enterPassword()`, `clickLogin()`, `getErrorMessage()`
- Manages login form elements and error messages

**InventoryPage.java**
- Manages product inventory page operations
- Methods: `sortProducts()`, `addProductToCart()`, `getProductNames()`, `getProductPrices()`
- Handles product sorting, selection, and cart operations

**CartPage.java**
- Controls shopping cart functionality
- Methods: `removeProduct()`, `getCartItems()`, `clickCheckout()`, `continueShopping()`
- Manages cart item operations and navigation

**CheckoutPage.java**
- Handles checkout process from start to completion
- Methods: `fillCheckoutInfo()`, `clickFinish()`, `getOrderSummary()`
- Manages user information forms and order completion

**MenuPage.java**
- Navigation menu interactions
- Methods: `clickAllItems()`, `clickAbout()`, `clickLogout()`, `clickResetAppState()`
- Handles sidebar navigation and menu operations

### Step Definition Classes

**CommonSteps.java**
- Shared step definitions used across multiple features
- Browser initialization and common navigation steps

**LoginSteps.java**
- Login specific step implementations
- Handles all login related test scenarios

**InventorySteps.java**
- Product inventory step definitions
- Implements product display and sorting validations

**CartSteps.java**
- Shopping cart step implementations
- Handles cart operations and validations

**CheckoutSteps.java**
- Checkout process step definitions
- Implements checkout flow and order completion steps

**MenuSteps.java**
- Navigation menu step implementations
- Handles menu navigation and logout functionality

**Hooks.java**
- Test setup and cleanup operations
- WebDriver initialization and browser closure

### Utility Classes

**Common.java**
- WebDriver management and configuration
- Browser setup with Chrome options
- URL navigation and driver cleanup methods

**TestRunner.java**
- Cucumber test execution configuration
- Report generation settings
- Feature file and step definition mapping

### Feature Files (BDD Scenarios)

**login.feature**
- Contains all login related test scenarios in Gherkin language
- Readable test cases for different login conditions

**inventory.feature**
- Product inventory testing scenarios
- Product display and sorting test cases

**cart.feature**
- Shopping cart functionality test scenarios
- Add, remove, and navigation test cases

**checkout.feature**
- Complete checkout process scenarios
- Order placement and validation test cases

**menu.feature**
- Navigation menu testing scenarios
- Menu functionality and logout test cases

## Test Reports
