package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WishlistTester {
    HomePage homePage = new HomePage(Hooks.driver);

    @When("user add product to wishlist using the heart icon")
    public void userAddProductToWishlistUsingTheHeartIcon() {
        homePage.clickAddWishlist();
    }

    @Then("a message of success addition with green background is displayed")
    public void aMessageOfSuccessAdditionWithGreenBackgroundIsDisplayed() {
        System.out.println(homePage.getWishlistAdditionMessage());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getWishlistAdditionMessage(),
                "The product has been added to your wishlist",
                "Incorrect message displayed when product added to wishlist");
        softAssert.assertEquals(Color.fromString(
                homePage.getWishlistAdditionMessageColor()).asHex(),
                "#4bb07a",
                "Incorrect wishlist success message color"
        );
        softAssert.assertAll();
    }

    @And("waits for the green message to disappear")
    public void waitsForTheGreenMessageToDisappear() {
        homePage.waitUntilWishlistMessageDisappear();
    }

    @Then("user go to wishlist page")
    public void userGoToWishlistPage(){
        homePage.goToWishlistPage();
    }

    @And("user have quantity of items in his wishlist greater than zero")
    public void userHaveQuantityOfItemsInHisWishlistGreaterThanZero() {
        Assert.assertTrue(
                Integer.parseInt(homePage.getItemQuantity()) > 0,
                "Incorrect quantity of items in the wishlist");
    }
}
