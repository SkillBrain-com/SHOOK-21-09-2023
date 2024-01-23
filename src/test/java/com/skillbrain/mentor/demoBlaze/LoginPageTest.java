package com.skillbrain.mentor.demoBlaze;

import com.skillbrain.mentor.pages.demoBlaze.LoginPage;
import com.skillbrain.mentor.utils.BasePage;
import com.skillbrain.mentor.utils.DataGeneration;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePage {

    @Test(dependsOnGroups = {"signUp"})
    public void loginPageTest(){

        driver.get("https://www.demoblaze.com/index.html");

        LoginPage loginPage = new LoginPage(driver);
        DataGeneration dataGeneration = DataGeneration.getInstance();
        loginPage.loginPage(dataGeneration.loginUserName,dataGeneration.passwordLogin);


    }
}
