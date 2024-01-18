package com.skillbrain.mentor.pages.browserStackDemo;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {

    private By firstName = By.id("firstNameInput");
    private By lastName = By.id("lastNameInput");
    private By address = By.id("addressLine1Input");
    private By province = By.id("provinceInput");
    private By postCode = By.id("postCodeInput");
    private By submitButton = By.id("checkout-shipping-continue");
    private By productName = By.cssSelector("h5.product-title.optimizedCheckout-contentPrimary");
    private By productQuantity = By.xpath("(//ul[@class=\"product-options optimizedCheckout-contentSecondary\"]/child::li)[2]");


    WebDriver driver;
    WebDriverWait wait;
    Faker faker = new Faker();

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void fillShippingAddress(){
        driver.findElement(firstName).sendKeys(faker.name().firstName());
        driver.findElement(lastName).sendKeys(faker.name().lastName());
        driver.findElement(address).sendKeys(faker.address().fullAddress());
        driver.findElement(province).sendKeys(faker.address().state());
        driver.findElement(postCode).sendKeys(faker.address().zipCode());

        String actualProductName = driver.findElement(productName).getText();
        Assert.assertEquals(actualProductName, "iPhone 12");

        String actualProductQuantity = driver.findElement(productQuantity).getText();
        Assert.assertEquals(actualProductQuantity, "1");

        driver.findElement(submitButton).click();
    }
}
