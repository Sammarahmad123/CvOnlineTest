package base;

import configuration.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriverSetup webDriverSetup;
    protected WebDriver driver;
    private ConfigReader configReader;
    private final String baseUrl = "https://test.cv.ee/en";

    @BeforeClass
    public void setUp() {
        configReader = new ConfigReader();
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.startWebDriver();
        driver = webDriverSetup.getDriver();
        driver.get(configReader.getBaseUrl());
    }

    @AfterClass
    public void tearDown() {
        if (webDriverSetup != null) {
            webDriverSetup.closeDriver();
        }
    }


}
