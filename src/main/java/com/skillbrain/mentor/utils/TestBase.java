package com.skillbrain.mentor.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Wait<WebDriver> wait;

    @BeforeMethod
    public void setup() throws Exception{

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        //options.addArguments("headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Set browser resolution(used for headless mode)
        //driver.manage().window().setSize(new Dimension(1920,1080));

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @AfterMethod
    public void tearDown() throws Exception{
        driver.quit();
    }



}
