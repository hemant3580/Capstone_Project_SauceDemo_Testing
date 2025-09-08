package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;
import utility.Common;
import java.util.List;

public class CartSteps {
    private CartPage cartPage;
    private InventoryPage inventoryPage;
    
    @When("I click on cart icon")
    public void iClickOnCartIcon() {
        inventoryPage = new InventoryPage(Common.driver);
        inventoryPage.clickCart();
    }
    
    @Then("I should be on cart page")
    public void iShouldBeOnCartPage() {
        cartPage = new CartPage(Common.driver);
        Assert.assertTrue(cartPage.isCartPageLoaded(), "Cart page not loaded");
    }
    
    @Then("I should see product {string} in cart")
    public void iShouldSeeProductInCart(String productName) {
        cartPage = new CartPage(Common.driver);
        List<String> cartItems = cartPage.getCartItemNames();
        Assert.assertTrue(cartItems.contains(productName), 
            "Product " + productName + " not found in cart");
    }
    
    @When("I remove product {string} from cart")
    public void iRemoveProductFromCart(String productName) {
        cartPage = new CartPage(Common.driver);
        cartPage.removeProduct(productName);
    }
    
    @When("I remove all products from cart")
    public void iRemoveAllProductsFromCart() {
        cartPage = new CartPage(Common.driver);
        cartPage.removeAllProducts();
    }
    
    @Then("cart should be empty")
    public void cartShouldBeEmpty() {
        cartPage = new CartPage(Common.driver);
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
    }
    
    @When("I click continue shopping")
    public void iClickContinueShopping() {
        cartPage = new CartPage(Common.driver);
        cartPage.clickContinueShopping();
    }
    
    @When("I click checkout")
    public void iClickCheckout() {
        cartPage = new CartPage(Common.driver);
        cartPage.clickCheckout();
    }
    
    @Then("cart should have {int} items")
    public void cartShouldHaveItems(int expectedCount) {
        cartPage = new CartPage(Common.driver);
        int actualCount = cartPage.getCartItemCount();
        Assert.assertEquals(actualCount, expectedCount, "Cart item count mismatch");
    }
    @Then("I should be on checkout page")
    public void iShouldBeOnCheckoutPage() {
        String currentUrl = Common.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-one"), "Should be on checkout page. Current URL: " + currentUrl);
}
}