package ui.Registration.Negative;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class ShortPasswordTooltipTest extends BaseTest {
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
    public void testShortPasswordTooltip() {
        String validEmail = "example@example.com";
        String shortPassword = "c";
        registrationPage.enterEmail(validEmail);
        registrationPage.enterPassword(shortPassword);
        registrationPage.clickRegister();
        boolean isTooltipDisplayed = registrationPage.isPasswordNotCompleteErrorMessageDisplayed();
        Assert.assertTrue(isTooltipDisplayed, "Password field tooltip 'value is too short' is not displayed.");
    }

}
