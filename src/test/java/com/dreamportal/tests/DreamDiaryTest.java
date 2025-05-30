package com.dreamportal.tests;

import com.dreamportal.constants.Constants;
import com.dreamportal.pages.DreamDiaryPage;
import com.dreamportal.utils.DriverFactory;
import com.dreamportal.utils.ScreenshotUtil;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class DreamDiaryTest {
    private WebDriver driver;
    private DreamDiaryPage diaryPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(Constants.BASE_URL + "dreams-diary.html");
        diaryPage = new DreamDiaryPage(driver);
    }

    @Test
    @Description("Verify dream diary table content")
    public void testDreamDiaryTable() {
        assertEquals(diaryPage.getDreamEntryCount(), 10, "Table should have 10 dream entries");
        assertTrue(diaryPage.areDreamTypesValid(), "Dream types should be Good or Bad");
        assertTrue(diaryPage.areAllColumnsFilled(), "All columns should be filled");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            ScreenshotUtil.captureScreenshot(driver, "DreamDiaryTest");
            DriverFactory.quitDriver();
        }
    }



    
}
