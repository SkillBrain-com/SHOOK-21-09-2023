package seleniumTema1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ElementAttributesExamples {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/attributes-test.html");
        WebElement button = driver.findElement(By.cssSelector(".styled-click-button"));
        action.doubleClick(button).perform();
    }
}
