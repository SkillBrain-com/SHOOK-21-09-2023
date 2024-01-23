package com.skillbrain.mentor.bstackTests;

import com.skillbrain.mentor.pages.browserStackDemo.ProductPage;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class AddToCardTest extends BasePage {

    @Test
    public void addAndRemove() {

        driver.get("https://bstackdemo.com/");
        ProductPage productPage = new ProductPage(driver);

        productPage.addRemoveTocart();

        productPage.emptyCard();

    }


}