package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By errorMessage = By.cssSelector("[data-test='error']"); 
    private By summaryItemNames = By.className("inventory_item_name");
    private By summaryItemPrices = By.className("inventory_item_price");
    private By summarySubTotal = By.className("summary_subtotal_label");
    private By summaryTax = By.className("summary_tax_label");
    private By summaryTotal = By.className("summary_total_label");
    private By finishButton = By.id("finish");
    private By completeHeader = By.className("complete-header");
    private By completeMessage = By.className("complete-text");
    private By backHomeButton = By.id("back-to-products");
    private By summaryInfo = By.className("summary_info");
    private By summaryInfoLabel = By.className("summary_info_label");
    private By summaryValueLabel = By.className("summary_value_label");
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lastName);
    }
    
    public void enterPostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeInput)).sendKeys(postalCode);
    }
    
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
    
    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }
    
    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
    }
    
    public List<String> getSummaryItemNames() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(summaryItemNames));
        List<WebElement> nameElements = driver.findElements(summaryItemNames);
        return nameElements.stream().map(WebElement::getText) .collect(Collectors.toList()); 
    }
    
    public List<String> getSummaryItemPrices() {
        List<WebElement> priceElements = driver.findElements(summaryItemPrices);
        return priceElements.stream().map(element -> element.getText().replace("$", "")) .collect(Collectors.toList()); 
    }
    
    public String getSubTotal() {
        return driver.findElement(summarySubTotal).getText();
    }
    
    public String getTax() {
        return driver.findElement(summaryTax).getText();
    }
    
    public String getTotal() {
        return driver.findElement(summaryTotal).getText();
    }
    
    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
    
    public String getCompleteHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
    }
    
    public String getCompleteMessage() {
        return driver.findElement(completeMessage).getText();
    }
    
    public void clickBackHome() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton)).click();
    }

 public boolean hasItemizedProductList() {
     try {
         return !driver.findElements(summaryItemNames).isEmpty();
     } catch (Exception e) {
         return false;
     }
 }

 public boolean hasPaymentInformation() {
     try {
         By paymentInfo = By.className("summary_info");
         return driver.findElement(paymentInfo).isDisplayed();
     } catch (Exception e) {
         return false;
     }
 }

 public boolean hasShippingInformation() {
	    try {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_summary_container")));
	        WebElement shippingDiv = driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[4]"));
	        String shippingText = shippingDiv.getText().toUpperCase().trim();
	        System.out.println("Shipping Info Text: " + shippingText); 
	        return shippingText.contains("FREE PONY EXPRESS DELIVERY");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

 public boolean hasTotalCalculation() {
     try {
         return driver.findElement(summaryTotal).isDisplayed() && 
                driver.findElement(summarySubTotal).isDisplayed() &&
                driver.findElement(summaryTax).isDisplayed();
     } catch (Exception e) {
         return false;
     }
 }

 public String getCheckoutCompleteText() {
     try {
         return driver.findElement(completeMessage).getText();
     } catch (Exception e) {
         return "";
     }
 }

 public boolean hasBackToProductsButton() {
     try {
         return driver.findElement(backHomeButton).isDisplayed();
     } catch (Exception e) {
         return false;
     }
 }

    public boolean isOrderComplete() {
        try {
            return driver.findElement(completeHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
