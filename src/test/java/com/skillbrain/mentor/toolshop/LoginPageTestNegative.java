package com.skillbrain.mentor.toolshop;

import com.github.javafaker.Faker;
import com.skillbrain.mentor.pages.toolshop.LoginPageInvalidUser;
import com.skillbrain.mentor.utils.BasePage;
import com.skillbrain.mentor.utils.DataGeneration;
import org.testng.annotations.Test;

public class LoginPageTestNegative extends BasePage {

    @Test
    public void loginPageTest(){

        driver.get("https://practicesoftwaretesting.com/#/auth/login");

        LoginPageInvalidUser loginPageByEmailAndPassword = new LoginPageInvalidUser(driver);
        Faker faker = new Faker();
        loginPageByEmailAndPassword.loginPage(DataGeneration.getInstance().email,faker.name().firstName());
        loginPageByEmailAndPassword.invalidUser();
    }

}
