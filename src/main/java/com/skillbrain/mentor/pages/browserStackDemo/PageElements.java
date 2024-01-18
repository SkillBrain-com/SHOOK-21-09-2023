package com.skillbrain.mentor.pages.browserStackDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PageElements {


    private By elementsOnPage = By.cssSelector("div.shelf-item");

    private By lastElememt = By.xpath("(//div[@class='shelf-item__buy-btn'])[25]");

    private By textLastElement = By.xpath("(//p[@class = 'shelf-item__title'])[25]");

    private By favoriteButtonHeart = By.xpath("(//span[@class='MuiIconButton-label'])[1]");

    private By textFirstItem = By.xpath("(//p[@class = 'shelf-item__title'])[1]");


    private By favoriteButtonFromTop = By.cssSelector("#favourites");

    public WebDriver driver;
    public WebDriverWait wait;

    public PageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void findElementsOnPage(){

        List<WebElement> elementList = driver.findElements(elementsOnPage);

        Assert.assertEquals(elementList.size(),25);

    }

    public void lastElementFromPage(){

//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lastElememt)));
        driver.findElement(lastElememt).click();

    }

    public void lastElementText(){

        String textLastObject = driver.findElement(textLastElement).getText();

        Assert.assertEquals(textLastObject,"One Plus 6T");


    }

    public void addToFavorite() {


        String textElementFromFirstPage = driver.findElement(textFirstItem).getText();
        System.out.println("First text" + " " + textElementFromFirstPage);

        driver.findElement(favoriteButtonHeart).click();
        driver.findElement(favoriteButtonFromTop).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("favourites"));

        WebElement elementTex = (driver.findElement(By.cssSelector("div.shelf-item p.shelf-item__title")));
        System.out.println("Secound text" + " " + elementTex.getText());



        Assert.assertEquals(elementTex.getText(), textElementFromFirstPage);


    }


}
