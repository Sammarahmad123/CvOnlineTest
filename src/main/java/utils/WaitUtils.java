package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }


    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, java.util.concurrent.TimeUnit.SECONDS);
    }


    public WebElement waitForVisibilityOfElement(Duration timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(Duration timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
