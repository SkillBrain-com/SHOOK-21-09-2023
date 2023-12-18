package com.skillbrain.cojocaruionut.tema.seleniu.cap2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class HTMLForms {
    public static void main(String[] args) throws InterruptedException {
        metodamea();

    }
    public static void metodamea () {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        driver.findElement(By.name("username")).sendKeys("Jax");
        driver.findElement(By.name("password")).sendKeys("TryAgain");
        driver.findElement(By.name("comments")).sendKeys("Am introdus un comentariu");

        WebElement fileUpload = driver.findElement(By.name("filename"));
        fileUpload.sendKeys("C:\\Users\\Dante\\Desktop\\ScreenShot.PNG");

        Select item = new Select(driver.findElement(By.name("multipleselect[]")));
        item.selectByIndex(1);

        List<WebElement> checkBox = driver.findElements(By.name("checkboxes[]"));
        checkBox.get(0).click();
        List<WebElement> radiobutton = driver.findElements(By.name("radioval"));
        radiobutton.get(0).click();

        Select items = new Select(driver.findElement(By.name("dropdown")));
        items.selectByVisibleText("Drop Down Item 2");

        WebElement submit = driver.findElement(By.cssSelector("input[value=\"submit\"]"));
        submit.click();

    }
}
