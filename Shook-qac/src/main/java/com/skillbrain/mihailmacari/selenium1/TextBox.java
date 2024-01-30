package com.skillbrain.mihailmacari.selenium1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {
        WebDriver Driver = new ChromeDriver();
        Faker faker = new Faker();
        Driver.manage().window().maximize();
        Driver.get("https://demoqa.com/text-box");

        Driver.findElement (By.id("userName")).sendKeys("Ionel Ion");
        Driver.findElement(By.cssSelector("#userEmail")).sendKeys(faker.internet().emailAddress());
        Driver.findElement(By.cssSelector("textarea[placeholder=\"Current Address\"]")).sendKeys(faker.address().fullAddress());
        Driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(faker.address().fullAddress());
        Driver.findElement(By.cssSelector("#submit")).click();
        Driver.quit();


    }
}
