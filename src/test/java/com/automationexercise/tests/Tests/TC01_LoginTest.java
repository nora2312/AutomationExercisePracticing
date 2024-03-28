package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P01_LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.getTimestamp;

public class TC01_LoginTest {
    private final String email = getJsonData("loginData", "email") + getTimestamp() + "@gmail.com"; //ahmedashraf09@gmail
    private final String password = getJsonData("loginData", "password");
    private final String ERROR_MSG = getJsonData("loginData", "errorMessage");

    @BeforeMethod
    public void setup() {
        createInstance(getEnvironmentPropertyValue("BROWSER"));
        new P01_LoginPage(getDriver()).navigateToLoginUrl();
    }




    @AfterMethod
    public void quit() {
        DriverManager.quit();
    }
}