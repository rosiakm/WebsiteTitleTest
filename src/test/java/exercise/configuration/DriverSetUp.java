package exercise.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverSetUp {
    private static Logger log = LoggerFactory.getLogger(DriverSetUp.class);
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        log.info("WebDriver started successfully");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        log.info("Chrome has been opened");
        driver.manage().window().maximize();
        log.info("Browser has been maximized");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        log.info("WebDriver has been quit");
    }
}
