package com.skillbrain.mentor.bstackTests;

import com.skillbrain.mentor.pages.browserStackDemo.ProductPage;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class AddToCardTes extends BasePage {

    @Test
    public void addAndRemove() throws InterruptedException {

        driver.get("https://bstackdemo.com/");
        ProductPage productPage = new ProductPage(driver);

        productPage.addRemoveTocart();

        productPage.emptyCard();

    }


}
