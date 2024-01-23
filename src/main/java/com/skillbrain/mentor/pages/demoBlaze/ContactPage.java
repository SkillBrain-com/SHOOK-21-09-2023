package com.skillbrain.mentor.pages.demoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {

    private By cotactEmail = By.xpath("//label[contains(text(),\"Contact Email:\")]/following-sibling::input[@type=\"text\"]");
    private By contactName = By.xpath("//label[contains(text(),\"Contact Name:\")]/following-sibling::input[@type=\"text\"]");
    private By messageTextarea = By.cssSelector("label[for=\"message-text\"] +textarea.form-control");

    WebDriver driver;
    WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void fillContactForm(String email, String name, String message){
        driver.findElement(cotactEmail).sendKeys(email);
        driver.findElement(contactName).sendKeys(name);
        driver.findElement(messageTextarea).sendKeys(message);
    }
}
