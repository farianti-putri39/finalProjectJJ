package pages;

import helper.Endpoint;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDef.Hooks;

import static helper.Utility.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WebPage {

    String username, password, setUsername, email, name, message;

    By setLink, setPopUp, setUsernameField, setPasswordField, setButton, setContactField, setText;
    By link_login = By.id("login2");
    By link_signup = By.id("signin2");
    By link_contact = By.cssSelector("a[data-target='#exampleModal']");
    By link_about = By.cssSelector("a[data-target='#videoModal']");
    By link_cart = By.cssSelector("#cartur");

    By login_popup = By.cssSelector("div[id='logInModal'] div[class='modal-content']");
    By signup_popup = By.cssSelector("div[id='signInModal'] div[class='modal-content']");
    By contact_popup = By.cssSelector("div[id='exampleModal'] div[class='modal-content']");
    By about_popup = By.cssSelector("div[id='videoModal'] div[class='modal-content']");

    By login_username = By.cssSelector("#loginusername");
    By login_password = By.cssSelector("#loginpassword");

    By signup_username = By.cssSelector("#sign-username");
    By signup_password = By.cssSelector("#sign-password");

    By contact_email = By.cssSelector("#recipient-email");
    By contact_name = By.cssSelector("#recipient-name");
    By contact_message = By.cssSelector("#message-text");

    By btn_login = By.cssSelector("button[onclick='logIn()']");
    By btn_signup = By.cssSelector("button[onclick='register()']");
    By btn_contact = By.cssSelector("button[onclick='send()']");
    By btn_close_about = By.cssSelector("div[id='videoModal'] div[class='modal-footer'] button[type='button']");
    By welcomeText = By.cssSelector("#nameofuser");
    By productsText = By.xpath("//h2[normalize-space()='Products']");

    By link_productSGS6 = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    By btn_add_cart = By.xpath("//a[normalize-space()='Add to cart']");
    By text_cart_SGS6 = By.xpath("//td[normalize-space()='Samsung galaxy s6']");
    By btn_order = By.xpath("//button[normalize-space()='Place Order']");

    By order_popup = By.cssSelector("div[id='orderModal'] div[class='modal-content']");
    By order_name = By.cssSelector("#name");
    By order_country = By.cssSelector("#country");
    By order_city = By.cssSelector("#city");
    By order_card = By.cssSelector("#card");
    By order_month = By.cssSelector("#month");
    By order_year = By.cssSelector("#year");
    By btn_purchase = By.cssSelector("button[onclick='purchaseOrder()']");
    By order_success = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");



    public void openBrowser(){
        //startDriver();
        driver.get("https://www.demoblaze.com/");
    }

    public void prepareLink(String link){
        switch (link) {
            case "Login" :
                setLink = link_login;
                break;
            case "Sign Up" :
                setLink = link_signup;
                break;
            case "Contact" :
                setLink = link_contact;
                break;
            case "About" :
                setLink = link_about;
                break;
            case "Cart" :
                setLink = link_cart;
                break;
        }
        driver.findElement(setLink).click();
    }

    public void preparePopUp(String popup){
        switch (popup) {
            case "Login" :
                setPopUp = login_popup;
                break;
            case "Sign Up" :
                setPopUp = signup_popup;
                break;
            case "Contact" :
                setPopUp = contact_popup;
                break;
            case "About" :
                setPopUp = about_popup;
                break;
        }
        System.out.println(setPopUp);
        driver.findElement(setPopUp).isDisplayed();
    }

    public void inputUsername(String username){
        switch (username) {
            case "new_user" :
                setUsernameField = signup_username;
                setUsername = generateRandomEmail();
                break;
            case "existing_user" :
                setUsernameField = signup_username;
                setUsername = "standard_user";
                break;
            default:
                setUsernameField = login_username;
                setUsername = username;
        }
        System.out.println(setUsername);
        driver.findElement(setUsernameField).sendKeys(setUsername);
    }

    public void inputPassword(String password){
        if (password.equals("password")) {
            setPasswordField = signup_password;
        } else {
            setPasswordField = login_password;
        }
        System.out.println(setPasswordField);
        driver.findElement(setPasswordField).sendKeys(password);
    }

    public void clickButton(String button){
        switch (button) {
            case "Login" :
                setButton = btn_login;
                break;
            case "Sign Up" :
                setButton = btn_signup;
                break;
            case "Send message" :
                setButton = btn_contact;
                break;
            case "Close About" :
                setButton = btn_close_about;
                break;
        }
        System.out.println(setButton);
        driver.findElement(setButton).click();
    }

    public void assertPage(String text){
        switch (text) {
            case "Welcome" :
                setText = welcomeText;
                break;
            case "Products" :
                setText = productsText;
                break;
        }
        driver.findElement(setText).isDisplayed();
    }

    public void assertCartPage(){
        driver.findElement(productsText).isDisplayed();
    }

    public void validateErrorAlert(String errorMessage) throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        assertThat(alertMessage).contains(errorMessage);
        alert.accept();
    }

    public void sendContactMessage(String contactField){
        switch (contactField) {
            case "email" :
                setContactField = contact_email;
                email = generateRandomEmail();
                driver.findElement(setContactField).sendKeys(email);
                break;
            case "name" :
                setContactField = contact_name;
                name = "Name";
                driver.findElement(setContactField).sendKeys(name);
                break;
            case "message" :
                setContactField = contact_message;
                message = "Message";
                driver.findElement(setContactField).sendKeys(message);
                break;
        }
    }

    public void clickProductLink(){
        driver.findElement(link_productSGS6).click();
    }

    public void addToCart(){
        driver.findElement(btn_add_cart).click();
    }

    public void verifyProductInCart(){
        driver.findElement(text_cart_SGS6).isDisplayed();
    }

    public void clickPlaceOrder(){
        driver.findElement(btn_order).click();
    }

    public void fillOrderForm(){
        driver.findElement(order_name).sendKeys("Name");
        driver.findElement(order_city).sendKeys("City");
        driver.findElement(order_country).sendKeys("Country");
        driver.findElement(order_card).sendKeys("Card");
        driver.findElement(order_month).sendKeys("Month");
        driver.findElement(order_year).sendKeys("Year");
        driver.findElement(btn_purchase).click();
    }

    public void verifyOrderSuccessful(){
        driver.findElement(order_success).isDisplayed();
    }
}
