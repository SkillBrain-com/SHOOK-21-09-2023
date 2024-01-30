package seleniumCap5Tema1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        driver.findElement(By.cssSelector(".rct-icon-uncheck")).click();


    }
}
