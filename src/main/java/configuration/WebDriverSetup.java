package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverSetup {

    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(WebDriverSetup.class);

    // Method to start WebDriver with default options
    public void startWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        localDriver(options);
    }

    // Private method to initialize the WebDriver with given options
    private void localDriver(ChromeOptions options) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        logger.info("Started WebDriver with resolution: {}", driver.manage().window().getSize().toString());
    }

    // Method to close the WebDriver
    public void closeDriver() {
        if (driver != null) {
            String url = driver.getCurrentUrl();
            logger.info("Closing WebDriver with current URL: {}", url);
            driver.quit();
        }
    }


    // Getter for the WebDriver
    public WebDriver getDriver() {
        return driver;
    }
}
