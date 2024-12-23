package com.amazon.org.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtils {

    public static WebDriver driver;

    public static void createDriver(){

        String host = PropertyReader.property.getProperty("application.host");

        if (host.equalsIgnoreCase("local")) {
            createLocalDriver();
        } else {
            throw new RuntimeException("Unsupported host " + host);
        }

        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(Long.parseLong(PropertyReader.property.getProperty("implicit.wait"))));
        }
    }

    public static void createLocalDriver(){
        String browser = PropertyReader.property.getProperty("application.browser");
        switch (browser.toLowerCase()){
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

        }
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Call createDriver() first.");
        }
        try {
            driver.getCurrentUrl();
        } catch (Exception e) {
            throw new RuntimeException("Driver session is no longer active. Re-initialize the driver.");
        }
        return driver;
    }
}
