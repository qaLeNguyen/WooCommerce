package integration;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.DataProviderService;

public class TestLoginPage extends IntegrationTestBase{

    public TestLoginPage() {
        super();
    }

    /**
     * @Step 1. Access to homepage url (Integration TestBase)
     * @Step 2. Click the button 'Create an account'. Verify 'Create an account' page title is displayed
     * @Step 3. Input email address into 'Your email' field
     * @Step 4. Click the button 'Continue with email'. Verify that the page title is correctly displayed upon successful registration and login
     * @Step 5. Click to icon 'Account'. Verify email is displayed properly
     * @Step 6. Click the button 'Log Out'. Verify 'Home page' title is displayed
     * @Step 7. Click the button 'Log In'. Verify text 'Log in to your account' is displayed
     * @Step 8. Click the button 'Continue as'. Verify that the page title is correctly displayed upon successful login
     *
     * @param email Using to register an account
     */
    @Description("Test Case: Re-login with registered email successfully")
    @Test(dataProvider = "Valid Email And ReLogin", dataProviderClass = DataProviderService.class)
    public void reLoginWithRegisterEmail(String email) {
        homePage.clickButtonCreateAnAccount();
        verify.isCreateAnAccountTitlePresent();

        createAnAccountPage.inputEmail(email);
        createAnAccountPage.clickButtonContinueWithEmail();
        verify.isLoggedInAfterRegisterTitlePresent();

        homePage.clickIconAccount();
        verify.isLoggedInEmailPresent(email);

        homePage.clickButtonLogOut();
        verify.isHomePageTitlePresent();

        homePage.clickButtonLogin();
        verify.isTextLogInToYourAccountPresent();

        loginPage.clickButtonContinueAs(email);
        verify.isLoggedInTitlePresent();
    }

}
