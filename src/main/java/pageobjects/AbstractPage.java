package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSingleton;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "a#wt-cli-accept-btn")
    private WebElement onlyNecessaryCookiesBtn;

    public AbstractPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void acceptOnlyNecessaryCookies() {
        onlyNecessaryCookiesBtn.click();
    }
}
