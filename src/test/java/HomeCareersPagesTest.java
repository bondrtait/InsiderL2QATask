import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.CareersPage;
import pageobjects.HomePage;

public class HomeCareersPagesTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void setup() {
        String useInsiderBaseUrl = "https://useinsider.com/";
        driver.get(useInsiderBaseUrl);
        homePage = new HomePage();
        homePage.acceptOnlyNecessaryCookies();
    }

    @Test
    public void verifyHomePage() {
        Assert.assertTrue(homePage.isHomePageDisplayed(),
                String.format(pageShouldBeOpenedAssertMessage, "Home"));
    }

    @Test(dependsOnMethods = "verifyHomePage")
    public void verifyCareersPage() {
        CareersPage careersPage = homePage
                .clickCompanyDropdown()
                .clickCareersButton();
        soft.assertTrue(careersPage.isCareersPageOpen(),
                String.format(pageShouldBeOpenedAssertMessage, "Careers"));
        soft.assertTrue(careersPage.isTeamsSectionDisplayed(),
                String.format(sectionShouldBeDisplayedAssertMessage, "Teams"));
        soft.assertTrue(careersPage.isLocationsSectionDisplayed(),
                String.format(sectionShouldBeDisplayedAssertMessage, "Locations"));
        soft.assertTrue(careersPage.isLifeAtInsiderSectionDisplayed(),
                String.format(sectionShouldBeDisplayedAssertMessage, "Life At Insider"));
        soft.assertAll();
    }
}
