package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By allItemsLink = By.id("inventory_sidebar_link");
    private By aboutLink = By.id("about_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");
    private By resetAppStateLink = By.id("reset_sidebar_link");
    private By closeMenuButton = By.id("react-burger-cross-btn");
    
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void clickAllItems() {
        wait.until(ExpectedConditions.elementToBeClickable(allItemsLink)).click();
    }
    
    public void clickAbout() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink)).click();
    }
    
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
    
    public void clickResetAppState() {
        wait.until(ExpectedConditions.elementToBeClickable(resetAppStateLink)).click();
    }
    
    public void closeMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeMenuButton)).click();
        } catch (Exception e) {
        }
    }
}
