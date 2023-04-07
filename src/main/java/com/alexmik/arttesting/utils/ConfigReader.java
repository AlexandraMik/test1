package com.alexmik.arttesting.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;
public class ConfigReader {
    private static String browserType = null;

    public static void setBrowserType(String browser)
    {
        browserType = browser;
    }
    public static String getBrowserType() {
        if (browserType != null)
            return browserType;
        else throw new RuntimeException("browser is not specified");
    }
}
