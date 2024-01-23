package com.skillbrain.mentor.toolshop;

import com.skillbrain.mentor.pages.toolshop.AddToCart;
import com.skillbrain.mentor.pages.toolshop.RemoveFromCart;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BasePage {

    @Test
    public void removeFromCart(){
        driver.get("https://practicesoftwaretesting.com/#/");
        AddToCart addToCart = new AddToCart(driver);
        RemoveFromCart removeFromCart = new RemoveFromCart(driver);
        addToCart.addCart();
        removeFromCart.removeFromCart();
        removeFromCart.removeConfirm();

    }

    @Test
    public void removeFromQuantity(){
        driver.get("https://practicesoftwaretesting.com/#/");
        RemoveFromCart removeFromCart = new RemoveFromCart(driver);
        removeFromCart.deleteFromQuantityItems();
        removeFromCart.confirmationDeleteItem();
    }
}
