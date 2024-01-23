package com.skillbrain.mentor.pages.toolshop;

import com.skillbrain.mentor.utils.DataGeneration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ForgotPassword {

    By email = By.id("email");
    By submitButton = By.cssSelector("input[type=\"submit\"]");

    By messageConfirmation = By.xpath("//div[@class = 'alert alert-success mt-3']");
    WebDriver driver;
    WebDriverWait wait;

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void forgotPassword(){
        driver.findElement(email).sendKeys("alex@yahoo.com");
        driver.findElement(submitButton).click();
    }


    public void confirmationPasswordUpdated(){

        String messageTextConfirmation = driver.findElement(messageConfirmation).getText();
        Assert.assertEquals(messageTextConfirmation, "Your password is successfully updated!");

    }

}
