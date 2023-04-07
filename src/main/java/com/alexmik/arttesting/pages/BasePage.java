package com.alexmik.arttesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private static final int WAIT_FOR_ELEMENT_SECONDS = 10;
    private static final int DEFAULT_TIME = 1000;

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebDriver getDriver() {return  this.driver;}
    protected void waitForElementVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_SECONDS)).
                until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForElementEnable(WebElement element){
        new WebDriverWait(driver,  Duration.ofSeconds(WAIT_FOR_ELEMENT_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void timeSleep(){
        try {
            Thread.sleep(DEFAULT_TIME);
        }
        catch (InterruptedException ex){
            System.err.println(ex.getMessage());
        }
    }
}
