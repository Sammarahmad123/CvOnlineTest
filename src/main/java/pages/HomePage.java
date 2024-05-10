package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UIActions;
import utils.WaitUtils;

import java.time.Duration;

import static configuration.TimeoutConfig.WAIT_SHORT;

public class HomePage {
    private WebDriver driver;
    private UIActions uiActions;
    private WaitUtils waitUtils;
    private By loginRegisterButton = By.xpath("//button[contains(@class, 'btn-plain btn-plain--secondary')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        uiActions = new UIActions(driver);
    }
    @Step("Click on Login|Register Button at Home Page")
    public void clickLoginRegister() {
        WebElement loginRegisterElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), loginRegisterButton);
        uiActions.click(loginRegisterElement);
    }
}
