package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By cartItems = By.className("cart_item");
    private By cartItemNames = By.className("inventory_item_name");
    private By cartItemPrices = By.className("inventory_item_price");
    private By removeButtons = By.cssSelector("[id^='remove']");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By cartList = By.className("cart_list");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public boolean isCartPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartList));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<String> getCartItemNames() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemNames));
        List<WebElement> nameElements = driver.findElements(cartItemNames);
        return nameElements.stream().map(WebElement::getText) .collect(Collectors.toList()); 
    }
    
    public List<String> getCartItemPrices() {
        List<WebElement> priceElements = driver.findElements(cartItemPrices);
        return priceElements.stream().map(element -> element.getText().replace("$", "")) .collect(Collectors.toList()); 
    }
    
    public void removeProduct(String productName) {
        String buttonId = "remove-" + productName.toLowerCase().replace(" ", "-").replace(".", "").replace("(", "").replace(")", "");
        By removeButton = By.id(buttonId);
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }
    
    public void removeAllProducts() {
        List<WebElement> removeButtonsList = driver.findElements(removeButtons);
        for (WebElement button : removeButtonsList) {
            button.click();
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
    
    public void clickContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }
    
    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
    
    public boolean isCartEmpty() {
        try {
            List<WebElement> items = driver.findElements(cartItems);
            return items.isEmpty();
        } catch (Exception e) {
            return true;
        }
    }
    
    public int getCartItemCount() {
        try {
            List<WebElement> items = driver.findElements(cartItems);
            return items.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
