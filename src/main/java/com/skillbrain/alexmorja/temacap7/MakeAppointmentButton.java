package com.skillbrain.alexmorja.temacap7;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MakeAppointmentButton extends BeforeAfterLogin {

    @Test(description = "Make appointment button should move user to login page",groups = {"appointmentButton"})
    public void makeAppointmentButton(){

        WebElement bookAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        bookAppointmentButton.click();

        assertTrue(driver.getCurrentUrl().contains("profile.php#login"));
    }
}
