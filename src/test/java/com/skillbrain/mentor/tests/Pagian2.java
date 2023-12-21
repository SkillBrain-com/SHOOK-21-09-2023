package com.skillbrain.mentor.tests;

import com.skillbrain.mentor.utils.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Pagian2 extends TestBase {

    @Test
    public void test2(){
        driver.get("https://demoqa.com/buttons");

        driver.findElement(By.id("doubleClickBtn")).click();
    }
}
