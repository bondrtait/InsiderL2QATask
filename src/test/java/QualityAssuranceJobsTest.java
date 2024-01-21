import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.OpenPositionsPage;
import pageobjects.QAJobOpportunitiesPage;

public class QualityAssuranceJobsTest extends BaseTest {
    private QAJobOpportunitiesPage qaJobOpportunitiesPage;
    private OpenPositionsPage openPositionsPage;
    private final String positionFieldShouldBe = "Position %s should be '%s'";

    @BeforeClass
    public void setup() {
        String qaJobsUrl = "https://useinsider.com/careers/quality-assurance/";
        driver.get(qaJobsUrl);
        qaJobOpportunitiesPage = new QAJobOpportunitiesPage();
        qaJobOpportunitiesPage.acceptOnlyNecessaryCookies();
    }

    @Test
    public void verifyJobsFiltering() {
        openPositionsPage = qaJobOpportunitiesPage
                .clickSeeAllQAJobsButton()
                .filterByIstanbulLocation()
                .filterByQADepartment();
        soft.assertTrue(openPositionsPage.isJobsListPresent(),
                String.format(sectionShouldBeDisplayedAssertMessage, "Jobs List"));

        String qualityAssurance = "Quality Assurance";
        openPositionsPage
                .getAllPositionsTitles()
                .forEach(title -> soft.assertTrue(title.contains(qualityAssurance),
                        String.format("Position '%s' Title should be %s", title, qualityAssurance)));
        openPositionsPage
                .getAllPositionsDepartments()
                .forEach(department -> soft.assertEquals(department, qualityAssurance,
                        String.format(positionFieldShouldBe, "Department", qualityAssurance)));
        openPositionsPage
                .getAllPositionsLocations()
                .forEach(location -> soft.assertEquals(location, "Istanbul, Turkey",
                        String.format(positionFieldShouldBe, "Location", "Istanbul, Turkey")));
        soft.assertAll();
    }

    @Test(dependsOnMethods = "verifyJobsFiltering", alwaysRun = true)
    public void verifyViewJobRedirectsToLever() {
        String originalWindow = driver.getWindowHandle();
        openPositionsPage.openLeverApplicationPage();

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("https://jobs.lever.co/"),
                String.format(pageShouldBeOpenedAssertMessage, "Lever Application"));
    }
}
