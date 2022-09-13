package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class HomePageCurrencyTester {
    HomePage homePage = new HomePage(Hooks.driver);

    @Given("user is in the home page")
    public void goToHomePage(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user select {string} currency")
    public void userSelectCurrency(String currency) {
        homePage.setCurrency(currency);
    }

    @Then("all products in home page have the euro symbol currency")
    public void allProductsInHomePageHaveTheEuroSymbolCurrency() {
        Assert.assertTrue(homePage.isCurrencyCorrect(),"Products currency didn't change with currency settings");
    }
}
