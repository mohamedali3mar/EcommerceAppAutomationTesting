package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;

    @Before
    public static void setupBrowser(){
        //1.bridge
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //2.create new object of chrome driver
        driver = new ChromeDriver();

        //3.configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 4- navigate to url
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public static void terminateBrowser(){
        driver.quit();
    }
}
