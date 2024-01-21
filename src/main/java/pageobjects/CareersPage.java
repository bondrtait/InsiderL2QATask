package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverUtils;

public class CareersPage extends AbstractPage {
    @FindBy(xpath = "//h3[contains(text(), 'calling')]/..")
    private WebElement teamsSection;
    @FindBy(xpath = "//h3[contains(text(), 'Locations')]/..")
    private WebElement locationsSection;
    @FindBy(xpath = "//h2[text()='Life at Insider']/..")
    private WebElement lifeAtInsiderSection;

    public boolean isCareersPageOpen() {
        return driver.getTitle().equals("Ready to disrupt? | Insider Careers");
    }

    public boolean isTeamsSectionDisplayed() {
        DriverUtils.scrollIntoElement(teamsSection);
        return DriverUtils.isElementVisible(teamsSection);
    }

    public boolean isLocationsSectionDisplayed() {
        DriverUtils.scrollIntoElement(locationsSection);
        return DriverUtils.isElementVisible(locationsSection);
    }

    public boolean isLifeAtInsiderSectionDisplayed() {
        DriverUtils.scrollIntoElement(lifeAtInsiderSection);
        return DriverUtils.isElementVisible(lifeAtInsiderSection);
    }
}
