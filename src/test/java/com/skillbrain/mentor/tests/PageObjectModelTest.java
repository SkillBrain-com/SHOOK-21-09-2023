package com.skillbrain.mentor.tests;

import com.skillbrain.mentor.pageObjectModel.FormsPage;
import com.skillbrain.mentor.utils.TestBase;
import org.testng.annotations.Test;

public class PageObjectModelTest extends TestBase {

    @Test
    public void fillFormTestAllFields(){
        FormsPage formsPage = new FormsPage();
        formsPage.fillForm("ionel","ionel@mailinator.com","adasdas", "adasdasd");
    }
    @Test
    public void fillOnlyRequiredFields(){
        FormsPage formsPage = new FormsPage();
        formsPage.fillName("georgel", "georgel@mailinator.com", "asdasdas");
    }
}
