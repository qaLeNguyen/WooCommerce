package integration;

import e2e.End2EndTestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.DataProviderService;

public class TestRegistration extends End2EndTestBase {

    public TestRegistration() {
        super();
    }

    /**
     * @Step 1. Access to homepage url (Integration TestBase)
     * @Step 2. Click the button 'Create an account'. Verify 'Create an account' page title is displayed
     * @Step 3. Input email address into 'Your email' field
     * @Step 4. Click the button 'Continue with email'. Verify that the page title is correctly displayed upon successful registration and login
     * @Step 5. Click to icon 'Account'. Verify email is displayed
     *
     * @param email Using to register an account
     */
    @Description("Test Case: Register account successfully with a valid email")
    @Test(dataProvider = "validEmails", dataProviderClass = DataProviderService.class)
    public void registerAccountWithAValidEmail(String email) {
        homePage.clickButtonCreateAnAccount();
        verify.isCreateAnAccountTitlePresent();

        createAnAccountPage.inputEmail(email);
        createAnAccountPage.clickButtonContinueWithEmail();
        verify.isLoggedInAfterRegisterTitlePresent();

        homePage.clickIconAccount();
        verify.isLoggedInEmailPresent(email);
    }

    /**
     * @Step 1. Access to homepage url (Integration TestBase)
     * @Step 2. Click the button 'Create an account'. Verify 'Create an account' page title is displayed
     * @Step 3. Input email address into 'Your email' field
     * @Step 4. Click the button 'Continue with email'. Verify error message 'Please provide a valid email address' is displayed
     *
     * @param email Using to register an account
     */
    @Description("Test Case: Register account with an invalid email")
    @Test(dataProvider = "invalidEmails", dataProviderClass = DataProviderService.class)
    public void registerAccountWithAnInvalidEmail(String email) {
        homePage.clickButtonCreateAnAccount();
        verify.isCreateAnAccountTitlePresent();

        createAnAccountPage.inputEmail(email);
        createAnAccountPage.clickButtonContinueWithEmail();
        verify.isErrorMsgRequireValidEmailPresent();
    }

    /**
     * @Step 1. Access to homepage url (Integration TestBase)
     * @Step 2. Click the button 'Create an account'. Verify 'Create an account' page title is displayed properly
     * @Step 3. Input email address into 'Your email' field
     * @Step 4. Click the button 'Continue with email'. Verify error message
     * 'This email address is already associated with an account' is displayed
     *
     * @param email Using to register an account
     */
    @Description("Test Case: Register account with an registered email")
    @Test(dataProvider = "validEmails", dataProviderClass = DataProviderService.class)
    public void registerAccountWithEmailAlreadyExists(String email) {
        homePage.clickButtonCreateAnAccount();
        verify.isCreateAnAccountTitlePresent();

        createAnAccountPage.inputEmail(email);
        createAnAccountPage.clickButtonContinueWithEmail();
        verify.isErrorMsgEmailAlreadyExistsPresent();
    }


}
