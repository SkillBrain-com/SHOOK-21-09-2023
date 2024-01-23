package com.skillbrain.mentor.pages.toolshop;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCart {

    By firstItem = By.xpath("(//div[@class = 'card-body'])[1]");
    By addMoreItems = By.cssSelector("i.fa.fa-plus");
    By addToCartButton = By.id("btn-add-to-cart");

    By cartPage = By.cssSelector("span#lblCartCount");
    By textItem = By.cssSelector("span.product-title");
    By quantityItem = By.cssSelector("input[type='number']");
    By priceItem = By.xpath("(//td[@class='col-md-2 text-end'])[1]");
    By totalPrice = By.xpath("(//td[@class='col-md-2 text-end'])[2]");

    public WebDriver driver;
    public WebDriverWait wait;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void addCart(){

        driver.findElement(firstItem).click();
        driver.findElement(addMoreItems).click();
        driver.findElement(addToCartButton).click();
        driver.findElement(cartPage).click();

    }

    public void itemConfirmation(){

        String itemText = driver.findElement(textItem).getText();
        Assert.assertEquals(itemText,"Combination Pliers ");

//        //Dupa cantitate nu putem verifica si o sa verificam dupa pricePerItem si totalPrice
//        String itemQuantity = driver.findElement(quantityItem).getText();
//        Assert.assertEquals(itemQuantity,"1");

        String itemPrice = driver.findElement(priceItem).getText();
        Assert.assertEquals(itemPrice,"$14.15");


        String priceTotal = driver.findElement(totalPrice).getText();
        Assert.assertEquals(priceTotal,"$28.30");
    }


}
