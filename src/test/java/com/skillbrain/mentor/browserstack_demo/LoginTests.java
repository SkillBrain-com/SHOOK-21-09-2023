package com.skillbrain.mentor.browserstack_demo;

import com.skillbrain.mentor.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.security.Key;

public class LoginTests extends TestBase {

    @Test
    public void successfulLogin() throws InterruptedException {
        driver.get("https://bstackdemo.com/signin");

        Thread.sleep(2000);
        driver.findElement(By.id("react-select-2-input")).sendKeys("demouser");
        driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("react-select-3-input")).sendKeys("testingisfun99");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("login-btn")).click();
        String url = driver.getCurrentUrl();
        if(url.equalsIgnoreCase("https://bstackdemo.com/?signin=true")){
            //true -> test passes
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            //false -> test fails
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
        if(driver.findElement(By.id("logout")).isDisplayed()){
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
        String username= driver.findElement(By.className("username")).getText();
        if(driver.findElement(By.className("username")).isDisplayed() &&
                username.equalsIgnoreCase("demouser")){
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }

    @Test
    public void lockedUserLogin() throws InterruptedException {
        driver.get("https://bstackdemo.com/signin");

        Thread.sleep(2000);
        driver.findElement(By.id("react-select-2-input")).sendKeys("locked_user");
        driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("react-select-3-input")).sendKeys("testingisfun99");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("login-btn")).click();

        String url = driver.getCurrentUrl();
        if(url.equalsIgnoreCase("https://bstackdemo.com/signin")){
            //true -> test passes
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            //false -> test fails
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
        String errorMessage = driver.findElement(By.className("api-error")).getText();
        if(driver.findElement(By.className("api-error")).isDisplayed() &&
        errorMessage.equalsIgnoreCase("Your account has been locked.")){
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }
}
