package com.skillbrain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

abstract class AbstractPageBase {
    protected WebDriver driver;

    public AbstractPageBase(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
}
