package com.skillbrain.mentor.selenium_cap1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("Andrei Soare");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("andrei@mailinator.com");
        driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]")).sendKeys("Address");
        driver.findElement(By.xpath("//textarea[@id=\"permanentAddress\"]")).sendKeys("permanent address");
        driver.findElement(By.cssSelector("button#submit")).getText();

        //driver.quit();
    }
}