package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class SearchTester {
    HomePage homePage = new HomePage(Hooks.driver);

    @Then("search result appears")
    public void searchResultPage(){
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("demo.nopcommerce.com/search?q="),"Failed to load the search page");
    }

    @When("user search with {string}")
    public void userSearchWith(String searchKeyword) {
        homePage.search(searchKeyword);
    }

    @And("user click on the product in search result")
    public void openProduct() {
        homePage.openFirstProduct();
    }

    @And("the product's sku contains the searched {string}")
    public void confirmSkuExistence(String searchedSku) {
        Assert.assertEquals(homePage.productSkuValue.getText().toLowerCase(),searchedSku.toLowerCase(),
                "SKU results aren't same as sku used in the search");
    }

    @And("all products in the result are relevant to the search keyword {string}")
    public void confirmProductsRelevance(String searchedKeyword) {
        Assert.assertTrue(homePage.isProductsContainSearchTerm(searchedKeyword),
                "Incorrect search results, products aren't relevant to the search word");
    }
}
