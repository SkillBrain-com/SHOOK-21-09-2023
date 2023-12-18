package com.skillbrain.cojocaruionut.tema.seleniu.cap2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertsBox {
    public static void main(String[] args) {
       alerts();

    }

    public static void alerts() {
        try {
            WebDriver driver = new ChromeDriver();
            Actions actions = new Actions(driver);
            driver.manage().window().maximize();

            driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

            WebElement showAlertBox = driver.findElement(By.id("alertexamples"));
            showAlertBox.click();

            Alert alert = driver.switchTo().alert();
            alert.accept();


            WebElement showConfirmBox = driver.findElement(By.id("confirmexample"));
            showConfirmBox.click();

            Alert alert2 = driver.switchTo().alert();
            alert2.accept();

            WebElement showPromptBox = driver.findElement(By.id("promptexample"));
            showPromptBox.click();

            Alert alert3 = driver.switchTo().alert();
            alert.sendKeys("S-a introdus un text");
            alert3.accept();

            WebElement show = driver.findElement(By.id("all"));
            show.click();
        }

        catch (Exception e) {


        }

        finally {


        }


    }
}
