package verification;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Verify extends ActionBase {
    private static final Logger logger = LogManager.getLogger(Verify.class);

    public Verify() {
        super();
    }

    @Step("Verify 'Cart' page title is displayed")
    public void isCartTitlePresent() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Cart - WooCommerce",
                "The page title is not displayed");
        logger.info("'Cart - WooCommerce' is displayed");
    }

    @Step("Verify 'Category' page title is displayed") // the title of this page is Extensions
    public void isCategoryTitlePresent() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "WooCommerce extensions - WooCommerce",
                "The page title is not displayed");
        logger.info("'WooCommerce extensions - WooCommerce' is displayed");
    }

    @Step("Verify 'Checkout' page title is displayed")
    public void isCheckoutTitlePresent() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Checkout - WooCommerce",
                "The page title is not displayed");
        logger.info("'Checkout - WooCommerce' is displayed");
    }

    @Step("Verify 'Create an account' page title is displayed")
    public void isCreateAnAccountTitlePresent() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Create a site — WordPress.com",
                "The page title is not displayed");
        logger.info("'Create a site — WordPress.com' is displayed");
    }

    @Step("Verify 'Home page' title is displayed")
    public void isHomePageTitlePresent() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "WooCommerce",
                "The page title is not displayed");
        logger.info("WooCommerce' title is displayed");
    }

    @Step("Verify that the page title is correctly displayed upon successful registration and login")
    public void isLoggedInAfterRegisterTitlePresent() {
        wait.until(ExpectedConditions.titleIs("What is WooCommerce? - WooCommerce"));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "What is WooCommerce? - WooCommerce",
                "The page title is not displayed");
        logger.info("'What is WooCommerce? - WooCommerce' title is displayed");
    }

    @Step("Verify that the product's page title is displayed")
    public void isProductPageTitlePresent(String productName) {
        wait.until(ExpectedConditions.titleIs(productName + " - WooCommerce Marketplace"));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, productName+ " - WooCommerce Marketplace",
                "The page title is not displayed");
        logger.info("'{}' title is displayed", productName);
    }

    @Step("Verify that the page title is correctly displayed upon successful login")
    public void isLoggedInTitlePresent() {
        wait.until(ExpectedConditions.titleIs("Dashboard - WooCommerce"));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Dashboard - WooCommerce",
                "The page title is not displayed");
        logger.info("'Dashboard - WooCommerce' title is displayed");
    }

    @Step("Verify email is displayed")
    public void isLoggedInEmailPresent(String email) {
        boolean isLoggedInEmail = isElementPresent(HomePageLocator.LOGGED_IN_EMAIL.getBy(email));
        Assert.assertTrue(isLoggedInEmail,
                "The logged in email is not displayed");
        logger.info("Logged in email '{}' is displayed", email);
    }

    @Step("Verify error message 'Please provide a valid email address.' is displayed")
    public void isErrorMsgRequireValidEmailPresent() {
        boolean isErrorMsgRequireValidEmail = isElementPresent(CreateAnAccountLocator.ERROR_REQUIRE_VALID_EMAIL.getBy());
        Assert.assertTrue(isErrorMsgRequireValidEmail,
                "The error message 'Please provide a valid email address.' is not displayed");
        logger.info("The error message 'Please provide a valid email address.' is displayed");
    }

    @Step("Verify error message 'This email address is already associated with an account' is displayed")
    public void isErrorMsgEmailAlreadyExistsPresent() {
        boolean isErrorMsgEmailAlreadyExists = isElementPresent(LoginPageLocator.ERROR_EMAIL_ALREADY_EXISTS.getBy());
        Assert.assertTrue(isErrorMsgEmailAlreadyExists,
                "The error message 'This email address is already associated with an account' is not displayed");
        logger.info("The error message 'This email address is already associated with an account' is displayed");
    }

    @Step("Verify text 'Log in to your account' is displayed")
    public void isTextLogInToYourAccountPresent() {
        getElementVisible(LoginPageLocator.TEXT_LOG_IN_TO_YOUR_ACCOUNT.getBy());
        boolean isTextLogInToYourAccount = isElementPresent(LoginPageLocator.TEXT_LOG_IN_TO_YOUR_ACCOUNT.getBy());
        Assert.assertTrue(isTextLogInToYourAccount,
                "The text 'Log in to your account' is not displayed");
        logger.info("The text 'Log in to your account' is displayed");
    }

    @Step("Verify the context is displayed in Spanish")
    public void isContextChangeToSpanish(String buttonCreateAnAccount,
                                         String buttonLogin,
                                         String howWooHelpYou,
                                         String loveByMillionsOfBrands,
                                         String powerUpWooStore,
                                         String trustEcommercePlatform,
                                         String footer) {
        scrollToCenterOfElement(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT_LANGUAGE.getBy(buttonCreateAnAccount));
        boolean isButtonCreateAnAccount = isElementPresent(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT_LANGUAGE.getBy(buttonCreateAnAccount));
        Assert.assertTrue(isButtonCreateAnAccount, "The button 'Create an account' is not displayed in Spanish");
        logger.info("The button 'Create an account' is displayed in Spanish");

        scrollToCenterOfElement(HomePageLocator.BUTTON_LOGIN_LANGUAGE.getBy(buttonLogin));
        boolean isButtonLogin = isElementPresent(HomePageLocator.BUTTON_LOGIN_LANGUAGE.getBy(buttonLogin));
        Assert.assertTrue(isButtonLogin, "The button 'Log in' is not displayed in Spanish");
        logger.info("The button 'Log in' is displayed in Spanish");

        scrollToCenterOfElement(HomePageLocator.HOW_WOO_HELP_YOU.getBy(howWooHelpYou));
        boolean isHowWooHelpYou = isElementPresent(HomePageLocator.HOW_WOO_HELP_YOU.getBy(howWooHelpYou));
        Assert.assertTrue(isHowWooHelpYou, "'How Woo help you' is not displayed in Spanish");
        logger.info("'How Woo help you' is displayed in Spanish");

        scrollToCenterOfElement(HomePageLocator.LOVE_BY_MILLIONS_OF_BRANDS.getBy(loveByMillionsOfBrands));
        boolean isLoveByMillionsOfBrands = isElementPresent(HomePageLocator.LOVE_BY_MILLIONS_OF_BRANDS.getBy(loveByMillionsOfBrands));
        Assert.assertTrue(isLoveByMillionsOfBrands, "'Love by millions of brands' is not displayed in Spanish");
        logger.info("'Love by millions of brands' is displayed in Spanish");

        scrollToCenterOfElement(HomePageLocator.POWER_UP_WOO_STORE.getBy(powerUpWooStore));
        boolean isPowerUpWooStore = isElementPresent(HomePageLocator.POWER_UP_WOO_STORE.getBy(powerUpWooStore));
        Assert.assertTrue(isPowerUpWooStore, "'Power up Woo store' is not displayed in Spanish");
        logger.info("'Power up Woo store' is displayed in Spanish");

        scrollToCenterOfElement(HomePageLocator.TRUST_ECOMMERCE_PLATFORM.getBy(trustEcommercePlatform));
        boolean isTrustEcommercePlatform = isElementPresent(HomePageLocator.TRUST_ECOMMERCE_PLATFORM.getBy(trustEcommercePlatform));
        Assert.assertTrue(isTrustEcommercePlatform, "'Trust Ecommerce platform' is not displayed in Spanish");
        logger.info("'Trust Ecommerce platform' is displayed in Spanish");

        scrollToCenterOfElement(HomePageLocator.FOOTER_CONTEXT.getBy(footer));
        boolean isFooter = isElementPresent(HomePageLocator.FOOTER_CONTEXT.getBy(footer));
        Assert.assertTrue(isFooter, "The footer is not displayed in Spanish");
        logger.info("The footer is displayed in Spanish");
    }

    @Step("Verify the context is displayed in French")
    public void isContextChangeToFrench(String buttonCreateAnAccount,
                                        String buttonLogin,
                                        String loveByMillionsOfBrands,
                                        String getExpertHelp,
                                        String powerUpWooStore,
                                        String solutions,
                                        String footer) {
        scrollToCenterOfElement(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT_LANGUAGE.getBy(buttonCreateAnAccount));
        boolean isButtonCreateAnAccount = isElementPresent(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT_LANGUAGE.getBy(buttonCreateAnAccount));
        Assert.assertTrue(isButtonCreateAnAccount, "The button 'Create an account' is not displayed in French");
        logger.info("The button 'Create an account' is displayed in French");

        scrollToCenterOfElement(HomePageLocator.BUTTON_LOGIN_LANGUAGE.getBy(buttonLogin));
        boolean isButtonLogin = isElementPresent(HomePageLocator.BUTTON_LOGIN_LANGUAGE.getBy(buttonLogin));
        Assert.assertTrue(isButtonLogin, "The button 'Log in' is not displayed in French");
        logger.info("The button 'Log in' is displayed in French");

        scrollToCenterOfElement(HomePageLocator.LOVE_BY_MILLIONS_OF_BRANDS.getBy(loveByMillionsOfBrands));
        boolean isShoppingIcon = isElementPresent(HomePageLocator.LOVE_BY_MILLIONS_OF_BRANDS.getBy(loveByMillionsOfBrands));
        Assert.assertTrue(isShoppingIcon, "'Love by millions of brands' is not displayed in French");
        logger.info("'Love by millions of brands' is displayed in French");

        scrollToCenterOfElement(HomePageLocator.GET_EXPERT_HELP.getBy(getExpertHelp));
        boolean isGetExpertHelp = isElementPresent(HomePageLocator.GET_EXPERT_HELP.getBy(getExpertHelp));
        Assert.assertTrue(isGetExpertHelp, "'Get helper help' is not displayed in French");
        logger.info("'Get helper help' is displayed in French");

        scrollToCenterOfElement(HomePageLocator.POWER_UP_WOO_STORE.getBy(powerUpWooStore));
        boolean isPowerUpWooStore = isElementPresent(HomePageLocator.POWER_UP_WOO_STORE.getBy(powerUpWooStore));
        Assert.assertTrue(isPowerUpWooStore, "'Power up Woo store' is not displayed in French");
        logger.info("'Power up Woo store' is displayed in French");

        scrollToCenterOfElement(HomePageLocator.SOLUTIONS.getBy(solutions));
        boolean isSolutions = isElementPresent(HomePageLocator.SOLUTIONS.getBy(solutions));
        Assert.assertTrue(isSolutions, "'Solutions' is not displayed in French");
        logger.info("'Solutions' is displayed in French");

        scrollToCenterOfElement(HomePageLocator.FOOTER_CONTEXT.getBy(footer));
        boolean isFooter = isElementPresent(HomePageLocator.FOOTER_CONTEXT.getBy(footer));
        Assert.assertTrue(isFooter, "The footer is not displayed in French");
        logger.info("The footer is displayed in French");
    }

    @Step("Verify the context is displayed in Portuguese")
    public void isContextChangeToPortuguese(String buttonCreateAnAccount,
                                            String buttonLogin,
                                            String loveByMillionsOfBrands,
                                            String getExpertHelp,
                                            String powerUpWooStore,
                                            String solutions,
                                            String footer) {
        scrollToCenterOfElement(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT_LANGUAGE.getBy(buttonCreateAnAccount));
        boolean isButtonCreateAnAccount = isElementPresent(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT_LANGUAGE.getBy(buttonCreateAnAccount));
        Assert.assertTrue(isButtonCreateAnAccount, "The button 'Create an account' is not displayed in Portuguese");
        logger.info("The button 'Create an account' is displayed in Portuguese");

        scrollToCenterOfElement(HomePageLocator.BUTTON_LOGIN_LANGUAGE.getBy(buttonLogin));
        boolean isButtonLogin = isElementPresent(HomePageLocator.BUTTON_LOGIN_LANGUAGE.getBy(buttonLogin));
        Assert.assertTrue(isButtonLogin, "The button 'Log in' is not displayed in Portuguese");
        logger.info("The button 'Log in' is displayed in Portuguese");

        scrollToCenterOfElement(HomePageLocator.LOVE_BY_MILLIONS_OF_BRANDS.getBy(loveByMillionsOfBrands));
        boolean isShoppingIcon = isElementPresent(HomePageLocator.LOVE_BY_MILLIONS_OF_BRANDS.getBy(loveByMillionsOfBrands));
        Assert.assertTrue(isShoppingIcon, "'Love by millions of brands' is not displayed in Portuguese");
        logger.info("'Love by millions of brands' is displayed in Portuguese");

        scrollToCenterOfElement(HomePageLocator.GET_EXPERT_HELP.getBy(getExpertHelp));
        boolean isGetExpertHelp = isElementPresent(HomePageLocator.GET_EXPERT_HELP.getBy(getExpertHelp));
        Assert.assertTrue(isGetExpertHelp, "'Get helper help' is not displayed in Portuguese");
        logger.info("'Get helper help' is displayed in Portuguese");

        scrollToCenterOfElement(HomePageLocator.POWER_UP_WOO_STORE.getBy(powerUpWooStore));
        boolean isPowerUpWooStore = isElementPresent(HomePageLocator.POWER_UP_WOO_STORE.getBy(powerUpWooStore));
        Assert.assertTrue(isPowerUpWooStore, "'Power up Woo store' is not displayed in Portuguese");
        logger.info("'Power up Woo store' is displayed in Portuguese");

        scrollToCenterOfElement(HomePageLocator.SOLUTIONS.getBy(solutions));
        boolean isSolutions = isElementPresent(HomePageLocator.SOLUTIONS.getBy(solutions));
        Assert.assertTrue(isSolutions, "'Solutions' is not displayed in Portuguese");
        logger.info("'Solutions' is displayed in Portuguese");

        scrollToCenterOfElement(HomePageLocator.FOOTER_CONTEXT.getBy(footer));
        boolean isFooter = isElementPresent(HomePageLocator.FOOTER_CONTEXT.getBy(footer));
        Assert.assertTrue(isFooter, "The footer is not displayed in Portuguese");
        logger.info("The footer is displayed in Portuguese");
    }

    @Step("Verify that searched product is displayed")
    public void isSearchedProductDisplayed(String productName) {
        scrollToCenterOfElement(CategoryPageLocator.DISPLAYED_PRODUCT.getBy(productName));
        boolean isSearchedProduct = isElementPresent(CategoryPageLocator.DISPLAYED_PRODUCT.getBy(productName));
        Assert.assertTrue(isSearchedProduct,
                "Searched product cannot be found");
        logger.info("Searched product '{}' is displayed", productName);
    }

    @Step("Verify that product is displayed")
    public void isProductDisplayed(String productName) {
        scrollToCenterOfElement(CartPageLocator.NAME_PRODUCTS_DISPLAYED.getBy(productName));
        boolean isSearchedProduct = isElementPresent(CartPageLocator.NAME_PRODUCTS_DISPLAYED.getBy(productName));
        Assert.assertTrue(isSearchedProduct,
                "Product cannot be found");
        logger.info("Product '{}' is displayed", productName);
    }

    @Step("Verify the text 'Category' is displayed correctly")
    public void isTextCategoryDisplayed(String category) {
        scrollToCenterOfElement(CategoryPageLocator.TEXT_CATEGORY_FILTER.getBy(category));
        boolean isVendor = isElementPresent(CategoryPageLocator.TEXT_CATEGORY_FILTER.getBy(category));
        Assert.assertTrue(isVendor,
                "The extensions found in " + category + " is not correct");
        logger.info("'{} is found", category);
    }



}
