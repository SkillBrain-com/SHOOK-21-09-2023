package com.skillbrain.mentor.bstackTests;

import com.skillbrain.mentor.pages.browserStackDemo.LoginPage;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class LockedAccountLogin extends BasePage {
    @Test
    public void lockedAccountLogin(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://bstackdemo.com/signin");
        loginPage.login("locked_user", "testingisfun99");
        loginPage.verifyLockedAccountLogin();
    }
}
