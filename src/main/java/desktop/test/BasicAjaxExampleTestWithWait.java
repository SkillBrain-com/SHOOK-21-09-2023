package desktop.test;


import driver.BrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class BasicAjaxExampleTestWithWait extends BrowserConfig {

    @Test(description = "To see if we are on the right url",groups = {"desktop.test"})
    public void urlPage(){
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        assertTrue(driver.getCurrentUrl().contains("basic-ajax-test.html"));

    }

    @Test(description = "We verify wait methods and if the elements selected are similar on both pages",groups = {"desktop.test"})
    public void verifyElementsAndWaitMethode() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        Select select = new Select(driver.findElement(By.id("combo1")));
        select.selectByIndex(1);
        WebElement element1 = driver.findElement(By.cssSelector("option[value = \"2\"]"));
        String elementValue = element1.getAttribute("value");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value=\"11\"]")));

        Select select1 = new Select(driver.findElement(By.id("combo2")));
        select1.selectByIndex(1);

        WebElement valueSecondField = driver.findElement(By.cssSelector("option[value = \"11\"]"));
        valueSecondField.getAttribute("value");
        String valueAttribute = valueSecondField.getAttribute("value");


        driver.findElement(By.cssSelector("input[type = \"submit\"]")).click();

        assertTrue(driver.getCurrentUrl().contains("the_form_processor.php?ajax=1"));

        WebElement element = driver.findElement(By.id("_valueid"));
        element.getText();
        WebElement valueFromSecoundPage = driver.findElement(By.id("_valuelanguage_id"));
        valueFromSecoundPage.getText();


//        assertEquals(element.getText(),"2","They are not the same ");
        assertTrue(elementValue.equals(element.getText()),"Not the same element");
        assertTrue(valueAttribute.equals(valueFromSecoundPage.getText()),"Not the same element");


    }

    @Test(description = "Verify the 5 sec button who will redirects to a different page and will come back to main page",groups = {"desktop.test"})
    public void verifyButtonsWhoRedirects() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");

        //Verify the url to see if we are on the right url
        assertTrue(driver.getCurrentUrl().contains("javascript-redirect-test.html"));

        driver.findElement(By.id("delaygotobasic")).click();

        //Verify the url to see if we are on the right url
        wait.until(ExpectedConditions.urlContains("redirected.html"));
        assertTrue(driver.getCurrentUrl().contains("redirected.html"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("goback"))).click();

    }

    @Test(description = "Verify the 2 sec button who will redirects to a different page and will come back to main page",groups = {"desktop.test"})
    public void verifyButtonsWhoRedirect(){

        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");

        driver.findElement(By.id("delaygotobounce")).click();



        wait.until(ExpectedConditions.elementToBeClickable(By.id("goback"))).click();


    }

    @Test(description = "Verify the refresh button and if the id from the tex is the same with the id from timestamp",groups = {"desktop.test"})
    public void idDynamic() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/refresh");

        driver.findElement(By.id("button")).click();

        WebElement idTimeStamp = driver.findElement(By.cssSelector("#refreshdate"));
        System.out.println(idTimeStamp.getText());

        WebElement idFromText = driver.findElement(By.id("embeddedrefreshdatevalue"));
        System.out.println(idFromText.getText());

        assertEquals(idTimeStamp.getText(),idFromText.getText(),"The id is not the same");


    }

    @Test(description = "Verify all the buttons and the message after all the buttons was clicked",groups = {"desktop.test"})
    public void verifyAllTheButtons(){

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");

        driver.findElement(By.cssSelector("#button00")).click();
        driver.findElement(By.id("button01")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();
        System.out.println(driver.findElement(By.cssSelector("#buttonmessage")).getText());

    }


    @Test(description = "Verify all the buttons and the message after all the buttons was clicked",groups = {"desktop.test"})
    public void verifyAllButtonsAndTheMessage(){

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button00"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button01"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();

        //Afisam mesajul ca toate butoanele au fost apasate (All Buttons Clicked)
        WebElement messageAfterClickAllTheButtons = driver.findElement(By.id("buttonmessage"));
        System.out.println(messageAfterClickAllTheButtons.getText());

        //Am verificat daca mesajul este la fel dupa ce am apasat toate butoanele o sa fie un True sau false aici
        System.out.println(wait.until(ExpectedConditions.textToBe(By.id("buttonmessage"),"All Buttons Clicked")));

        //Am verificat cu assert daca mesajul este la fel dupa ce am apasat toate butoanele
        assertEquals(driver.findElement(By.id("buttonmessage")).getText(),"All Buttons Clicked","Themessage is different");
        assertTrue(driver.findElement(By.id("buttonmessage")).getText().equals("All Buttons Clicked"));//All Buttons Clicked


    }


}
