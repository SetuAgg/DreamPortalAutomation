package com.dreamportal.tests;

import com.dreamportal.constants.Constants;
import com.dreamportal.pages.HomePage;
import com.dreamportal.utils.DriverFactory;
import com.dreamportal.utils.ScreenshotUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.navigateTo();
    }

    @Test
    @Description("Verify loading animation and main content visibility")
    public void testHomePageLoad() {
        assertTrue(homePage.isLoadingAnimationVisible(), "Loading animation should be visible");
        assertTrue(homePage.isLoadingAnimationGone(), "Loading animation should disappear");
        assertTrue(homePage.isMainContentVisible(), "Main content should be visible");
        assertTrue(homePage.isMyDreamsButtonVisible(), "My Dreams button should be visible");
    }

    @Test
    @Description("Verify My Dreams button opens new tabs")
    public void testMyDreamsButton() {
        homePage.clickMyDreamsButton();
        assertEquals(driver.getWindowHandles().size(), 3, "Three windows/tabs should be open");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            ScreenshotUtil.captureScreenshot(driver, "HomePageTest");
            DriverFactory.quitDriver();
        }
    }
    
}
