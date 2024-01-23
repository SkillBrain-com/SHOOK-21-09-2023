package com.skillbrain.mentor.toolshop;

import com.skillbrain.mentor.pages.toolshop.AddToFavoriteWithoutLogin;
import com.skillbrain.mentor.utils.BasePage;
import org.testng.annotations.Test;

public class AddToFavoriteWithoutLoginTest extends BasePage {

    @Test
    public void addToFavoriteFailed(){
        driver.get("https://practicesoftwaretesting.com/#/");
        AddToFavoriteWithoutLogin addToFavoriteWithoutLogin = new AddToFavoriteWithoutLogin(driver);
        addToFavoriteWithoutLogin.addToFavorite();
        addToFavoriteWithoutLogin.failedToAddConfirmation();
    }
}
