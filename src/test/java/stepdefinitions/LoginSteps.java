package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Common;

public class LoginSteps {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    
    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(Common.driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    
    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String expectedError) {
        loginPage = new LoginPage(Common.driver);
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains(expectedError), 
            "Expected error message not found. Actual: " + actualError);
    }
    
    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        loginPage = new LoginPage(Common.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    
    @When("I login with locked out user")
    public void iLoginWithLockedOutUser() {
        loginPage = new LoginPage(Common.driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    
    @When("I leave username blank and enter password")
    public void iLeaveUsernameBlankAndEnterPassword() {
        loginPage = new LoginPage(Common.driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    
    @When("I enter username and leave password blank")
    public void iEnterUsernameAndLeavePasswordBlank() {
        loginPage = new LoginPage(Common.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLogin();
    }
}
