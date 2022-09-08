package exercise.tests;

import exercise.configuration.DriverSetUp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest extends DriverSetUp {
    private static Logger log = LoggerFactory.getLogger(WebsiteTitleTest.class);

    @ParameterizedTest(name = "{0} has been verified")
    @CsvFileSource(resources = "/data.csv")
    @Tag("Regression")
    @DisplayName("Website title tests")
    void websiteTitleTest(String title, String websiteAddress, String expectedTitle) {
        getDriver().get(websiteAddress);
        log.info("My website address is: " + websiteAddress);
        assertThat(getDriver().getTitle()).isEqualTo(expectedTitle);
    }
}
