package com.skillbrain.mentor.toolshop;

import com.github.javafaker.Faker;
import com.skillbrain.mentor.pages.toolshop.RegisterAccount;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class RegisterAccountTest extends BasePage {




   @Test
    public void registerAccountPositiveTest(){

       driver.get("https://practicesoftwaretesting.com/#/auth/login");
       RegisterAccount registerAccount = new RegisterAccount(driver);
       Faker faker = new Faker();
       String email = faker.internet().emailAddress();
       String fName = faker.name().firstName();
       String lName = faker.name().lastName();
       String paswword = faker.internet().password(6,10);
       registerAccount.registerNewAccount(fName,lName,faker.address().fullAddress(),
               faker.address().zipCode(),faker.address().city(),faker.address().state(),faker.phoneNumber().subscriberNumber(10).toString(),email,paswword);
       registerAccount.confirmRegistration(fName,lName,email,paswword);
   }

}
