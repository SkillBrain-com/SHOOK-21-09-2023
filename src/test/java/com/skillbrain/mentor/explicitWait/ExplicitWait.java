package com.skillbrain.mentor.explicitWait;

import com.skillbrain.mentor.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait extends TestBase {

    @Test
    public void explicitWait(){
        driver.findElement(By.id("userName")).sendKeys("ionel");
        driver.findElement(By.id("userEmail")).sendKeys("ionel@mailinator.com");
        driver.findElement(By.id("currentAddress")).sendKeys("adresa mea curenta");
        driver.findElement(By.id("permanentAddress")).sendKeys("adresa mea permanenta");
        driver.findElement(By.id("submit")).click();


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name"))));
    }


}
