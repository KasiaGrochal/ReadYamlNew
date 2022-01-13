
import configuration.AppConfig;
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

    private static DriverFactory driverFactory;
    private static AppConfig appConfig = new AppConfig();
    public static Map<String, String> environmentProperties;
    protected WebDriver driver;

    @BeforeAll
    static void setDriver() {
        environmentProperties= appConfig.getEnvironmentConfig();
        logger.info("Initialized environment properties");
        driverFactory = new DriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = driverFactory.getDriver(appConfig.getBrowserConfig());
        logger.info("Browser initialized successfully for {}", appConfig.getBrowserConfig());
        driver.get(environmentProperties.get("webUrl"));
        logger.info(environmentProperties.get("webUrl"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Browser closed successfully");
    }

}
