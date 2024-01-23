package com.skillbrain.mentor.pages.demoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private By signUp = By.id("signin2");

    private By contactButton =
            By.xpath("(//div[@id=\"navbarExample\"]//following-sibling::ul[@class=\"navbar-nav ml-auto\"]//following-sibling::li[@class=\"nav-item\"]//following-sibling::a)[1]");

    WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void openContactForm(){

        driver.findElement(contactButton).click();
    }

    public void signUpButton(){
        driver.findElement(signUp).click();
    }
}
