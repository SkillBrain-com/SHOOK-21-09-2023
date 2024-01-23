package com.skillbrain.mentor.toolshop;

import com.skillbrain.mentor.pages.toolshop.ForgotPasswordNegative;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class ForgotPasswordNegativeTest extends BasePage {

    @Test
    public void forgotPasswordNegativeTest(){
        driver.get("https://practicesoftwaretesting.com/#/auth/forgot-password");
        ForgotPasswordNegative forgotPasswordNegative =new ForgotPasswordNegative(driver);
        forgotPasswordNegative.forgotPasswordNegative();
        forgotPasswordNegative.messageForgotPasswordNegative();
    }
}
