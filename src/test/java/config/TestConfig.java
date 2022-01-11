package config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static config.WebDriverSingleton.getDriverInstance;
import static config.WebDriverSingleton.quit;
import static utility.Screenshot.captureScreenshot;

public class TestConfig {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        String baseUrl = "http://automationpractice.com";

        driver = getDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);

    }

    @AfterEach
    public void tearDown() {
        captureScreenshot();
        quit();
    }
}
