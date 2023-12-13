package com.skillbrain.mentor.selenium_cap2;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNoSuchElementException {
//Aici nu exista in pagina un element cu idul "unId" asa ca selenium de da exceptia -> NoSuchElementException
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/text-box");
//
//        driver.findElement(By.id("unId")).click();
//
//    }

//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        driver.get("https://demoqa.com/text-box");
//
//        try{
//            driver.findElement(By.id("unId")).click();
//        }catch (NoSuchElementException e){
//            System.out.println("Nu exista elementul cautat in pagina");
//        }finally {
//            driver.quit();
//        }
//    }

        public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("unId")).click();

        driver.quit();
    }
}
