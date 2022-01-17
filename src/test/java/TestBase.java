
import configuration.AppConfig;
import configuration.Config;
import configuration.ConfigReader;
import configuration.browser.Browser;
import configuration.browser.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.Map;


@Slf4j
public class TestBase {

    private static Browser browser;
    protected WebDriver driver;
    public static Map<String, String> environmentProperties;

    @BeforeAll
    static void setDriver() {
        Config config = new ConfigReader().getConfig();
        environmentProperties = AppConfig.getEnvironmentConfig(config);
        browser = AppConfig.getBrowser(config);
        log.info("Initialized environment properties");

    }

    @BeforeEach
    void setup() {
        driver = new DriverFactory().getDriver(browser);
        log.info("Browser initialized successfully");
        driver.get(environmentProperties.get("webUrl"));
        log.info(environmentProperties.get("webUrl"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        log.info("Browser closed successfully");
    }

}
