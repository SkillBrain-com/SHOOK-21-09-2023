package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactSection {

    By firstName = By.cssSelector("#first_name");
    By lastName = By.cssSelector("#last_name");
    By emailContact = By.cssSelector("#email");
    By subjectContact = By.xpath("//select[@data-test= 'subject']");
    By selectFromSubjectField = By.xpath("//select/option[@value = 'status-of-order']");
    By messageContact = By.cssSelector("#message");
    By attachPhoto = By.xpath("//div/input[@type='file']");
    By submit = By.cssSelector("input.btnSubmit");
    By confirmationText = By.cssSelector("div.alert.alert-success.mt-3");

    WebDriver driver;
    WebDriverWait wait;

    public ContactSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void contactSection(String fName,String lName, String email,String message){

        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(emailContact).sendKeys(email);

        driver.findElement(subjectContact).click();
        driver.findElement(selectFromSubjectField).click();
        driver.findElement(messageContact).sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(attachPhoto));

        driver.findElement(attachPhoto).sendKeys("D:\\tema-cap8\\SHOOK-21-09-2023\\src\\main\\java\\com\\skillbrain\\mentor\\utils\\fisiertxt.txt");
        driver.findElement(submit).click();


    }

    public void confirmContactSection(){
        String textConfirm = driver.findElement(confirmationText).getText();
        Assert.assertEquals(textConfirm,"Thanks for your message! We will contact you shortly.");
    }

}
