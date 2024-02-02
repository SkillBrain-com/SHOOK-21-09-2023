package com.skillbrain.mentor.toolshop;

import com.skillbrain.mentor.pages.toolshop.ContactSection;
import com.skillbrain.mentor.utils.BasePage;
import com.skillbrain.mentor.utils.DataGeneration;
import org.testng.annotations.Test;

public class ContactSectionTest extends BasePage {

    @Test
    public void contactSection(){

        driver.get("https://practicesoftwaretesting.com/#/contact");
        ContactSection contactSection = new ContactSection(driver);
        DataGeneration dataGeneration = DataGeneration.getInstance();
        contactSection.contactSection(dataGeneration.fName, dataGeneration.lName, dataGeneration.email, dataGeneration.message);
        contactSection.confirmContactSection();

    }
}
