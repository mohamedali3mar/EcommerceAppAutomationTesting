package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class LoginPageTester {
    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("user go to login page")
    public void goToLoginPage(){
        loginPage.navigateToLoginPage();
    }

    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String type, String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "Incorrect url after login");
        softAssert.assertTrue(loginPage.isMyAccountExists(), "False failure to login, can't find the myAccount tab");
        softAssert.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isResultContain("Login was unsuccessful"),
                "Displayed message after an invalid login doesn't imply login failure");
        softAssert.assertEquals(loginPage.getColor(),"#e4434b","Incorrect fail message color");
        softAssert.assertAll();
    }
}
