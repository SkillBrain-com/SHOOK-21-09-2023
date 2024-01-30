package seleniumCap5Tema1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQATextBox {
    public static void main(String[] args) {
       // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("Ionel Ion");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector(".form-control")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("submit")).click();

        driver.quit();

    }
}
