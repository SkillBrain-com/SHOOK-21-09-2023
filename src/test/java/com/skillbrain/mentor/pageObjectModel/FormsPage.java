package com.skillbrain.mentor.pageObjectModel;

import com.skillbrain.mentor.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends TestBase {




      private WebElement fullName = driver.findElement(By.id("userName"));
      private WebElement emailField =   driver.findElement(By.id("userEmail"));
      private WebElement currentAddress = driver.findElement(By.id("currentAddress"));
      private WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
      private WebElement submitButton = driver.findElement(By.id("submit"));

      public void fillForm(String name, String email, String address1, String address2){
          fullName.sendKeys(name);
          emailField.sendKeys(email);
          currentAddress.sendKeys(address1);
          permanentAddress.sendKeys(address2);
          submitButton.click();
      }
      public void fillName(String name, String email, String address2){
          fullName.sendKeys(name);
          emailField.sendKeys(email);
          permanentAddress.sendKeys(address2);
          submitButton.click();
      }
}
