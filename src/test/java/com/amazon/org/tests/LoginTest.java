package com.amazon.org.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        homePage.hoverOverSignInLink();
    }
}