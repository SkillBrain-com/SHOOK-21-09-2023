package seleniumCap5Tema1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LocatorsFindByPlayground {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(" https://testpages.herokuapp.com/styled/index.html. ");
        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html#pName4");
       WebElement jumpPara3 = driver.findElement(By.id("a29"));
        action.click(jumpPara3).perform();

        WebElement eParagraph = driver.findElement(By.xpath("//div[@class=\"specialDiv\"]/p[@name=\"pName5\"]"));
        String eTextParagraph = eParagraph.getText();
        System.out.println(eTextParagraph);

        WebElement nestedText = driver.findElement(By.cssSelector("#p41"));
        String displayNestedText = nestedText.getText();
        System.out.println(displayNestedText);

        WebElement jumpPara8 = driver.findElement(By.linkText("jump to para 8"));
        String textJumpPara8 = jumpPara8.getText();
        System.out.println(textJumpPara8);

        WebElement jumpPara24 = driver.findElement(By.name("liName25"));
        String textJumpPara24 = jumpPara24.getText();
        System.out.println(textJumpPara24);
        driver.quit();
    }
}
