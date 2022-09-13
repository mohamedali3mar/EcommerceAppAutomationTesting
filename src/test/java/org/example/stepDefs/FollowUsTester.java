package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.HomePage;
import org.openqa.selenium.devtools.v85.dom.model.PseudoType;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FollowUsTester {
    HomePage homePage = new HomePage(Hooks.driver);

    @When("user opens {string} link")
    public void userOpensLink(String socialMediaName){
        homePage.clickSocialLink(socialMediaName);
    }

    @Then("user is navigated to new tab of url contains {string}")
    public void userIsNavigatedToNewTabOfUrlContains(String socialMediaName){
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        try{
            Hooks.driver.switchTo().window(tabs.get(1));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Social link wasn't opened in a new tab");
        }
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(socialMediaName),
                "user failed to navigate to the clicked social media page");
    }
}
