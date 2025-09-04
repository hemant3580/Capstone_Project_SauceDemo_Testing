package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.InventoryPage;
import utility.Common;
import java.util.List;
import java.util.stream.Collectors;

public class InventorySteps {
    private InventoryPage inventoryPage;
    
    @Then("I should see product {string} displayed")
    public void iShouldSeeProductDisplayed(String productName) {
        inventoryPage = new InventoryPage(Common.driver);
        List<String> productNames = inventoryPage.getProductNames();
        Assert.assertTrue(productNames.contains(productName), 
            "Product " + productName + " not found in inventory");
    }
    
    @When("I sort products by {string}")
    public void iSortProductsBy(String sortOption) {
        inventoryPage = new InventoryPage(Common.driver);
        inventoryPage.sortProducts(sortOption);
    }
    
    @Then("products should be sorted alphabetically A-Z")
    public void productsShouldBeSortedAlphabeticallyAZ() {
        inventoryPage = new InventoryPage(Common.driver);
        List<String> productNames = inventoryPage.getProductNames();
        List<String> sortedNames = productNames.stream().sorted() .collect(Collectors.toList()); 
        Assert.assertEquals(productNames, sortedNames, "Products are not sorted A-Z");
    }
    
    @Then("products should be sorted alphabetically Z-A")
    public void productsShouldBeSortedAlphabeticallyZA() {
        inventoryPage = new InventoryPage(Common.driver);
        List<String> productNames = inventoryPage.getProductNames();
        List<String> sortedNames = productNames.stream().sorted((a, b) -> b.compareTo(a)) .collect(Collectors.toList()); 
        Assert.assertEquals(productNames, sortedNames, "Products are not sorted Z-A");
    }
    
    @Then("products should be sorted by price low to high")
    public void productsShouldBeSortedByPriceLowToHigh() {
        inventoryPage = new InventoryPage(Common.driver);
        List<String> prices = inventoryPage.getProductPrices();
        List<Double> doublePrices = prices.stream().map(Double::parseDouble) .collect(Collectors.toList()); 
        List<Double> sortedPrices = doublePrices.stream().sorted() .collect(Collectors.toList()); 
        Assert.assertEquals(doublePrices, sortedPrices, "Products are not sorted by price low to high");
    }
    
    @Then("products should be sorted by price high to low")
    public void productsShouldBeSortedByPriceHighToLow() {
        inventoryPage = new InventoryPage(Common.driver);
        List<String> prices = inventoryPage.getProductPrices();
        List<Double> doublePrices = prices.stream().map(Double::parseDouble) .collect(Collectors.toList()); 
        List<Double> sortedPrices = doublePrices.stream().sorted((a, b) -> b.compareTo(a)) .collect(Collectors.toList()); 
        Assert.assertEquals(doublePrices, sortedPrices, "Products are not sorted by price high to low");
    }
    
    @When("I add product {string} to cart")
    public void iAddProductToCart(String productName) {
        inventoryPage = new InventoryPage(Common.driver);
        inventoryPage.addProductToCart(productName);
    }
    
    @Then("cart badge should show {string}")
    public void cartBadgeShouldShow(String expectedCount) {
        inventoryPage = new InventoryPage(Common.driver);
        String actualCount = inventoryPage.getCartBadgeCount();
        Assert.assertEquals(actualCount, expectedCount, "Cart badge count mismatch");
        
    }
}
