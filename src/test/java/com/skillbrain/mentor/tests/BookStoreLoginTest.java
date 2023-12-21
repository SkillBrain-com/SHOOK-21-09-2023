package com.skillbrain.mentor.tests;

import com.skillbrain.mentor.utils.TestBase;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BookStoreLoginTest extends TestBase {
    @Test
    public void verifyMandatoryFields() throws InterruptedException {
        driver.get("https://demoqa.com/login");

        driver.findElement(By.id("login")).click();

        String userNameAttribute = driver.findElement(By.id("userName")).getAttribute("class");

        if (userNameAttribute.equalsIgnoreCase("mr-sm-2 is-invalid form-control")){
            Thread.sleep(3000);
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }

        String passwordAttribute = driver.findElement(By.id("password")).getAttribute("class");
        if (passwordAttribute.equalsIgnoreCase("mr-sm-2 is-invalid form-control")){
            Thread.sleep(3000);
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }

    }

    @Test
    public void successfulLogin() throws InterruptedException {
        driver.get("https://demoqa.com/login");

        driver.findElement(By.id("userName")).sendKeys("andreisoare");
        driver.findElement(By.id("password")).sendKeys("Test123!");
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);

        String userNameValue = driver.findElement(By.id("userName-value")).getText();
        if (userNameValue.equalsIgnoreCase("andreisoare")){
            Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        }else {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }

}
