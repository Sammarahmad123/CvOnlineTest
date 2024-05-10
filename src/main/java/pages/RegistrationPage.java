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

public class RegistrationPage {
    private WebDriver driver;
    private UIActions uiActions;
    private WaitUtils waitUtils;


    private By registrationButton = By.xpath("//div[contains(@class, 'authentication-selector__button')]//span[text()='Registration']");
    private By forJobSeekersButton = By.xpath("//button[contains(@class, 'btn btn--width-full btn--type-secondary')]//span[text()='For job seekers']");
    private By registerWithEmailButton = By.xpath("//button[contains(@class, 'btn btn--width-full btn--type-secondary')]//span[text()='Register with email']");
    private By invalidEmailToolTipErrorLabel = By.xpath("//span[contains(@class, 'input-text-tooltip input-text-tooltip--error')]//span[text()='Enter a valid e-mail address']");
    private By emailAlreadyUsedTooltipErrorLabel = By.xpath("//span[contains(@class, 'input-text-tooltip input-text-tooltip--error')]//span[text()='This email is already in use.']");
    private By passwordNotCompleteTooltipErrorLabel = By.xpath("//span[contains(@class, 'input-password-tooltip input-password-tooltip--error')]//span[text()='Value is too short.']");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By agreeTermsCheckbox = By.xpath("//label[contains(@class, 'input-checkbox')]//span[text()='I agree to the ']");
    private By agreeGdprCheckbox = By.xpath("//label[contains(@class, 'input-checkbox')]//*[contains(text(),'I agree that my information will be sent to the employer')]");
    private By registerButton = By.xpath("//button[@type=\"submit\"]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        uiActions = new UIActions(driver);
        waitUtils = new WaitUtils(driver);
    }

    @Step("Clicking on 1. Registration button 2. Job Seeker Button 3. Register with Email Button")
    public void goToRegistrationPageWithRegisterAsJobSeekerWIthEmail() {
        WebElement registrationElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), registrationButton);
        uiActions.click(registrationElement);
        WebElement registerAsJobSeekerElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), forJobSeekersButton);
        uiActions.click(registerAsJobSeekerElement);
        WebElement registerWithEmailElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), registerWithEmailButton);
        uiActions.click(registerWithEmailElement);

    }

    @Step("Clear Field : {0}")
    public void clearField(String fieldName) {
        switch (fieldName) {
            case "email":
                uiActions.clearField(driver.findElement(emailField));
                break;
            case "password":
                uiActions.clearField(driver.findElement(passwordField));
                break;
            case "firstName":
                uiActions.clearField(driver.findElement(firstNameField));
                break;
            case "lastName":
                uiActions.clearField(driver.findElement(lastNameField));
                break;
            default:
                System.out.println("Invalid field name.");
                break;
        }
    }

    @Step("Checking that {0} field turn red")
    public boolean isFieldRed(String fieldType) {
        String xpath;
        if (fieldType.equals("agreeTerms") || fieldType.equals("agreeGdpr")) {
            xpath = String.format("//input[@name='%s']//following-sibling::span[contains(@class, 'input-checkbox__icon input-checkbox__icon--error')]", fieldType);
        } else if (fieldType.contains("password")) {
            xpath = "//label[contains(@class, 'input-password input-password--width-full input-password--state-error')]//input";
        } else {
            xpath = String.format("//label[contains(@class, 'input-text input-text--width-full input-text--state-error')]//input[@name='%s']", fieldType);
        }
        WebElement fieldInputElement = driver.findElement(By.xpath(xpath));
        return fieldInputElement.isDisplayed();
    }

    @Step("Checking Invalid Email Error Message is shown")
    public boolean isInvalidEmailErrorMessageDisplayed() {
        try {
            WebElement errorMessage = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), invalidEmailToolTipErrorLabel);
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking password not completed error is shown")
    public boolean isPasswordNotCompleteErrorMessageDisplayed() {
        try {
            WebElement errorMessage = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), passwordNotCompleteTooltipErrorLabel);
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking email already exists error is shown")
    public boolean isEmailAlreadyInUseErrorMessageDisplayed() {
        try {
            WebElement errorMessage = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), emailAlreadyUsedTooltipErrorLabel);
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Entering email :{0}")
    public void enterEmail(String email) {
        WebElement emailElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), emailField);
        uiActions.enterText(emailElement, email);
    }

    @Step("Entering password")
    public void enterPassword(String password) {
        WebElement passwordElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), passwordField);
        uiActions.enterText(passwordElement, password);
    }

    @Step("Entering first name:{0}")
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), firstNameField);
        uiActions.enterText(firstNameElement, firstName);
    }

    @Step("Entering last name:{0}")
    public void enterLastName(String lastName) {
        WebElement lastNameElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), lastNameField);
        uiActions.enterText(lastNameElement, lastName);
    }

    @Step("Checking accepts terms checkbox")
    public void acceptTerms() {
        WebElement termsElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), agreeTermsCheckbox);
        uiActions.click(termsElement);
    }

    @Step("Checking accepts GDPR checkbox")
    public void acceptGDPR() {
        WebElement gdprElement = waitUtils.waitForVisibilityOfElement(Duration.ofSeconds(WAIT_SHORT), agreeGdprCheckbox);
        uiActions.click(gdprElement);
    }

    @Step("Clicking on register button")
    public void clickRegister() {
        WebElement registerButtonElement = waitUtils.waitForElementToBeClickable(Duration.ofSeconds(WAIT_SHORT), registerButton);
        uiActions.click(registerButtonElement);
    }

    @Step("Reload Page")
    public void reloadPage() {
        driver.navigate().refresh();
    }

    @Step("Register new User")
    public void registerNewUser(String email, String password, String firstName, String lastName) {
        enterEmail(email);
        enterPassword(password);
        enterFirstName(firstName);
        enterLastName(lastName);
        acceptTerms();
        acceptGDPR();
        clickRegister();
    }
}
