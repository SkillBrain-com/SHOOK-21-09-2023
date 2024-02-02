package com.skillbrain.mentor.pages.toolshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Checkout {

    By checkout = By.xpath("//div/button[@data-test='proceed-1']");
    By messageConfirmationCustomer = By.xpath("//div/div/p[text()]");
    By proceedToCheckout = By.cssSelector("div.float-end>button[data-test=\"proceed-2\"]");

    By checkoutProceed = By.xpath("//button[@data-test='proceed-3']");
    By paymentMethod = By.id("payment-method");
    By firstOption = By.xpath("//option[@value='1: Bank Transfer']");
    By bankName = By.cssSelector("div>input[data-test=\"bank_name\"]");
    By accountName = By.cssSelector("div>input[data-test=\"account_name\"]");
    By accountNumber = By.cssSelector("div>input[data-test=\"account_number\"]");
    By finish = By.cssSelector("button[data-test=\"finish\"]");
    By confirmAccountMessage = By.cssSelector("div.help-block");

    WebDriver driver;
    WebDriverWait wait;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void checkoutProceed(String bank,String accountNameParam,String accountNr){

        driver.findElement(checkout).click();
        driver.findElement(proceedToCheckout).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(checkoutProceed)));
        driver.findElement(checkoutProceed).click();
        driver.findElement(paymentMethod).click();
        driver.findElement(firstOption).click();
        driver.findElement(bankName).sendKeys(bank);
        driver.findElement(accountName).sendKeys(accountNameParam);
        driver.findElement(accountNumber).sendKeys(accountNr);
        driver.findElement(finish).click();


    }

//    public void conformUser(String firstName,String lastName){
//        wait.until(ExpectedConditions.textToBe(messageConfirmationCustomer,"Hello" + " " + firstName + " " + lastName+", you are already logged in. You can proceed to checkout."));
//
//        String userName = driver.findElement(messageConfirmationCustomer).getText();
//        Assert.assertEquals(userName,"Hello" + " " + firstName + " " + lastName+", you are already logged in. You can proceed to checkout.");
//
//    }
    public void confirmAccount(){
        String accountConfirm = driver.findElement(confirmAccountMessage).getText();
        Assert.assertEquals(accountConfirm,"Payment was successful");
    }
}
