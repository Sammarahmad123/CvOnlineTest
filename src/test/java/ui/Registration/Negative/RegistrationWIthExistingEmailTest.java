package ui.Registration.Negative;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utils.EmailGenerator;
@Epic("CV Online")
@Story("CV Online - Negative Flow - Register with Existing Email")
public class RegistrationWIthExistingEmailTest extends BaseTest {
    private HomePage homePage;
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setUpTest() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.clickLoginRegister();
        registrationPage.goToRegistrationPageWithRegisterAsJobSeekerWIthEmail();
    }


    @Test
    public void testRegistrationWithValidDetails() {
        String validEmail = EmailGenerator.generateRandomEmail();
        String password = "123456";
        String firstName = "John";
        String lastName = "Doe";

        // First registration attempt
        registrationPage.registerNewUser(validEmail, password, firstName, lastName);

        registrationPage.reloadPage();
        homePage.clickLoginRegister();
        registrationPage.goToRegistrationPageWithRegisterAsJobSeekerWIthEmail();

        // Second registration attempt
        registrationPage.registerNewUser(validEmail, password, firstName, lastName);

        boolean isTooltipDisplayed = registrationPage.isEmailAlreadyInUseErrorMessageDisplayed();
        Assert.assertTrue(isTooltipDisplayed, "Email field tooltip 'This email is already in use' is not displayed.");

    }


}
