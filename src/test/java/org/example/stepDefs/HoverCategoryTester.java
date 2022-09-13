package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class HoverCategoryTester {
    HomePage homePage = new HomePage(Hooks.driver);
    String selectedCategory;

    @When("users selects random category")
    public void searchByCategory() throws InterruptedException {
        selectedCategory = homePage.selectRandomCategory();
    }

    @Then("the category title is the same as the randomly selected category")
    public void checkCategoryTitle() {
        Assert.assertEquals(homePage.categoryHeader.getText().toLowerCase().trim(),
                selectedCategory.toLowerCase().trim(),
                "Category header isn't the same as the randomly selected category");
    }
}
