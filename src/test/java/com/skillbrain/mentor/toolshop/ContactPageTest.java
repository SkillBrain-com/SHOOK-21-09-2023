package com.skillbrain.mentor.toolshop;

import com.github.javafaker.Faker;
import com.skillbrain.mentor.pages.toolshop.ContactPage;
import com.skillbrain.mentor.utils.BasePage;
import com.skillbrain.mentor.utils.DataGeneration;
import org.testng.annotations.Test;

public class ContactPageTest extends BasePage {


    @Test
    public void contactPageTest(){

        driver.get("https://practicesoftwaretesting.com/#/contact");

        ContactPage contactPage = new ContactPage(driver);
        Faker faker = new Faker();
        DataGeneration dataGeneration = DataGeneration.getInstance();

        System.out.println(dataGeneration.fName);
        System.out.println(dataGeneration.fName);

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().firstName());

        contactPage.contactPage(dataGeneration.fName, dataGeneration.lName,dataGeneration.email, dataGeneration.message,"D:\\tema-cap8\\SHOOK-21-09-2023\\src\\main\\java\\com\\skillbrain\\mentor\\utils\\fisiertxt.txt");
        contactPage.verifyMessage();




    }
}
