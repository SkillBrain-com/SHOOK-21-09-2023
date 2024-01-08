package driver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserConfig {

    public WebDriver driver;
    public WebDriverWait wait;


    @BeforeMethod(onlyForGroups = {"mobile.test"})
    public void beforeMethode(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        Map<String,String> map = new HashMap<>();
        map.put("deviceName","iPhone SE");
        options.setExperimentalOption("mobileEmulation",map);


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @BeforeMethod(onlyForGroups = {"desktop.test"})
    public void beforeMethodes(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @AfterMethod(alwaysRun = true)
    public void afterMethode(){

        driver.quit();

    }










}
