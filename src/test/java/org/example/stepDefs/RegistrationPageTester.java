package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.RegisterPage;
import org.testng.asserts.SoftAssert;

public class RegistrationPageTester {
    RegisterPage registerPage = new RegisterPage(Hooks.driver);
    @Given("user go to register page")
    public void goToRegisterPage()
    {
        registerPage.navigateToRegisterPage();
    }

    @When("user select gender type")
    public void selectGender(){
        registerPage.setGenderMale();
    }


    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        registerPage.setFirstName(firstName);
        registerPage.setLastName(lastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        registerPage.setDateOfBirth();
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {
        registerPage.setEmail(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String confirmation) {
        registerPage.setPassword(password);
        registerPage.setPasswordConfirmation(confirmation);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        registerPage.clickSubmitRegister();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.isResultContain("Your registration completed"), "Result of registration isn't correct");
        softAssert.assertEquals(registerPage.getColor(),"rgba(76, 177, 124, 1)", "incorrect color of result text");
        softAssert.assertAll();
    }
}
