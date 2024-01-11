package com.skillbrain.mentor.pages.demoqa;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TextBoxPage {

    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");

    private By verificationName = By.id("name");
    private By verificationEmail = By.id("email");
    private By verificationCurrentAddress = By.cssSelector("p#currentAddress");
    private By verificationPermanentAddress = By.cssSelector("p#permanentAddress");

    WebDriver driver;
    WebDriverWait wait;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void fillTextBoxInfo(String fullNameParam, String emailParam,
                                String currentAddressParam, String permanentAddress){
        driver.findElement(fullName).sendKeys(fullNameParam);
        driver.findElement(email).sendKeys(emailParam);
        driver.findElement(currentAddress).sendKeys(currentAddressParam);
        //Cuvantul cheie this este utilizat pentru a face diferenta intre elementul web definit
        //si parametrul metodei care acelasi nume
        driver.findElement(this.permanentAddress).sendKeys(permanentAddress);

        Actions actions = new Actions(driver);
        //Avem nevoie sa scrolam catre butonul submit si avem mai multe variante de a face asta
        //Putem sa ii spunem lui selenium sa simuleze apasarea tastei PAGE_DOWN(linia 37)
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement element = driver.findElement(submitButton);
        //Sau varianta mai eleganta prin care ne folosim de JavaScript sa scrolam pana la elementul nostru
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);

        driver.findElement(submitButton).click();
    }

    public void verifyFunctionality(String expectedName, String expectedEmail,
                                    String expectedCurrentAddress, String expectedPermanentAddress){
        String name = driver.findElement(verificationName).getText();
        Assert.assertEquals(name, expectedName);

        String email = driver.findElement(verificationEmail).getText();
        Assert.assertEquals(email, expectedEmail);

        String currentAddress = driver.findElement(verificationCurrentAddress).getText();
        Assert.assertEquals(currentAddress, expectedCurrentAddress);

        String permanentAddress = driver.findElement(verificationPermanentAddress).getText();
        Assert.assertEquals(permanentAddress, expectedPermanentAddress);
    }
}
