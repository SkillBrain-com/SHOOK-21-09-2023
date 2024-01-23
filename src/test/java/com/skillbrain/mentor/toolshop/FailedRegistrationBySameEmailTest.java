package com.skillbrain.mentor.toolshop;

import com.github.javafaker.Faker;
import com.skillbrain.mentor.pages.toolshop.FailedRegistrationBySameEmail;
import com.skillbrain.mentor.pages.toolshop.FailedRegistrationWithDOB;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class FailedRegistrationBySameEmailTest extends BasePage {


    @Test
    public void failedRegistrationBySameEmail(){

        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        FailedRegistrationBySameEmail failedRegistrationBySameEmail = new FailedRegistrationBySameEmail(driver);
        Faker faker = new Faker();
        String email = "alex@yahoo.com";
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String paswword = faker.internet().password(6,10);
        failedRegistrationBySameEmail.failedRegistrationBySameEmail(fName,lName,faker.address().fullAddress(),
                faker.address().zipCode(),faker.address().city(),faker.address().state(),faker.phoneNumber().subscriberNumber(10).toString(),email,paswword);
        failedRegistrationBySameEmail.failedMessageBySameEmail();

    }
}
