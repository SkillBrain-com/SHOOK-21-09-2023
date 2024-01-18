package com.skillbrain.mentor.pages.browserStackDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrderConfirmationPage {

    private By successMessage = By.id("confirmation-message");
    private By productName = By.cssSelector("h5.product-title.optimizedCheckout-contentPrimary");
    private By quantity = By.xpath("(//ul[@class=\"product-options optimizedCheckout-contentSecondary\"]/child::li)[2]");



    WebDriver driver;
    WebDriverWait wait;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyOrderPlacement(){
        String actualSuccessMessage = driver.findElement(successMessage).getText();
        Assert.assertEquals(actualSuccessMessage,"Your Order has been successfully placed.");

        String actualProductName = driver.findElement(productName).getText();
        Assert.assertEquals(actualProductName, "iPhone 12");

        String actualQuantity = driver.findElement(quantity).getText();
        Assert.assertEquals(actualQuantity, "1");
    }
}
