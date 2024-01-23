package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FailedRegistrationBySameEmail {

    By registerAccount = By.cssSelector("a[data-test=\"register-link\"]");
    By fName = By.id("first_name");
    By lName = By.id("last_name");
    By dateOfBirth = By.cssSelector("#dob");
    By address = By.cssSelector("#address");
    By postCode = By.cssSelector("#postcode");
    By city = By.cssSelector("input[id=\"city\"]");
    By state = By.cssSelector("#state");
    By country = By.cssSelector("#country");
    By countrySelected = By.xpath("(//select[@id = 'country'] /option)[4]");
    By phone = By.cssSelector("#phone");
    By email = By.cssSelector("#email");
    By password = By.cssSelector("#password");
    By register = By.cssSelector("button.btnSubmit");

    By messageFaileBySameEmail = By.cssSelector("div.help-block");

    WebDriver driver;
    WebDriverWait wait;

    public FailedRegistrationBySameEmail(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void failedRegistrationBySameEmail(String firstName, String lastName, String addressParam, String postCodeParam, String cityParam,
                                      String stateParam, String phoneParam, String emailParam,String passwordParam  ){


        driver.findElement(registerAccount).click();

        driver.findElement(fName).sendKeys(firstName);
        driver.findElement(lName).sendKeys(lastName);

        wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
        driver.findElement(dateOfBirth).click();
        driver.findElement(dateOfBirth).sendKeys("12031986");



        driver.findElement(address).sendKeys(addressParam);
        driver.findElement(postCode).sendKeys(postCodeParam);
        driver.findElement(city).sendKeys(cityParam);
        driver.findElement(state).sendKeys(stateParam);

        driver.findElement(country).click();
        driver.findElement(countrySelected).click();


        driver.findElement(phone).sendKeys(phoneParam);
        driver.findElement(email).sendKeys(emailParam);
        driver.findElement(password).sendKeys(passwordParam);


        driver.findElement(register).click();

    }

    public void failedMessageBySameEmail(){
        String messageFailed = driver.findElement(messageFaileBySameEmail).getText();
        Assert.assertEquals(messageFailed,"A customer with this email address already exists.");
    }

}
