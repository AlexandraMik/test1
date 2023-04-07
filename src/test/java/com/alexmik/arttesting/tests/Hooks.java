package com.alexmik.arttesting.tests;

import com.alexmik.arttesting.utils.ConfigReader;
import com.alexmik.arttesting.utils.TestSettings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class Hooks {
    private TestSettings testSettings;
    private WebDriver driver;

    @Before(order = 0)
    public void launchBrowser() {
        String browserName = "";
        try {
            browserName = ConfigReader.getBrowserType();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        testSettings = new TestSettings();
        driver = testSettings.initDriver(browserName);
    }
    @After(order = 0)
    public void closeBrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void endStep(Scenario scenario) {
        if (scenario.isFailed()) {
            String name = scenario.getName().replaceAll(" ", "_");
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", name);
            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        }
    }
}
