package org.example.pages;

import org.example.stepDefs.Hooks;
import org.example.stepDefs.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// page_url = https://demo.nopcommerce.com/
public class HomePage {
    @FindBy(id = "customerCurrency")
    public WebElement customerCurrencyMenu;

    @FindBy(css = "span.price.actual-price")
    public List<WebElement> pricesTagline;

    @FindBy(id = "small-searchterms")
    public WebElement searchField;

    @FindBy(css = "h2.product-title")
    public List<WebElement> searchProducts;

    @FindBy(xpath = "//*[starts-with(@id,'sku')]")
    public WebElement productSkuValue;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/h2/a")
    public WebElement firstProduct;

    @FindBy(css = "html > body > div:nth-of-type(6) > div:nth-of-type(2) > ul:nth-of-type(1) > li > a")
    public List<WebElement> mainCategories;

    @FindBy(css = "div.page-title > h1")
    public WebElement categoryHeader;

    @FindBy(css = "div.slider-wrapper > div.nivo-controlNav > a")
    public List<WebElement> homeSliders;

    @FindBy(css = "div.slider-wrapper > div#nivo-slider")
    public WebElement currentDisplayedImage;

    @FindBy(css = "html > body > div:nth-of-type(6) > div:nth-of-type(3) > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > button:nth-of-type(3)")
    public WebElement addWishlistButton;

    @FindBy(css = "a[class=\"ico-wishlist\"]")
    public WebElement wishlistPageButton;

    @FindBy(css = "input[class=\"qty-input\"]")
    public WebElement itemQuantity;
    

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setCurrency(String currency){
        Select selectCurrency = new Select(customerCurrencyMenu);
        selectCurrency.selectByVisibleText(currency);
    }

    public boolean isCurrencyCorrect(){
        String symbol = "$";
        Select selectCurrency = new Select(customerCurrencyMenu);
        boolean allCorrect = true;
        if(selectCurrency.getFirstSelectedOption().getText().equals("Euro")) symbol = "€";
        else if(customerCurrencyMenu.getText().equals("US Dollar")) symbol = "$";
        for (WebElement price:pricesTagline) {
            allCorrect &= price.getText().contains(symbol);
        }
        return allCorrect;
    }

    public boolean isProductsContainSearchTerm(String searchWord){
        boolean allContains = true;
        for (WebElement product:searchProducts) {
            allContains &= product.getText().toLowerCase().contains(searchWord.toLowerCase());
        }
        return allContains;
    }

    public void search(String keyword){
        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.ENTER);
    }

    public void openFirstProduct(){
        firstProduct.click();
    }

    //Needs Fixing
    public String selectRandomCategory(){
        Actions actions = new Actions(Hooks.driver);
        int randomCategoryIndex = Utility.getRandomNumber(0,mainCategories.size());
        actions.moveToElement(mainCategories.get(randomCategoryIndex)).perform();
        String selectedCategoryName = mainCategories.get(randomCategoryIndex).getText();
        if(randomCategoryIndex < 3){
            randomCategoryIndex++;
            List<WebElement> subCategories = Hooks.driver.findElements(By.cssSelector(
                    "html > body > div > div> ul.notmobile > li:nth-of-type("+randomCategoryIndex+") > ul > li"
            ));
            int randomSubCategoryIndex = Utility.getRandomNumber(0,subCategories.size());
            actions.moveToElement(subCategories.get(randomSubCategoryIndex)).perform();
            selectedCategoryName = subCategories.get(randomSubCategoryIndex).getText();
        }
        //build()- used to compile all the actions into a single step
        actions.click().build().perform();
        return selectedCategoryName;
    }

    public void clickSocialLink(String socialMediaName){
        Hooks.driver.findElement(
                By.cssSelector("div.social > ul.networks > li."+socialMediaName+"")
        ).click();
    }

    public void clickAddWishlist(){
        addWishlistButton.click();
    }

    public String getWishlistAdditionMessage(){
        return Hooks.driver.findElement(
                By.cssSelector("div#bar-notification > div.success > p.content"))
                .getText();
    }

    public String getWishlistAdditionMessageColor(){
        return Hooks.driver.findElement(
                        By.cssSelector("div#bar-notification > div.success"))
                .getCssValue("background-color");
    }

    public void waitUntilWishlistMessageDisappear(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#bar-notification > div.success")));
    }

    public void goToWishlistPage() {
        wishlistPageButton.click();
    }

    public String getItemQuantity(){
        return itemQuantity.getAttribute("value");
    }
}