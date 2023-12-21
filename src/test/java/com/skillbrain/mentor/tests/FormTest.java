package com.skillbrain.mentor.tests;

import com.skillbrain.mentor.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest  extends TestBase {

    @Test
    public void formTest(){


        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("ionel");

    }


}
