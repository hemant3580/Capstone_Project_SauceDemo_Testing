package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import pages.LoginPage;
import utility.Common;

public class CommonSteps {

    private LoginPage loginPage;

    @Given("I am on the SauceDemo login page")
    public void iAmOnLoginPage() {
        Common.initializeDriver();
        Common.openUrl("https://www.saucedemo.com/");
        loginPage = new LoginPage(Common.driver);
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @And("I dismiss the Chrome password manager popup if it appears")
    public void iDismissChromePasswordPopupIfItAppears() {
        try {
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Common.driver.switchTo().alert().accept();
            System.out.println("Popup alert detected and accepted.");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No alert popup appeared.");
        }
    }



    @Then("I should be redirected to the inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        String currentUrl = Common.driver.getCurrentUrl();
        if (!currentUrl.contains("/inventory.html")) {
            throw new AssertionError("Expected inventory page, but was redirected to: " + currentUrl);
        }
    }
}
