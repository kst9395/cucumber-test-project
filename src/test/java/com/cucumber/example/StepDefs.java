package com.cucumber.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefs {

    private WebDriver webdriver;

    @Before
    public void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
    }

    @Given("that user enter shopee website.")
    public void when_open_shopee() {
        webdriver.get("https://shopee.com.my");
    }

    @Then("advertisement should pop up correctly.")
    public void verify_advertisement() {
        WebDriverWait wait = new WebDriverWait(webdriver, 3);
        wait.until(driver -> {
            WebElement popUpContainer = driver.findElement(By.className("shopee-popup__container"));
            return popUpContainer.isDisplayed();
        });

    }

    @After
    public void close_browser() {
        if (webdriver != null) {
            webdriver.close();
        }
    }

}
