package com.alexmik.arttesting.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;
public class ConfigReader {
    private Properties prop;
    private static String browserType = null;

    public Properties initProp() {
        prop = new Properties();
        try {
            FileInputStream inp = new FileInputStream("./src/main/resources/application.properties");
            prop.load(inp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBrowserType(prop.getProperty("browser"));
        return prop;
    }

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
