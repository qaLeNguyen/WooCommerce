package integration;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.DataProviderService;

public class TestHomePage extends IntegrationTestBase {

    public TestHomePage() {
        super();
    }

    /**
     * @param language               Language
     * @param buttonCreateAnAccount  Text in the button 'Create an account'
     * @param buttonLogin            Text in the button 'Log in'
     * @param howWooHelpYou          Text in 'How Woo Help You'
     * @param loveByMillionsOfBrands Text in 'Love by Millions of Brands'
     * @param powerUpWooStore        Text in 'Power up Woo Store'
     * @param trustEcommercePlatform Text in 'Trust Ecommerce Platform'
     * @param footer                 footer
     * @Precondition: Registered User. Login successful
     * @TestSteps:
     * @Step 1. Click menu language at the top right
     * @Step 2. Select a language to modify
     * @Step 3. Click the button 'Confirm' to change language
     * @Step 4. Verify the context is displayed in Spanish
     * @Step 5. Click menu language at the top right
     * @Step 6. Change language to English (United States)
     * @Step 7. Click the button 'Log Out'. Verify 'Home page' title is displayed
     */
    @Description("Test Case: Verify that the page is displayed in Spanish")
    @Test(dataProvider = "Spanish", dataProviderClass = DataProviderService.class)
    public void changeToSpanish(String language,
                                String buttonCreateAnAccount,
                                String buttonLogin,
                                String howWooHelpYou,
                                String loveByMillionsOfBrands,
                                String powerUpWooStore,
                                String trustEcommercePlatform,
                                String footer) {

        homePage.clickMenuLanguage();
        homePage.selectLanguage(language);
        homePage.clickButtonConfirmToChangeLanguage();
        verify.isContextChangeToSpanish(buttonCreateAnAccount, buttonLogin,
                howWooHelpYou, loveByMillionsOfBrands,
                powerUpWooStore, trustEcommercePlatform, footer);
        homePage.clickMenuLanguage();
        homePage.selectLanguage("English (United States)");
        homePage.clickButtonConfirmToChangeLanguage();
        verify.isHomePageTitlePresent();
    }

    /**
     * @param language               Language
     * @param buttonCreateAnAccount  Text in the button 'Create an account'
     * @param buttonLogin            Text in the button 'Log in'
     * @param loveByMillionsOfBrands Text in 'Love by Millions of Brands'
     * @param getExpertHelp          Text in 'Get expert help'
     * @param powerUpWooStore        Text in 'Power up Woo Store'
     * @param solutions              Text in 'Solutions'
     * @param footer                 footer
     * @Precondition: Registered User. Login successful
     *
     * @TestSteps:
     * @Step 1. Click menu language at the top right
     * @Step 2. Select a language to modify
     * @Step 3. Click the button 'Confirm' to change language
     * @Step 4. Verify the context is displayed in Spanish
     * @Step 5. Click menu language at the top right
     * @Step 6. Change language to English (United States)
     * @Step 7. Click the button 'Log Out'. Verify 'Home page' title is displayed
     */
    @Description("Test Case: Verify that the page is displayed in French")
    @Test(dataProvider = "French", dataProviderClass = DataProviderService.class)
    public void changeToFrench(String language,
                               String buttonCreateAnAccount,
                               String buttonLogin,
                               String loveByMillionsOfBrands,
                               String getExpertHelp,
                               String powerUpWooStore,
                               String solutions,
                               String footer) {

        homePage.clickMenuLanguage();
        homePage.selectLanguage(language);
        homePage.clickButtonConfirmToChangeLanguage();
        verify.isContextChangeToFrench(buttonCreateAnAccount, buttonLogin,
                loveByMillionsOfBrands, getExpertHelp,
                powerUpWooStore, solutions, footer);
        homePage.clickMenuLanguage();
        homePage.selectLanguage("English (United States)");
        homePage.clickButtonConfirmToChangeLanguage();
        verify.isHomePageTitlePresent();

    }

    /**
     * @param language               Language
     * @param buttonCreateAnAccount  Text in the button 'Create an account'
     * @param buttonLogin            Text in the button 'Log in'
     * @param loveByMillionsOfBrands Text in 'Love by Millions of Brands'
     * @param getExpertHelp          Text in 'Get expert help'
     * @param powerUpWooStore        Text in 'Power up Woo Store'
     * @param solutions              Text in 'Solutions'
     * @param footer                 footer
     * @Precondition: Registered User. Login successful
     * @TestSteps:
     * @Step 1. Click menu language at the top right
     * @Step 2. Select a language to modify
     * @Step 3. Click the button 'Confirm' to change language
     * @Step 4. Verify the context is displayed in Spanish
     * @Step 5. Click menu language at the top right
     * @Step 6. Change language to English (United States)
     * @Step 7. Click the button 'Log Out'. Verify 'Home page' title is displayed
     */
    @Description("Test Case: Verify that the page is displayed in Portuguese")
    @Test(dataProvider = "Portuguese", dataProviderClass = DataProviderService.class)
    public void changeToPortuguese(String language,
                                   String buttonCreateAnAccount,
                                   String buttonLogin,
                                   String loveByMillionsOfBrands,
                                   String getExpertHelp,
                                   String powerUpWooStore,
                                   String solutions,
                                   String footer) {

        homePage.clickMenuLanguage();
        homePage.selectLanguage(language);
        homePage.clickButtonConfirmToChangeLanguage();
        verify.isContextChangeToPortuguese(buttonCreateAnAccount, buttonLogin,
                loveByMillionsOfBrands, getExpertHelp,
                powerUpWooStore, solutions, footer);
        homePage.clickMenuLanguage();
        homePage.selectLanguage("English (United States)");
        homePage.clickButtonConfirmToChangeLanguage();
        verify.isHomePageTitlePresent();

    }

}
