package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QAJobOpportunitiesPage extends AbstractPage {
    @FindBy(css = "a[href*='qualityassurance']")
    private WebElement seeAllQAJobsButton;

    public OpenPositionsPage clickSeeAllQAJobsButton() {
        seeAllQAJobsButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[lang='en']")));
        return new OpenPositionsPage();
    }
}
