package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPageInvalidUser {


    By email = By.id("email");
    By password = By.cssSelector("#password");
    By login = By.className("btnSubmit");



    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPageInvalidUser(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void loginPage(String emailParam,String passwordParam){

        driver.findElement(email).sendKeys(emailParam);
        driver.findElement(password).sendKeys(passwordParam);
        driver.findElement(login).click();

    }

    public void invalidUser(){
        String messageText = driver.findElement(By.cssSelector(".help-block")).getText();
        Assert.assertEquals(messageText,"Invalid email or password");
    }
}
