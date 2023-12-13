package com.skillbrain.mentor.selenium_cap2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActions {
//Exemplu clasa actions sa putem da dublu click, click dreapta si move to element;
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/buttons");


        //Exemplu double click
        WebElement dubluClick = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(dubluClick).perform();


        //Exemplu click dreapta
        WebElement clickDreapta = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(clickDreapta).perform();


        //Exemplu move to element
        WebElement moveToElement = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));
        actions.moveToElement(moveToElement).build().perform();

    }
}
