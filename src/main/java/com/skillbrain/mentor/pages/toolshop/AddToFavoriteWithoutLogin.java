package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToFavoriteWithoutLogin {
    By firstItem = By.xpath("(//div[@class = 'card-body'])[1]");

    By errorMessage = By.cssSelector("ngb-toast.toast");
    By addToFavorite = By.id("btn-add-to-favorites");

    WebDriver driver;
    WebDriverWait wait;

    public AddToFavoriteWithoutLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void addToFavorite(){
        driver.findElement(firstItem).click();

        driver.findElement(addToFavorite).click();
    }

    public void failedToAddConfirmation(){
        wait.until(ExpectedConditions.textToBe(errorMessage,"Unauthorized, can not add product to your favorite list."));
        String messageError = driver.findElement(errorMessage).getText();
        Assert.assertEquals(messageError,"Unauthorized, can not add product to your favorite list.");
    }

}
