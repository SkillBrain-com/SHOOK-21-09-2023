package com.skillbrain.mentor.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("ionel");

        driver.quit();
    }
}
