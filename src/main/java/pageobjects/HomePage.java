package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//a[@id='navbarDropdownMenuLink' and contains(text(), 'Company')]")
    private WebElement companyDropdown;

    @FindBy(css = "a[href*='careers'].dropdown-sub")
    private WebElement careersButton;

    @FindBy(css = "a#wt-cli-accept-btn")
    private WebElement onlyNecessaryCookiesBtn;

    public HomePage acceptOnlyNecessaryCookies() {
        onlyNecessaryCookiesBtn.click();
        return this;
    }

    public HomePage clickCompanyDropdown() {
        companyDropdown.click();
        return this;
    }

    public CareersPage clickCareersButton() {
        careersButton.click();
        return new CareersPage();
    }

    public boolean isHomePageDisplayed() {
        return driver.getTitle().equals("#1 Leader in Individualized, Cross-Channel CX — Insider");
    }
}
