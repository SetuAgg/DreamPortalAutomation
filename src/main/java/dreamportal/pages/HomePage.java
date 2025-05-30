package com.dreamportal.pages;

import com.dreamportal.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "loading-animation")
    private WebElement loadingAnimation;

    @FindBy(id = "main-content")
    private WebElement mainContent;

    @FindBy(id = "my-dreams-btn")
    private WebElement myDreamsButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get(Constants.BASE_URL);
    }

    public boolean isLoadingAnimationVisible() {
        return wait.until(ExpectedConditions.visibilityOf(loadingAnimation)).isDisplayed();
    }

    public boolean isLoadingAnimationGone() {
        return wait.until(ExpectedConditions.invisibilityOf(loadingAnimation));
    }

    public boolean isMainContentVisible() {
        return wait.until(ExpectedConditions.visibilityOf(mainContent)).isDisplayed();
    }

    public boolean isMyDreamsButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOf(myDreamsButton)).isDisplayed();
    }

    public void clickMyDreamsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(myDreamsButton)).click();
    }
}

