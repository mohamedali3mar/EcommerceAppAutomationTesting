package org.example.pages;

import org.example.stepDefs.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

// page_url = https://demo.nopcommerce.com/register
public class RegisterPage {
    @FindBy(id = "gender-male")
    public WebElement gender;

    @FindBy(css = "input[id=\"FirstName\"]")
    public WebElement firstnameField;

    @FindBy(css = "input[id=\"LastName\"]")
    public WebElement lastnameField;

    @FindBy(css = "select[name=\"DateOfBirthDay\"]")
    public WebElement dateOfBirthDay;

    @FindBy(css = "select[name=\"DateOfBirthMonth\"]")
    public WebElement dateOfBirthMonth;

    @FindBy(css = "select[name=\"DateOfBirthYear\"]")
    public WebElement dateOfBirthYear;

    @FindBy(css = "input[id=\"Email\"]")
    public WebElement emailField;

    @FindBy(css = "input[id=\"Password\"]")
    public WebElement passwordField;

    @FindBy(css = "input[id=\"ConfirmPassword\"]")
    public WebElement passwordConfirmationField;

    @FindBy(id = "register-button")
    public WebElement submitButton;

    @FindBy(css = "a[class=\"ico-register\"]")
    public WebElement registerPage;

    @FindBy(css = "div[class=\"result\"]")
    public WebElement registrationCompletedMessage;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegisterPage(){
        registerPage.click();
    }

    public void setGenderMale(){
        gender.click();
    }

    public void setFirstName(String firstName){
        firstnameField.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastnameField.sendKeys(lastName);
    }

    public void setDateOfBirth(){
        Select selectBirthDay = new Select(dateOfBirthDay);
        Select selectBirthMonth = new Select(dateOfBirthMonth);
        Select selectBirthYear = new Select(dateOfBirthYear);
        selectBirthDay.selectByIndex(Utility.getRandomNumber(2,28));
        selectBirthMonth.selectByValue("3");
        selectBirthYear.selectByValue("1998");
    }

    public void setEmail(String email){
        emailField.sendKeys(email);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void setPasswordConfirmation(String password){
        passwordConfirmationField.sendKeys(password);
    }

    public void clickSubmitRegister(){
        submitButton.sendKeys(Keys.ENTER);
    }

    public boolean isResultContain(String result){
        return registrationCompletedMessage.getText().contains(result);
    }

    public String getColor(){
        System.out.println(registrationCompletedMessage.getCssValue("color"));
        return registrationCompletedMessage.getCssValue("color");
    }
}