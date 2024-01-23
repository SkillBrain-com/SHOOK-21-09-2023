package com.skillbrain.mentor.demoBlaze;

import com.skillbrain.mentor.pages.demoBlaze.MainPage;
import com.skillbrain.mentor.pages.demoBlaze.SignUpPage;
import com.skillbrain.mentor.utils.BasePage;
import com.skillbrain.mentor.utils.DataGeneration;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BasePage {

    @Test(groups = {"signUp"})
    public void signUp() throws InterruptedException {

        driver.get("https://www.demoblaze.com/index.html");

        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        DataGeneration dataGeneration = DataGeneration.getInstance();

        mainPage.signUpButton();

        signUpPage.signUp(dataGeneration.loginUserName,dataGeneration.passwordLogin);
        signUpPage.confirmationSignUp();

    }





}
