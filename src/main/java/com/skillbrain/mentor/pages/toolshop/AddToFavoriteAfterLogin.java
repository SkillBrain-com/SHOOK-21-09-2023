package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToFavoriteAfterLogin {

    By backToHomePage = By.cssSelector("a.nav-link.active");
    By firstItem = By.xpath("(//div[@class = 'card-body'])[1]");
    By addToFavorite = By.id("btn-add-to-favorites");
    By userName = By.cssSelector("#user-menu");
    By favoriteList = By.xpath("(//li/a[@class='dropdown-item'])[7]");
    By itemsText = By.cssSelector("h5.card-title");


    public WebDriver driver;
    public WebDriverWait wait;

    public AddToFavoriteAfterLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public void addItemToFavorite(){
        driver.findElement(backToHomePage).click();
        driver.findElement(firstItem).click();
        driver.findElement(addToFavorite).click();
        driver.findElement(userName).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(favoriteList)));
        driver.findElement(favoriteList).click();
    }

    public void itemConfirmation(){
        String messageItem = driver.findElement(itemsText).getText();
        Assert.assertEquals(messageItem,"Combination Pliers");
    }
}
