package com.skillbrain.mentor.pages.demoBlaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignUpPage {

    By userName = By.cssSelector("#sign-username");
    By passwordLogin = By.cssSelector("#sign-password");
    By login = By.xpath("//div[@class = 'modal-footer']//following-sibling::button[@onclick='register()']");

    WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void signUp(String name, String password ){

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userName)));

        driver.findElement(userName).sendKeys(name);
        driver.findElement(passwordLogin).sendKeys(password);
        driver.findElement(login).click();
    }
    public  void confirmationSignUp() throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage,"Sign up successful.");
        alert.dismiss();

    }
}
