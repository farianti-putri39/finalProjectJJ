package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebPage;

public class WebStep {

    WebPage webPage = new WebPage();

    @Given("Open web page")
    public void openWebPage() {
        webPage.openBrowser();
    }

    @And("click link for {string}")
    public void clickLoginLink(String link) {
        webPage.prepareLink(link);
    }

    @And("Pop up is displayed for {string}")
    public void popUpIsDisplayed(String popup) {
        webPage.preparePopUp(popup);
    }

    @And("User input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("User input password {string}")
    public void userInputPassword(String password) {
        webPage.inputPassword(password);
    }


    @When("click {string} button")
    public void userClickLoginButton(String button) {
        webPage.clickButton(button);
    }

    @Then("User will see {string} text")
    public void userWillSeeText(String text) {
        webPage.assertPage(text);
    }

    @Then("Message alert is displayed {string}")
    public void alertIsDisplayed(String errorMessage) throws InterruptedException {
        webPage.validateErrorAlert(errorMessage);
    }

    @And("User input contact {string}")
    public void userInputContact(String field) {
        webPage.sendContactMessage(field);
    }


    @And("click product link for Samsung Galaxy S6")
    public void clickProductLinkFor() {
        webPage.clickProductLink();
    }

    @And("click Add to Cart button")
    public void clickAddToCartButton() {
        webPage.addToCart();
    }

    @And("verify product is in cart")
    public void verifyProductInCart() {
        webPage.verifyProductInCart();
    }

    @And("click Place Order button")
    public void clickPlaceOrderButton() {
        webPage.clickPlaceOrder();
    }

    @And("fill order form")
    public void fillOrderForm() {
        webPage.fillOrderForm();
    }

    @And("verify order is successful")
    public void verifyOrderIsSuccessful() {
        webPage.verifyOrderSuccessful();
    }
}
