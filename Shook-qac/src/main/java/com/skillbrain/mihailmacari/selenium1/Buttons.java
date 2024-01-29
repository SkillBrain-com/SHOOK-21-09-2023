package com.skillbrain.mihailmacari.selenium1;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Buttons {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(doubleClick).perform();
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClick).perform();
        driver.findElement(By.xpath("(//button[contains(text(),\"Click Me\")])[3]")).click();
        driver.quit();
        }
    }
