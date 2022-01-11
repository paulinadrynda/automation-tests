package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverSingleton.getDriverInstance;

public class Actions {
    static final int WAIT_TIMEOUT = 10;
    private static WebDriverWait wait = new WebDriverWait(getDriverInstance(), WAIT_TIMEOUT);

    public static void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
