package com.skillbrain.alexmorja.temacap7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Login extends BeforeAfterLogin {



    @Test(description = "Verify login user",groups = {"with-login"})
    public void login() {

        assertTrue(driver.getCurrentUrl().contains("#appointment"), "User after login is not on the right URL");

    }

    @Test(description = "Verify login scenario with different users ",dataProvider = "loginTest",groups = {"without-login"})
    public void loginInvalidUser(String userName, String password) {

        loginSteps(userName,password);

        assertFalse(driver.getCurrentUrl().contains("#appointment"), "User should not be able to login with invalid an user-name ");


    }

    @DataProvider
    public Object[][] loginTest(){
        return new Object[][]{
                {"Alex Jr. Jones","pas"},
        };
    }

}
