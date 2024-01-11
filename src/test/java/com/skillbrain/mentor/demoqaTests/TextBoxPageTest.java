package com.skillbrain.mentor.demoqaTests;

import com.skillbrain.mentor.pages.demoqa.TextBoxPage;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class TextBoxPageTest extends BasePage {

    @Test
    public void textBoxTest(){
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        driver.get("https://demoqa.com/text-box");
        textBoxPage.fillTextBoxInfo("Ionel gheorghe", "ionel@mail.com",
                "Current address", "Permanent Address");
        textBoxPage.verifyFunctionality("Name:Ionel gheorghe", "Email:ionel@mail.com",
                "Current Address :Current address", "Permananet Address :Permanent Address");
    }
}
