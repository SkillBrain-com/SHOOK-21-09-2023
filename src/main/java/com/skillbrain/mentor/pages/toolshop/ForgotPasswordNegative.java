package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ForgotPasswordNegative {

    By email = By.id("email");
    By submitButton = By.cssSelector("input[type=\"submit\"]");

    By messageNegative = By.cssSelector(".alert.alert-danger");
    WebDriver driver;
    WebDriverWait wait;

    public ForgotPasswordNegative(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void forgotPasswordNegative(){
        driver.findElement(email).sendKeys("maria@yahoo.com");
        driver.findElement(submitButton).click();
    }


    public void messageForgotPasswordNegative(){

        String messageTextConfirmation = driver.findElement(messageNegative).getText();
        Assert.assertEquals(messageTextConfirmation, "The selected email is invalid.");

    }
}
