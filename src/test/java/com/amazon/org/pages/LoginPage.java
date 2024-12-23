package com.amazon.org.pages;

import com.amazon.org.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@type='email']")
    WebElement enterEmailField;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//input[@type='password']")
    WebElement enterPasswordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement signInButton;

    public void enterEmailAndClickContinue(){
//        enterEmailField = wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        enterText(enterEmailField, PropertyReader.getProperty("username"));
        clickElement(continueBtn);
    }

    public void enterPasswordAndClickSignIn() {
//        enterPasswordField = wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        enterText(enterPasswordField, PropertyReader.getProperty("password"));
        clickElement(signInButton);
    }
}
