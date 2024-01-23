package com.skillbrain.mentor.bstackTests;

import com.skillbrain.mentor.pages.browserStackDemo.LoginPage;
import com.skillbrain.mentor.pages.browserStackDemo.PageElements;
import com.skillbrain.mentor.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.skillbrain.mentor.utils.BasePage.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageElementsTest extends BasePage {



    @Test
    public void testElementsOnPage(){

        driver.get("https://bstackdemo.com/");
        PageElements pageElements = new PageElements(driver);
        pageElements.findElementsOnPage();


    }

    @Test
    public void testLastElement(){

        driver.get("https://bstackdemo.com/");
        PageElements pageElements = new PageElements(driver);
        pageElements.lastElementFromPage();
    }

    @Test
    public  void textLastElement(){

        driver.get("https://bstackdemo.com/");

        PageElements pageElements = new PageElements(driver);

        pageElements.lastElementText();
    }

    @Test
    public void testFavoriteItems() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://bstackdemo.com/signin");
        loginPage.login("demouser", "testingisfun99");
        loginPage.verifySuccessfulLogin();

        PageElements pageElements = new PageElements(driver);

        pageElements.addToFavorite();
    }


}
