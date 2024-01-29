package seleniumCap5Tema1;

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
        WebElement staticAttribute = driver.findElement(By.id("domattributes"));
        String idValue = staticAttribute.getAttribute("id");
        System.out.println("ID attribute value is " +idValue);

WebElement dynamicAttributesAdd = driver.findElement(By.id("jsattributes"));
String nextId = dynamicAttributesAdd.getAttribute("nextid");
        System.out.println("Initial nextid value is " +nextId);
        System.out.println("----------------");
        WebElement clickAdd = driver.findElement(By.cssSelector(".styled-click-button"));
        action.click(clickAdd).perform();

        WebElement newNextId = driver.findElement(By.id("jsattributes"));
        String customNew = newNextId.getAttribute("custom-1");
        System.out.println("New value is " +customNew);

        WebElement clickAdd2 = driver.findElement(By.cssSelector(".styled-click-button"));
        action.click(clickAdd2).perform();
        System.out.println("-------------------");
        WebElement newNextId2 = driver.findElement(By.id("jsattributes"));
        String customNew2 = newNextId2.getAttribute("custom-2");
        System.out.println("New value is " +customNew2);
        System.out.println("-------------------");
    WebElement dynamicAttributes = driver.findElement(By.id("jsautoattributes"));
    String name = dynamicAttributes.getAttribute("name");
    String dataCount = dynamicAttributes.getAttribute("data-count");
    String dataDynamic = dynamicAttributes.getAttribute("data-dynamic");
    System.out.println("The name is: " + name);
    System.out.println("Data count value is: " + dataCount);
    System.out.println("Data dynamic value is " + dataDynamic);
//nu am reusit sa fac sa apara toate valorile atributelor dinamice
        driver.quit();
    }
}
