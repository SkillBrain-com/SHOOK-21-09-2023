package com.skillbrain.mentor.toolshop;

import com.github.javafaker.Faker;
import com.skillbrain.mentor.pages.toolshop.AddToCart;
import com.skillbrain.mentor.pages.toolshop.BackToHomePageButton;
import com.skillbrain.mentor.pages.toolshop.Checkout;
import com.skillbrain.mentor.pages.toolshop.RegisterAccount;
import com.skillbrain.mentor.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BasePage {

    @Test
    public void checkoutTest(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        RegisterAccount registerAccount = new RegisterAccount(driver);
        AddToCart addToCart = new AddToCart(driver);
        Checkout checkout = new Checkout(driver);
        BackToHomePageButton backToHomePageButton = new BackToHomePageButton(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String paswword = faker.internet().password(6,10);
        registerAccount.registerNewAccount(fName,lName,faker.address().fullAddress(),
                faker.address().zipCode(),faker.address().city(),faker.address().state(),faker.phoneNumber().subscriberNumber(10).toString(),email,paswword);
        registerAccount.confirmRegistration(fName,lName,email,paswword);
        backToHomePageButton.BackToHomePageButton();
        addToCart.addCart();
        checkout.checkoutProceed(faker.funnyName().name(),faker.name().fullName(),faker.numerify("434343"));
//        checkout.conformUser(fName,lName);
        checkout.confirmAccount();


    }

}
