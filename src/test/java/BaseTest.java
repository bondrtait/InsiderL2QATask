import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utils.DriverSingleton;

public class BaseTest {
    protected final WebDriver driver = DriverSingleton.getDriver();
    protected SoftAssert soft = new SoftAssert();
}
