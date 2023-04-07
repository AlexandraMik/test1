package com.alexmik.arttesting;

import com.alexmik.arttesting.utils.ConfigReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
        "com.alexmik.arttesting.tests" }, monochrome = true, plugin = { "pretty", })
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void defineBrowser(String browser) {
        ConfigReader.setBrowserType(browser);
    }
}