package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class HomeSlidersTester {
    HomePage homePage = new HomePage(Hooks.driver);

    @When("user click on slider number {string}")
    public void userClickOnSliderNumber(String slideNumber) {
        homePage.homeSliders.get(Integer.parseInt(slideNumber)-1).click();
    }

    @And("user click on the displayed product image")
    public void clickDisplayedProductImage(){
        homePage.currentDisplayedImage.click();
    }

    @Then("user gets directed to the product url {string}")
    public void userGetsDirectedToTheProductUrl(String url) {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), url,
                "User failed to navigate to the product displayed in the home slider when clicked on it's image");
    }
}
