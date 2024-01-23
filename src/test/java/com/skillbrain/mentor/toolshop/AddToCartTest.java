package com.skillbrain.mentor.toolshop;

import com.skillbrain.mentor.pages.toolshop.AddToCart;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class AddToCartTest extends BasePage {

    @Test
    public void addToCart(){
        driver.get("https://practicesoftwaretesting.com/#/");

        AddToCart addToCart = new AddToCart(driver);
        addToCart.addCart();
        addToCart.itemConfirmation();

    }
}
