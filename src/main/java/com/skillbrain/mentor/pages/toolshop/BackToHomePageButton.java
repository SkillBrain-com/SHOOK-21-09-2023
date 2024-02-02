package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BackToHomePageButton {
    By backToHomePage = By.cssSelector("a.nav-link.active");
    WebDriver driver;
    WebDriverWait wait;

    public BackToHomePageButton(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void BackToHomePageButton(){
        driver.findElement(backToHomePage).click();
    }

}
