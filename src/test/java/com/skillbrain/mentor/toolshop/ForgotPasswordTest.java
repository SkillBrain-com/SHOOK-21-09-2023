package com.skillbrain.mentor.toolshop;

import com.skillbrain.mentor.pages.toolshop.ForgotPassword;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BasePage {
    @Test
    public void forgotPasswordTest(){
        driver.get("https://practicesoftwaretesting.com/#/auth/forgot-password");
        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.forgotPassword();
        forgotPassword.confirmationPasswordUpdated();
    }

}
