package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckoutPage;
import utility.Common;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;
    
    @When("I enter checkout information with first name {string}, last name {string}, and postal code {string}")
    public void iEnterCheckoutInformation(String firstName, String lastName, String postalCode) {
        checkoutPage = new CheckoutPage(Common.driver);
        checkoutPage.fillCheckoutInformation(firstName, lastName, postalCode);
    }
    
    @When("I leave checkout information blank and continue")
    public void iLeaveCheckoutInformationBlankAndContinue() {
        checkoutPage = new CheckoutPage(Common.driver);
        checkoutPage.clickContinue();
    }
    
    @Then("I should see checkout error message {string}")
    public void iShouldSeeCheckoutErrorMessage(String expectedError) {
        checkoutPage = new CheckoutPage(Common.driver);
        String actualError = checkoutPage.getErrorMessage();
        Assert.assertTrue(actualError.contains(expectedError), 
            "Expected error message not found. Actual: " + actualError);
    }
    
    @When("I cancel checkout")
    public void iCancelCheckout() {
        checkoutPage = new CheckoutPage(Common.driver);
        checkoutPage.clickCancel();
    }
    
    @Then("I should see order summary with item details")
    public void iShouldSeeOrderSummaryWithItemDetails() {
        checkoutPage = new CheckoutPage(Common.driver);
        Assert.assertFalse(checkoutPage.getSummaryItemNames().isEmpty(), 
            "Order summary should contain items");
    }
    
    @When("I finish the order")
    public void iFinishTheOrder() {
        checkoutPage = new CheckoutPage(Common.driver);
        checkoutPage.clickFinish();
    }
    
    @Then("I should see order completion message {string}")
    public void iShouldSeeOrderCompletionMessage(String expectedMessage) {
        checkoutPage = new CheckoutPage(Common.driver);
        String actualMessage = checkoutPage.getCompleteHeader();
        Assert.assertTrue(actualMessage.contains(expectedMessage), 
            "Expected completion message not found. Actual: " + actualMessage);
    }
    
    @Then("order should be completed successfully")
    public void orderShouldBeCompletedSuccessfully() {
        checkoutPage = new CheckoutPage(Common.driver);
        Assert.assertTrue(checkoutPage.isOrderComplete(), "Order is not completed");
    }

    @Then("I should see itemized product list")
    public void iShouldSeeItemizedProductList() {
    	checkoutPage = new CheckoutPage(Common.driver);
    	Assert.assertTrue(checkoutPage.hasItemizedProductList(),"Itemized product list not displayed");
    }

    @Then("I should see payment information")
    public void iShouldSeePaymentInformation() {
    	checkoutPage = new CheckoutPage(Common.driver);
    	Assert.assertTrue(checkoutPage.hasPaymentInformation(), "Payment information not displayed");
    }

    @Then("I should see shipping information")
    public void iShouldSeeShippingInformation() {
    	checkoutPage = new CheckoutPage(Common.driver);
    	Assert.assertTrue(checkoutPage.hasShippingInformation(),"Shipping information not displayed");
    }
    
    @Then("I should see total amount calculation")
    public void iShouldSeeTotalAmountCalculation() {
    	checkoutPage = new CheckoutPage(Common.driver);
    	Assert.assertTrue(checkoutPage.hasTotalCalculation(),"Total amount calculation not displayed");
    }

    @Then("I should see checkout complete text {string}")
    public void iShouldSeeCheckoutCompleteText(String expectedText) {
    	checkoutPage = new CheckoutPage(Common.driver);
    	String actualText = checkoutPage.getCheckoutCompleteText();
    	Assert.assertTrue(actualText.contains(expectedText),"Expected completion text not found. Actual: " + actualText);
    }

    @Then("I should see back to products button")
    public void iShouldSeeBackToProductsButton() {
    	checkoutPage = new CheckoutPage(Common.driver);
    	Assert.assertTrue(checkoutPage.hasBackToProductsButton(),"Back to products button not displayed");
    }}
