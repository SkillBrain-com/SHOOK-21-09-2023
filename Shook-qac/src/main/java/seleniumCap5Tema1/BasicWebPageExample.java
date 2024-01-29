package seleniumTema1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.sql.SQLOutput;

public class BasicWebPageExample {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(" https://testpages.herokuapp.com/styled/index.html. ");
        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");
        WebElement titleElement = driver.findElement(By.tagName("h1"));
        String titleText = titleElement.getText();
        System.out.println("The text is: " + titleText);
        WebElement paragraph = driver.findElement(By.tagName("p"));
        String paragraphText = paragraph.getText();
        System.out.println("The paragraph text is: " +paragraphText);
        WebElement paragraphOfText = driver.findElement(By.id("para1"));
        String paragraph1 = paragraphOfText.getText();
        System.out.println("Paragraph text is: " +paragraph1);
        WebElement anotherParagraph = driver.findElement(By.id("para2"));
        String anotherText = anotherParagraph.getText();
        System.out.println("Another paragraph text is: " +anotherText);
        WebElement clickAbout = driver.findElement(By.cssSelector("a[href='page?app=basicwebpageexample&t=About']"));
        action.doubleClick(clickAbout).perform();
        driver.quit();
    }
}
