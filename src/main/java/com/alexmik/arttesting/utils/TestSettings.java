package com.alexmik.arttesting.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class TestSettings {
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {
        System.out.println("Browser: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().browserVersion("111.0.0").setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            tlDriver.set(new ChromeDriver(chromeOptions));
            System.out.println("chrome ok");
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            tlDriver.set(new FirefoxDriver(firefoxOptions));
            System.out.println("firefox ok");
        }
        getDriver().manage().window().maximize();
        getDriver().get("https://artnow.ru");
        return getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }
}

