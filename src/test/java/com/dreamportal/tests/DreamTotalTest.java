package com.dreamportal.tests;

import com.dreamportal.constants.Constants;
import com.dreamportal.pages.DreamTotalPage;
import com.dreamportal.utils.DriverFactory;
import com.dreamportal.utils.ScreenshotUtil;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DreamTotalTest {
    private WebDriver driver;
    private DreamTotalPage totalPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(Constants.BASE_URL + "dreams-total.html");
        totalPage = new DreamTotalPage(driver);
    }

    @Test
    @Description("Verify dream summary stats")
    public void testDreamSummary() {
        assertEquals(totalPage.getGoodDreamsCount(), 6, "Good dreams count should be 6");
        assertEquals(totalPage.getBadDreamsCount(), 4, "Bad dreams count should be 4");
        assertEquals(totalPage.getTotalDreamsCount(), 10, "Total dreams count should be 10");
        assertEquals(totalPage.getRecurringDreamsCount(), 2, "Recurring dreams count should be 2");
        assertTrue(totalPage.areRecurringDreamsCorrect(), "Recurring dreams should include 'Flying over mountains' and 'Lost in maze'");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            ScreenshotUtil.captureScreenshot(driver, "DreamTotalTest");
            DriverFactory.quitDriver();
        }
    }
    
}
