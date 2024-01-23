package com.skillbrain.mentor.toolshop;

import com.github.javafaker.Faker;
import com.skillbrain.mentor.pages.toolshop.FailedRegistrationWithDOB;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class FailedRegistrationWithDOBTest extends BasePage {

    @Test
    public void failedRegistrationDOB(){

        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        FailedRegistrationWithDOB failedRegistration = new FailedRegistrationWithDOB(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String paswword = faker.internet().password(6,10);
        failedRegistration.failedRegistrationDOB(fName,lName,faker.address().fullAddress(),
                faker.address().zipCode(),faker.address().city(),faker.address().state(),faker.phoneNumber().subscriberNumber(10).toString(),email,paswword);
        failedRegistration.confirmMessageFailedRegistrationDOB();

    }

    }

