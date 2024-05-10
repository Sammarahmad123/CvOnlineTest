package ui.Registration.Negative;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
@Epic("CV Online")
@Story("CV Online - Negative Flow - Invalid Email")
public class InvalidEmailTest extends BaseTest {
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
    public void testInvalidEmails() {
        String[] invalidEmails = {"invalidemail", "invalidemail@domain", "invalid.email.com"};
        for (String email : invalidEmails) {
            registrationPage.enterEmail(email);
            registrationPage.clickRegister();
            Assert.assertTrue(registrationPage.isInvalidEmailErrorMessageDisplayed(), "Email field error tooltip not shown for invalid email: " + email);
            registrationPage.clearField("email");
        }
    }


}
