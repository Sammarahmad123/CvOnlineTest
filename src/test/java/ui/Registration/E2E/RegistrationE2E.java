package ui.Registration.E2E;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.EmailGenerator;
@Epic("CV Online")
@Story("CV Online - E2E Registration Flow")
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

    @Test(description = "Test Successful Registration with Valid Data")
    @Description("Test Description: Ensure that a user can register successfully with valid data.")
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
