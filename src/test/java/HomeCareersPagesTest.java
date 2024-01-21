import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CareersPage;
import pageobjects.HomePage;

public class HomeCareersPagesTest extends BaseTest {
    private static final String USE_INSIDER_BASE_URL = "https://useinsider.com/";
    private HomePage homePage;

    @Test
    public void verifyHomePage() {
        driver.get(USE_INSIDER_BASE_URL);
        homePage = new HomePage();
        homePage.acceptOnlyNecessaryCookies();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home Page should be opened");
    }

    @Test(dependsOnMethods = "verifyHomePage")
    public void verifyCareersPage() {
        CareersPage careersPage = homePage
                .clickCompanyDropdown()
                .clickCareersButton();
        soft.assertTrue(careersPage.isCareersPageOpen());
        soft.assertTrue(careersPage.isTeamsSectionDisplayed());
        soft.assertTrue(careersPage.isLocationsSectionDisplayed());
        soft.assertTrue(careersPage.isLifeAtInsiderSectionDisplayed());
        soft.assertAll();
    }
}
