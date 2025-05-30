package com.dreamportal.pages;

import com.dreamportal.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class DreamTotalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "good-dreams")
    private WebElement goodDreams;

    @FindBy(id = "bad-dreams")
    private WebElement badDreams;

    @FindBy(id = "total-dreams")
    private WebElement totalDreams;

    @FindBy(id = "recurring-dreams")
    private WebElement recurringDreams;

    @FindBy(css = "#recurring-dreams-list li")
    private List<WebElement> recurringDreamsList;

    public DreamTotalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        PageFactory.initElements(driver, this);
    }

    public int getGoodDreamsCount() {
        return Integer.parseInt(goodDreams.getText());
    }

    public int getBadDreamsCount() {
        return Integer.parseInt(badDreams.getText());
    }

    public int getTotalDreamsCount() {
        return Integer.parseInt(totalDreams.getText());
    }

    public int getRecurringDreamsCount() {
        return Integer.parseInt(recurringDreams.getText());
    }

    public boolean areRecurringDreamsCorrect() {
        boolean hasFlying = false, hasMaze = false;
        for (WebElement dream : recurringDreamsList) {
            String text = dream.getText();
            if (text.contains("Flying over mountains")) hasFlying = true;
            if (text.contains("Lost in maze")) hasMaze = true;
        }
        return hasFlying && hasMaze;
    }
    
}
