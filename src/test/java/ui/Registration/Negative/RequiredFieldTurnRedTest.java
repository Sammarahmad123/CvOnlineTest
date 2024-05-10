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
@Story("CV Online - Negative Flow - Required Field Error Validation")
public class RequiredFieldTurnRedTest extends BaseTest {
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
    public void testRequiredFieldsTurnRedOnRegisterButtonClick() {
        registrationPage.clickRegister();
        String[] fieldTypes = {"email", "password", "firstName", "lastName", "agreeTerms", "agreeGdpr"};
        for (String fieldType : fieldTypes) {
            Assert.assertTrue(registrationPage.isFieldRed(fieldType), fieldType + " field not turned red.");
        }
    }


}
