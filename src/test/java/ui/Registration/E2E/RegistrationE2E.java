package ui.Registration.E2E;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.EmailGenerator;

public class RegistrationE2E extends BaseTest {

    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUpTest() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testRegistrationWithValidDetails() {
        homePage.clickLoginRegister();
        registrationPage.goToRegistrationPageWithRegisterAsJobSeekerWIthEmail();
        String validEmail = EmailGenerator.generateRandomEmail();
        String password = "ValidPassword123";
        String firstName = "John";
        String lastName = "Doe";
        registrationPage.registerNewUser(validEmail, password, firstName, lastName);
        Assert.assertTrue(loginPage.isSuccessfulRegistrationMessageShown(), "Successful registration message is not displayed.");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginFormShown(), "Successful registration message is not displayed.");
    }
}
