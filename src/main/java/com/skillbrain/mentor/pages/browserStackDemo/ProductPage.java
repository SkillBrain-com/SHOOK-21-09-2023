package com.skillbrain.mentor.pages.browserStackDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {


    private By addToCart = By.xpath("(//div[@class='shelf-item__buy-btn'])[1]");

    private By removeToCart = By.cssSelector("div[class=\"shelf-item__del\"]");

    private By emptyCartParagraf = By.cssSelector("p[class=\"shelf-empty\"]");



    WebDriver driver;

    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void addRemoveTocart(){

        driver.findElement(addToCart).click();
        driver.findElement(removeToCart).click();

    }


    public void emptyCard()  {


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emptyCartParagraf)));
        String emtyParagraf = driver.findElement(emptyCartParagraf).getText();

        System.out.println(emtyParagraf);
        Assert.assertEquals(emtyParagraf, "Add some products in the bag\n:)");

    }


}
