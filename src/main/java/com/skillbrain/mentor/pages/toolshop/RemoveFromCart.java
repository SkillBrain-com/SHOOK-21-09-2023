package com.skillbrain.mentor.pages.toolshop;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RemoveFromCart {
    By priceItem = By.xpath("(//td[@class='col-md-2 text-end'])[1]");
    By totalPrice = By.xpath("(//td[@class='col-md-2 text-end'])[2]");
    By textItem = By.cssSelector("span.product-title");
    By quantityItem = By.cssSelector("input[type='number']");

   By removeFromCart = By.cssSelector("i.fa.fa-remove");

   By item = By.xpath("(//tfoot/tr/td)[1]");
   By totalprice = By.xpath("(//td[@class = 'col-md-2 text-end'])[2]");

    WebDriver driver;
    WebDriverWait wait;

    public RemoveFromCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void removeFromCart(){

        driver.findElement(removeFromCart).click();


    }

    public void removeConfirm() {

        Assert.assertEquals(driver.findElement(item).getText(),"");
        wait.until(ExpectedConditions.textToBe(totalprice,"$0.00"));
        Assert.assertEquals(driver.findElement(totalprice).getText(),"$0.00");
    }

    public void deleteFromQuantityItems(){
        AddToCart addToCart = new AddToCart(driver);
        addToCart.addCart();
        driver.findElement(quantityItem).click();
        driver.findElement(quantityItem).clear();
        driver.findElement(quantityItem).sendKeys("1");
        driver.findElement(quantityItem).sendKeys(Keys.ENTER);

    }

    public void confirmationDeleteItem(){

        String itemText = driver.findElement(textItem).getText();
        Assert.assertEquals(itemText,"Combination Pliers ");

        String itemPrice = driver.findElement(priceItem).getText();
        Assert.assertEquals(itemPrice,"$14.15");

        wait.until(ExpectedConditions.textToBe(totalPrice,"$14.15"));
        String priceTotal = driver.findElement(totalPrice).getText();
        Assert.assertEquals(priceTotal,"$14.15");
    }


}
