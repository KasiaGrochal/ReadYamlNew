import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SecondTest extends TestBase{

    Logger logger = LoggerFactory.getLogger(PageTitleTest.class);

    @Test
    @DisplayName("SECOND TEST")
    @Tag("pageTitleSECOND")
    @Tag("regression")
    public void validatePageTitleSecond() {

        String displayedTitle = driver.getTitle();
        String expectedTitle = System.getProperty("title");
        assertThat(displayedTitle, equalTo(expectedTitle));
        logger.info("Displayed name: '{}' is the same as expected: '{}'. Test completed successfully.", displayedTitle, expectedTitle);


    }
}
