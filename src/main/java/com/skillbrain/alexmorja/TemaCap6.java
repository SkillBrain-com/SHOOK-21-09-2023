package com.skillbrain.alexmorja;
import com.skillbrain.driver.BrowserManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class TemaCap6 {

    public static void main(String[] args) throws IOException {

//        alerts();
        htmlForm();
//        browserWindows();

    }

    public static void alerts() throws IOException {

        ChromeDriver driver = BrowserManager.getChromeDriver();

        try{
            driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

            WebElement firstButton = driver.findElement(By.id("alertexamples"));
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            firstButton.click();

            Alert alert = driver.switchTo().alert();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            System.out.println(alert.getText());
            alert.accept();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));


            WebElement secoundButton = driver.findElement(By.id("confirmexample"));
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            secoundButton.click();

            Alert alert1 = driver.switchTo().alert();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            System.out.println(alert1.getText());
            alert1.accept();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));

            secoundButton.click();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            alert1.dismiss();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));



            WebElement thirdButton = driver.findElement(By.cssSelector("input[id=\"promptexample\"]"));
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            thirdButton.click();

            Alert alert2 = driver.switchTo().alert();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));
            System.out.println(alert2.getText());
            alert2.sendKeys("text introdus");
            alert2.accept();
            System.out.println("Alerta este deschisa " + isAlertOpen(driver));

            driver.quit();

        }catch (Exception e) {


            File file = driver.getScreenshotAs(OutputType.FILE);
            File destinFile = new File("C:\\Users\\Alex\\OneDrive\\Desktop\\ScreenShotTemaCap6\\ScreenShotTemaCap6.png");
            FileUtils.copyFile(file,destinFile);

            System.out.println("Am prins exceptia " + e );

        }finally {

            driver.quit();

        }
    }
    public static  boolean isAlertOpen (ChromeDriver driver){

        try{
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }

    }


    public static void htmlForm() throws IOException {

        ChromeDriver driver = BrowserManager.getChromeDriver();

        try{

            driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

            WebElement userName = driver.findElement(By.cssSelector("input[name=\"username\"]"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement textArea = driver.findElement(By.cssSelector("textarea[name=\"comments\"]"));
            WebElement chooseFile = driver.findElement(By.cssSelector("input[name=\"filename\"]"));
            List<WebElement> checkBox = driver.findElements(By.name("checkboxes[]"));
            List<WebElement> radioButton = driver.findElements(By.name("radioval"));
            Select select = new Select(driver.findElement(By.name("multipleselect[]")));
            Select dropDown = new Select(driver.findElement(By.name("dropdown")));
            WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
            //sau
            WebElement submitFromBodyWithForm = driver.findElement(By.id("HTMLFormElements"));

            userName.sendKeys("Madona");
            password.sendKeys("Madona23");
            textArea.clear();
            textArea.sendKeys("Am adaugat un text");
            chooseFile.sendKeys("C:\\Users\\Alex\\OneDrive\\Pictures\\Screenshots\\AIR PEPE.png");
            checkBox.get(0).click();
            radioButton.get(0).click();
            select.deselectAll();
            select.selectByIndex(1);
//            select.selectByValue("ms1");
            dropDown.selectByIndex(0);
//            submit.click();
            //sau
            submitFromBodyWithForm.submit();


        }catch (Exception e){

            File file = driver.getScreenshotAs(OutputType.FILE);
            File destinFile = new File("C:\\Users\\Alex\\OneDrive\\Desktop\\ScreenShotTemaCap6\\ScreenShotTemaCap6.png");
            FileUtils.copyFile(file,destinFile);
            System.out.println("Am prins exceptia " + e);
        }finally {
            driver.quit();
        }

    }


    public static void browserWindows() throws IOException {

        ChromeDriver driver = null;

        try {
            driver = BrowserManager.getChromeDriver();
            driver.get("https://demoqa.com/browser-windows");

            WebElement newTab = driver.findElement(By.id("1tabButton"));
            newTab.click();

            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();

            for(String window : windowHandles){

                if(!window.equals(parentWindow)){
                    driver.switchTo().window(window);
                    break;
                }

            }

            WebElement tabOpen = driver.findElement(By.id("sampleHeading"));
            System.out.println("Mesaj de pe noul tab deschis " + tabOpen.getText());
            driver.close();

            driver.switchTo().window(parentWindow);



            WebElement newWindow = driver.findElement(By.id("windowButton"));
            newWindow.click();

            String parentWindow1 = driver.getWindowHandle();
            Set<String> windowHandles2 = driver.getWindowHandles();

            for(String window : windowHandles2){

                if(!window.equals(parentWindow1)){   /* -> niciodata nu or sa fie egale, pt ca parentWindow o sa aibe un id si windowHandles o sa aibe 2 id-uri
                                                           si de la pagina principala si de la tabul nou deschis*/

                    driver.switchTo().window(window);
                    break;
                }
            }

            WebElement newWindowOpen = driver.findElement(By.id("sampleHeading"));
            System.out.println("Mesajul de pe windows-ul nou deschis " + newWindowOpen.getText());
            driver.close();

            driver.switchTo().window(parentWindow1);


            WebElement newWindowMessage = driver.findElement(By.cssSelector("button[id=\"messageWindowButton\"]"));
            newWindowMessage.click();

            String windowParent2 = driver.getWindowHandle();
            Set <String> windowHandles3 = driver.getWindowHandles();

            for (String window : windowHandles3){

                if(!window.equals(windowParent2)){
                    driver.switchTo().window(window);


                    break;
                }
            }


            driver.close();

            driver.switchTo().window(windowParent2);




        }catch (Exception e){

            if(driver!=null){



                File file = driver.getScreenshotAs(OutputType.FILE);
                File destinFile = new File("C:\\Users\\Alex\\OneDrive\\Desktop\\ScreenShotTemaCap6\\ScreenShotTemaCap6.png");
                System.out.println("Calea de salvare " + destinFile);

                try {

                    FileUtils.copyFile(file,destinFile);


                }catch (IOException f){

                    System.out.println("Failed to screenshot");
                }

                System.out.println("Am prins exceptia " + e);
            }else {
                System.out.println("Driver instance Failed to create");
            }


        }finally {
            if (driver!=null){
                driver.quit();
            }
        }

    }
}
