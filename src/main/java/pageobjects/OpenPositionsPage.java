package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OpenPositionsPage extends AbstractPage {
    private final String locationFiltersListLocator = "//li[starts-with(@id, 'select2-filter-by-location')]";
    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    private WebElement filterByLocationSelect;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']/..")
    private WebElement filterByDepartmentSelect;

    @FindBy(css = "li[data-select2-id*='Istanbul']")
    private WebElement istanbulFilterEntry;

    @FindBy(css = "li[data-select2-id*='Quality Assurance']")
    private WebElement qaFilterEntry;

    @FindBy(xpath = "//p[starts-with(@class, 'position-title')]")
    private List<WebElement> positionsTitles;
    @FindBy(xpath = "//span[starts-with(@class, 'position-department')]")
    private List<WebElement> positionsDepartments;
    @FindBy(xpath = "//div[starts-with(@class, 'position-location')]")
    private List<WebElement> positionsLocations;

    @FindBy(css = "h3.mb-0")
    private WebElement browseOpenPositionHeadline;

    @FindBy(xpath = "//a[text()='View Role']")
    private WebElement viewRoleButton;

    public OpenPositionsPage openFilterByLocationSelect() {
        filterByLocationSelect.click();
        if (driver.findElements(By.xpath(locationFiltersListLocator)).size() <= 1) {
            filterByLocationSelect.click();
            filterByLocationSelect.click();
        }
        return this;
    }

    public OpenPositionsPage filterByIstanbulLocation() {
        openFilterByLocationSelect();
        istanbulFilterEntry.click();
        return this;
    }

    public OpenPositionsPage clickFilterByDepartmentSelect() {
        filterByDepartmentSelect.click();
        return this;
    }

    public OpenPositionsPage filterByQADepartment() {
        clickFilterByDepartmentSelect();
        wait.until(ExpectedConditions.elementToBeClickable(qaFilterEntry));
        qaFilterEntry.click();
        return this;
    }

    public boolean isJobsListPresent() {
        DriverUtils.scrollIntoElement(browseOpenPositionHeadline);
        wait.until(ExpectedConditions.visibilityOfAllElements(positionsTitles));
        return !positionsTitles.isEmpty();
    }

    public List<String> getAllPositionsTitles() {
        return positionsTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllPositionsDepartments() {
        return positionsDepartments.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllPositionsLocations() {
        return positionsLocations.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void openLeverApplicationPage() {
        viewRoleButton.click();
    }
}
