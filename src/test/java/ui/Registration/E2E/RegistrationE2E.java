package ui.Registration.E2E;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
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
    private final String validEmail = EmailGenerator.generateRandomEmail();
    private final String password = "ValidPassword123";
    private final String firstName = "John";
    private final String lastName = "Doe";

    @BeforeClass
    public void setUpTest() {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Test Successful Registration with Valid Data")
    @Description("Test Description: Ensure that a user can register successfully with valid data.")
    public void testRegistrationWithValidDetails() {
        step1();
        step2();
        step3();
        step4();
        step5();

    }
    @Step("Step 1: Click on Login|Registration Button")
    public void step1(){
        homePage.clickLoginRegister();
    }
    @Step("Step 2: Go To Registration Page as a job seeker with email registration")
    public void step2(){
        registrationPage.goToRegistrationPageWithRegisterAsJobSeekerWIthEmail();
    }
    @Step("Step 3: Register New user")
    public void step3(){
        registrationPage.registerNewUser(validEmail, password, firstName, lastName);
    }
    @Step("Step 4: Verify that successful registration message is shown")
    public void step4(){
        Assert.assertTrue(loginPage.isSuccessfulRegistrationMessageShown(), "Successful registration message is not displayed.");
    }
    @Step("Step 5: Click Login Button")
    public void step5(){
        loginPage.clickLoginButton();
    }
    @Step("Step 6: Verify that Login Form is Shown")
    public void step6(){
        Assert.assertTrue(loginPage.isLoginFormShown(), "Successful registration message is not displayed.");
    }
}
