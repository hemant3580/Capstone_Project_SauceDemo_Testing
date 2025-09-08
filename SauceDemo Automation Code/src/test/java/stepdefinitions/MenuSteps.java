package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MenuPage;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Common;
import java.util.ArrayList;

public class MenuSteps {
    private MenuPage menuPage;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    
    @When("I click on menu button")
    public void iClickOnMenuButton() {
        inventoryPage = new InventoryPage(Common.driver);
        inventoryPage.clickMenuButton();
    }
    
    @When("I click on All Items from menu")
    public void iClickOnAllItemsFromMenu() {
        menuPage = new MenuPage(Common.driver);
        menuPage.clickAllItems();
    }
    
    @Then("I should remain on inventory page")
    public void iShouldRemainOnInventoryPage() {
        inventoryPage = new InventoryPage(Common.driver);
        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(), 
            "Should remain on inventory page");
    }
    
    @When("I click on About from menu")
    public void iClickOnAboutFromMenu() {
        menuPage = new MenuPage(Common.driver);
        menuPage.clickAbout();
    }
    
    @Then("I should be redirected to Sauce Labs website")
    public void iShouldBeRedirectedToSauceLabsWebsite() {
        // Switch to new tab/window if opened
        ArrayList<String> tabs = new ArrayList<>(Common.driver.getWindowHandles());
        if (tabs.size() > 1) {
            Common.driver.switchTo().window(tabs.get(1));
        }
        
        String currentUrl = Common.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucelabs.com"), 
            "Should be redirected to Sauce Labs website. Current URL: " + currentUrl);
        
        if (tabs.size() > 1) {
            Common.driver.close();
            Common.driver.switchTo().window(tabs.get(0));
        }
    }
    
    @When("I click on Logout from menu")
    public void iClickOnLogoutFromMenu() {
        menuPage = new MenuPage(Common.driver);
        menuPage.clickLogout();
    }
    
    @Then("I should be redirected to login page")
    public void iShouldBeRedirectedToLoginPage() {
        String currentUrl = Common.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucedemo.com") && 
                         !currentUrl.contains("inventory"), 
            "Should be redirected to login page");
    }
    
    @When("I click on Reset App State from menu")
    public void iClickOnResetAppStateFromMenu() {
        menuPage = new MenuPage(Common.driver);
        menuPage.clickResetAppState();
    }
    
    @Then("cart should be reset to empty")
    public void cartShouldBeResetToEmpty() {
        inventoryPage = new InventoryPage(Common.driver);
        String cartBadge = inventoryPage.getCartBadgeCount();
        Assert.assertEquals(cartBadge, "0", "Cart should be empty after reset");
    }
}
