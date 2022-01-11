package utility;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static config.WebDriverSingleton.getDriverInstance;

public class Screenshot {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot() {
        return ((TakesScreenshot) getDriverInstance()).getScreenshotAs(OutputType.BYTES);
    }
}