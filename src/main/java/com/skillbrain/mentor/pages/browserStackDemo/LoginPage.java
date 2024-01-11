package com.skillbrain.mentor.pages.browserStackDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private By usernameField = By.id("react-select-2-input");
    private By passwordField = By.id("react-select-3-input");
    private By loginButton = By.id("login-btn");
    private By usernameElement = By.cssSelector("span.username");
    private By logoutButton = By.id("logout");
    private By lockedAccountError = By.cssSelector("h3.api-error");
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(usernameField)));
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(usernameField).sendKeys(Keys.ENTER);

        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
        driver.findElement(loginButton).click();
    }

    public void verifySuccessfulLogin() throws InterruptedException {
        Thread.sleep(2000);
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, "https://bstackdemo.com/?signin=true");
        Assert.assertTrue(driver.findElement(usernameElement).isDisplayed());

        String actualUsername = driver.findElement(usernameElement).getText();
        Assert.assertEquals(actualUsername, "demouser");

        Assert.assertTrue(driver.findElement(logoutButton).isDisplayed());
    }

    public void verifyLockedAccountLogin(){
    Assert.assertTrue(driver.findElement(lockedAccountError).isDisplayed());

    String errorMessage = driver.findElement(lockedAccountError).getText();
    Assert.assertEquals(errorMessage, "Your account has been locked.");
    }
}
