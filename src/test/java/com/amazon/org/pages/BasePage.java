package com.amazon.org.pages;

import com.amazon.org.utils.DriverUtils;
import com.amazon.org.utils.PropertyReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    BasePage () {
        driver = DriverUtils.getDriver();
        action = new Actions(driver);
        PageFactory.initElements(driver, this);

        int implicitWaitTime = Integer.parseInt(PropertyReader.getProperty("implicit.wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));

        int explicitWaitTime = Integer.parseInt(PropertyReader.getProperty("explicit.wait"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));

        int pageLoadTimeout = Integer.parseInt(PropertyReader.getProperty("page.load.timeout"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    }

    public void hoverOver(WebElement element) {
        try {
            action.moveToElement(element).perform();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
