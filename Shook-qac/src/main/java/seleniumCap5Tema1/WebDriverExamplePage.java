package seleniumCap5Tema1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WebDriverExamplePage {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        Faker faker = new Faker();
        driver.manage().window().maximize();
        driver.get(" https://testpages.herokuapp.com/styled/index.html. ");
        driver.get("https://testpages.eviltester.com/styled/webdriver-example-page");

driver.findElement(By.id("numentry")).sendKeys("274");
        WebElement clickProcess = driver.findElement(By.cssSelector("#submit-to-server"));
        action.click(clickProcess).perform();
WebElement clickShowLink = driver.findElement(By.linkText("Show From Link"));
action.click(clickShowLink).perform();
WebElement showAlert = driver.findElement(By.cssSelector("button[data-locator=\"process-in-alert\"]"));
action.click(showAlert).perform();

    }
}
