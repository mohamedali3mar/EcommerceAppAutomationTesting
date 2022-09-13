package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.Color;

// page_url = https://demo.nopcommerce.com/login
public class LoginPage {
    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(css = "button[class$=\"login-button\"]")
    public WebElement loginButton;

    @FindBy(css = "a[class=\"ico-login\"]")
    public WebElement loginPage;

    @FindBy(css = "a[class=\"ico-account\"]")
    public WebElement myAccountLabel;

    @FindBy(css = "div[class^=\"message-error\"]")
    public WebElement loginStatusMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage(){
        loginPage.click();
    }

    public void setEmail(String email){
        emailField.sendKeys(email);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public boolean isMyAccountExists(){
        return myAccountLabel.isDisplayed();
    }

    public boolean isResultContain(String result){
        return loginStatusMessage.getText().contains(result);
    }

    public String getColor(){
        System.out.println(loginStatusMessage.getCssValue("color"));
        return Color.fromString(loginStatusMessage.getCssValue("color")).asHex();
    }
}