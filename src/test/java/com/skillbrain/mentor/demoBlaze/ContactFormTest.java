package com.skillbrain.mentor.demoBlaze;

import com.skillbrain.mentor.pages.demoBlaze.ContactPage;
import com.skillbrain.mentor.pages.demoBlaze.MainPage;
import com.skillbrain.mentor.utils.BasePage;
import com.skillbrain.mentor.utils.DataGeneration;
import org.testng.annotations.Test;

public class ContactFormTest extends BasePage {

    @Test
    public void testContactForm(){
        MainPage mainPage = new MainPage(driver);
        ContactPage contactPage = new ContactPage(driver);
        DataGeneration dataGeneration = DataGeneration.getInstance();

        driver.get("https://www.demoblaze.com/index.html");

        mainPage.openContactForm();
        contactPage.fillContactForm(dataGeneration.contactEmail, dataGeneration.contactName, dataGeneration.message);
    }

}
