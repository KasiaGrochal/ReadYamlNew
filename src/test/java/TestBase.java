
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    private static BrowserFactory browserFactory;
    private static AppProperties appProperties;
    protected WebDriver driver;


    @BeforeAll
    static void setDriver() {
        appProperties = new AppProperties();
        logger.info("Initialized environment properties");
        browserFactory = new BrowserFactory();
        logger.info("Initialized browser environment");
    }

    @BeforeEach
    void setup() {
        driver = browserFactory.getDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
