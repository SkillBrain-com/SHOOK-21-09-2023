package com.skillbrain.mentor.bstackTests;

import com.skillbrain.mentor.pages.browserStackDemo.LoginPage;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class SuccessfulLogin extends BasePage {

    @Test
    public void successfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://bstackdemo.com/signin");
        loginPage.login("demouser", "testingisfun99");
        loginPage.verifySuccessfulLogin();
    }


}
