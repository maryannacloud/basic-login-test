package com.amazon.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement signInLink;

    public void hoverOverSignInLinkAndClickSignIn(){
        hoverOver(signInLink);
        signInLink = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='Sign in']")));
        clickElement(signInLink);
    }
}
