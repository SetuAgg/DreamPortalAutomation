package main.java.com.dreamportal.pages;

import com.dreamportal.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class DreamDiaryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "table#dream-table tbody tr")
    private List<WebElement> dreamRows;

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        PageFactory.initElements(driver, this);
    }

    public int getDreamEntryCount() {
        return dreamRows.size();
    }

    public boolean areDreamTypesValid() {
        for (WebElement row : dreamRows) {
            String dreamType = row.findElements(org.openqa.selenium.By.tagName("td")).get(2).getText();
            if (!dreamType.equals("Good") && !dreamType.equals("Bad")) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllColumnsFilled() {
        for (WebElement row : dreamRows) {
            List<WebElement> columns = row.findElements(org.openqa.selenium.By.tagName("td"));
            if (columns.size() != 3) return false;
            for (WebElement column : columns) {
                if (column.getText().isEmpty()) return false;
            }
        }
        return true;
    }
}