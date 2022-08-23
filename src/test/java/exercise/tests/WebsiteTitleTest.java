package exercise.tests;

import exercise.configuration.DriverSetUp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest extends DriverSetUp {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @Tag("Regression")
    @DisplayName("Website title test")
    void websiteTitleTest(String websiteAddress, String expectedTitle){
        getDriver().get(websiteAddress);
        String actualTitle = getDriver().getTitle();

        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

}
