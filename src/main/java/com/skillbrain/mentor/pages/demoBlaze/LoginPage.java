package com.skillbrain.mentor.pages.demoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    By login = By.id("login2");
    By userName = By.id("loginusername");
    By passwordLogin = By.id("loginpassword");

    By loginPage = By.xpath("//div[@class = 'modal-footer']//following-sibling::button[@onclick='logIn()']");

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void loginPage(String name,String password){

        driver.findElement(login).click();

        driver.findElement(userName).sendKeys(name);
        driver.findElement(passwordLogin).sendKeys(password);
        driver.findElement(loginPage).click();

    }
}
