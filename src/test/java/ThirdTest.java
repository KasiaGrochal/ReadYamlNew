import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ThirdTest extends TestBase{

    Logger logger = LoggerFactory.getLogger(PageTitleTest.class);

    @Test
    @DisplayName("THIRD TEST")
    @Tag("pageTitleTHIRD")
    @Tag("regression")
    public void validatePageTitleThird() {

        String displayedTitle = driver.getTitle();
        String expectedTitle = environmentProperties.get("title");
        assertThat(displayedTitle, equalTo(expectedTitle));
        logger.info("Displayed name: '{}' is the same as expected: '{}'. Test completed successfully.", displayedTitle, expectedTitle);


    }
}
