package com.skillbrain.alexmorja.temacap7;
import driver.ChromeDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class BeforeAfterLogin extends ChromeDriverConfig {

    protected ChromeDriver driver = null ;

    @BeforeMethod(onlyForGroups = {"with-login"})
    public void beforeMethode(){

        driver = ChromeDriverConfig.getChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.id("btn-make-appointment")).click();


        assertTrue(driver.getCurrentUrl().contains("profile.php#login"), "User is not on the good URL");

        WebElement userName = driver.findElement(By.id("txt-username"));
        userName.clear();
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();


    }

    @BeforeMethod(onlyForGroups = {"without-login"})
    public void beforeGroupWithoutLogin() throws IOException {
        driver = ChromeDriverConfig.getChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        ////Aici am facut un negativ test simplu fara DataProvider

//        driver.findElement(By.cssSelector(".fa.fa-bars")).click();
//        driver.findElement(By.cssSelector("a[href=\"profile.php#login\"]")).click();
//        WebElement userName = driver.findElement(By.id("txt-username"));
//        userName.clear();
//        userName.sendKeys("Alex Jones");
//
//        WebElement password = driver.findElement(By.id("txt-password"));
//        password.sendKeys("ThisIsNotAPassword");
//
//        WebElement login = driver.findElement(By.id("btn-login"));
//        login.click();

    }

    //Aici am facut o metoda pt un test negativ, pt DataProvider
    public void loginSteps(String userName, String password){

        driver.findElement(By.cssSelector(".fa.fa-bars")).click();
        driver.findElement(By.cssSelector("a[href=\"profile.php#login\"]")).click();

        driver.findElement(By.id("txt-username")).sendKeys(userName);


        driver.findElement(By.id("txt-password")).sendKeys(password);


        driver.findElement(By.id("btn-login")).click();

    }

    @BeforeMethod(onlyForGroups = {"appointmentButton"})
    public void appointmentButton(){
        driver = ChromeDriverConfig.getChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }




    @AfterMethod(alwaysRun = true)
    public void afterMethod(){

        if (driver!=null){
            driver.quit();

        }
    }
}
