package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtils {
    private static final WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(2));
    public static void scrollIntoElement(WebElement element) {
        ((JavascriptExecutor) DriverSingleton.getDriver())
                .executeScript("arguments[0].scrollIntoView({block: 'center'})", element);
    }

    public static boolean isElementVisible(WebElement element) {
        try {
            wait.until((WebDriver driver) -> isVisibleInViewport(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private static boolean isVisibleInViewport(WebElement element) {
        return (boolean)((JavascriptExecutor) DriverSingleton.getDriver()).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }

}
