
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    private static BrowserFactory browserFactory;
    protected WebDriver driver;

    @BeforeAll
    static void setDriver() {
        new AppProperties();
        logger.info("Initialized environment properties");
        browserFactory = new BrowserFactory();
        logger.info("Initialized browser environment");
    }

    @BeforeEach
    void setup() {
        driver = browserFactory.getDriver(new BrowserProperties().getActiveBrowser());
        logger.info("Browser initialized successfully");
        driver.get(System.getProperty("webUrl"));
        logger.info("Website opened at: {}", System.getProperty("webUrl"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Browser closed successfully");
    }

}
