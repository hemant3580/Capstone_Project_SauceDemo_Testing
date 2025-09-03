package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By inventoryContainer = By.id("inventory_container");
    private By productSortDropdown = By.className("product_sort_container");
    private By inventoryItems = By.className("inventory_item");
    private By inventoryItemNames = By.className("inventory_item_name");
    private By inventoryItemPrices = By.className("inventory_item_price");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");
    private By menuButton = By.id("react-burger-menu-btn");
    private By addToCartButtons = By.cssSelector("[id^='add-to-cart']");
    
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public boolean isInventoryPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void sortProducts(String sortOption) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(productSortDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(sortOption);
    }
    
    public List<String> getProductNames() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItemNames));
        List<WebElement> nameElements = driver.findElements(inventoryItemNames);
        return nameElements.stream().map(WebElement::getText) .collect(Collectors.toList()); 
    }
    
    public List<String> getProductPrices() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItemPrices));
        List<WebElement> priceElements = driver.findElements(inventoryItemPrices);
        return priceElements.stream().map(element -> element.getText().replace("$", "")) .collect(Collectors.toList()); 
    }
    
    public void addProductToCart(String productName) {
        String buttonId = "add-to-cart-" + productName.toLowerCase().replace(" ", "-").replace(".", "").replace("(", "").replace(")", "");
        By addToCartButton = By.id(buttonId);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
    
    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
    
    public String getCartBadgeCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (Exception e) {
            return "0";
        }
    }
    
    public void clickMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
    }
}
