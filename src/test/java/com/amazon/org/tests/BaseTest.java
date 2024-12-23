package com.amazon.org.tests;

import com.amazon.org.pages.HomePage;
import com.amazon.org.pages.LoginPage;
import com.amazon.org.utils.DriverUtils;
import com.amazon.org.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        PropertyReader.initProperty();
        DriverUtils.createDriver();
        DriverUtils.getDriver().get(PropertyReader.getProperty("application.url"));

        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void cleanUp(){
        if (DriverUtils.getDriver() != null) {
            DriverUtils.getDriver().quit();
            DriverUtils.driver = null;
        }
    }
}
