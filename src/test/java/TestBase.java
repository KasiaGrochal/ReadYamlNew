
import configuration.AppConfig;
import configuration.browser.Browser;
import configuration.browser.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TestBase {

    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    private static Browser browser;
    private static AppConfig appConfig = new AppConfig();
    public static Map<String, String> environmentProperties;
    protected WebDriver driver;

    @BeforeAll
    static void setDriver() {
        environmentProperties= appConfig.getEnvironmentConfig();
        browser =appConfig.getBrowserConfig();
        logger.info("Initialized environment properties");
    }

    @BeforeEach
    void setup() {
        driver = new DriverFactory().getDriver(browser);
        logger.info("Browser initialized successfully");
        driver.get(environmentProperties.get("webUrl"));
        logger.info(environmentProperties.get("webUrl"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Browser closed successfully");
    }

}
