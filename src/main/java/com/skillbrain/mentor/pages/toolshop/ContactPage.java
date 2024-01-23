package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactPage {

    By fName = By.id("first_name");

    By lName = By.id("last_name");

    By email = By.cssSelector("#email");

    By subject = By.cssSelector("#subject");

    By message = By.cssSelector("#message");

    By chooseFile = By.cssSelector("#attachment");

    By send = By.cssSelector("input[type = \"submit\"]");

    By option = By.cssSelector("option[value=\"customer-service\"]");





    public WebDriver driver;
    public WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }


    public void contactPage(String firstName , String lastName, String emailAddress, String messageParameter, String selectFile){

        driver.findElement(fName).sendKeys(firstName);
        driver.findElement(lName).sendKeys(lastName);
        driver.findElement(email).sendKeys(emailAddress);
        driver.findElement(subject).click();
        driver.findElement(option).click();
        driver.findElement(message).sendKeys(messageParameter);
        driver.findElement(chooseFile).sendKeys(selectFile);
        driver.findElement(send).click();

    }

    public void verifyMessage(){

        String messageText = driver.findElement(By.cssSelector("div.alert")).getText();

        Assert.assertEquals(messageText, "Thanks for your message! We will contact you shortly.");
    }

}
