import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utils.DriverSingleton;

public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert soft = new SoftAssert();
    protected final String pageShouldBeOpenedAssertMessage = "'%s' page should be opened";
    protected final String sectionShouldBeDisplayedAssertMessage = "'%s' section should be displayed";

    @BeforeClass
    public void getDriver() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.quit();
    }
}
