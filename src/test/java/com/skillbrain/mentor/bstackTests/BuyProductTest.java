package com.skillbrain.mentor.bstackTests;

import com.skillbrain.mentor.pages.browserStackDemo.CheckoutPage;
import com.skillbrain.mentor.pages.browserStackDemo.LoginPage;
import com.skillbrain.mentor.pages.browserStackDemo.OrderConfirmationPage;
import com.skillbrain.mentor.pages.browserStackDemo.ProductPage;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class BuyProductTest extends BasePage {

    //Adaugam un produs in cos
    //Click pe butonul checkout
    //Apelam functiile de login -> un successful login
    //Completam datele de livrare -> generam date cu faker
    //Verificam trimiterea comenzii

    @Test
    public void buyProduct() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://bstackdemo.com");

        productPage.addToCart();
       // loginPage.login("demouser", "testingisfun99");
        checkoutPage.fillShippingAddress();
        orderConfirmationPage.verifyOrderPlacement();
    }

}
