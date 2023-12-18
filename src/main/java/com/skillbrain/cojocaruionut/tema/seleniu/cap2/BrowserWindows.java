package com.skillbrain.cojocaruionut.tema.seleniu.cap2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class BrowserWindows {
    public static void main(String[] args) {
        windows();
    }

    public static void windows() {
        WebDriver driver = new ChromeDriver();
        try {
            Actions actions = new Actions(driver);
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");
            String parentWindow = driver.getWindowHandle();
            Set<String>windowHandles = driver.getWindowHandles();



        }
        catch (Exception e) {

        }

    }
}
