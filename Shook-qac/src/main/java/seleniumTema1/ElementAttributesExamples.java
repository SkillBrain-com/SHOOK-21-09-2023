package seleniumTema1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementAttributesExamples {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/attributes-test.html");
    }
}
