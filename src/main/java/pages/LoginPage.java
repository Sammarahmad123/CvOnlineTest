package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UIActions;
import utils.WaitUtils;

import java.time.Duration;

import static configuration.TimeoutConfig.WAIT_SHORT;

public class LoginPage {

    private WebDriver driver;
    private UIActions uiActions;
    private WaitUtils waitUtils;
    private By loginAfterSuccessfulRegistrationButton = By.xpath("//button[contains(@class, 'btn btn--width-full btn--type-secondary')]//span[text()='Log in']");
    private By successfulRegistrationMessageLabel = By.xpath("//div[contains(@class, 'email-registration-success__text')]//span[text()='Your user has been created. Please check your email for the verification link.']");
    private By loginForm = By.xpath("//form[contains(@class, 'login-form')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        uiActions = new UIActions(driver);
        waitUtils = new WaitUtils(driver);
    }

    @Step("Click on Login Button")
    public void clickLoginButton() {
        WebElement loginBtnElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), loginAfterSuccessfulRegistrationButton);
        uiActions.click(loginBtnElement);
    }
    @Step("Checking that Registration Successful popup message label is shown")
    public boolean isSuccessfulRegistrationMessageShown() {
        try {
            WebElement successMessageElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), successfulRegistrationMessageLabel);
            return successMessageElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Step("Checking that Login Form is shown")
    public boolean isLoginFormShown() {
        try {
            WebElement loginFormElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), loginForm);
            return loginFormElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
