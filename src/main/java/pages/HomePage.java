package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.HomePageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage() {
        super();
    }

    @Step("Click the button 'Create an account'")
    public void clickButtonCreateAnAccount() {
        try {
            click(HomePageLocator.BUTTON_CREATE_AN_ACCOUNT.getBy());
            logger.info("Clicked button 'Create an account'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click button 'Create an account'");
        }
    }

    @Step("Click to button 'Log in'. Navigate to 'Login' page")
    public void clickButtonLogin() {
        try {
            clickWithRetry(HomePageLocator.BUTTON_LOG_IN.getBy(),3);
            logger.info("Clicked button 'Log in'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click button 'Log in'");
        }
    }

    @Step("Click to icon 'Search'")
    public void clickIconSearch() {
        try {
            click(HomePageLocator.ICON_SEARCH.getBy());
            logger.info("Clicked icon 'Search'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click icon 'Search'");
        }
    }

    @Step("Click to icon 'Account'")
    public void clickIconAccount() {
        try {
            click(HomePageLocator.ICON_ACCOUNT.getBy());
            logger.info("Clicked icon 'Account'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click icon 'Account'");
        }
    }

    @Step("Click the button 'Log Out'")
    public void clickButtonLogOut() {
        try {
            scrollToTopOfElement(HomePageLocator.BUTTON_LOG_OUT_DEFAULT.getBy());
            click(HomePageLocator.BUTTON_LOG_OUT_DEFAULT.getBy());
            logger.info("Clicked button 'Log Out'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click button 'Log Out'");
        }
    }

    @Step("Click menu language at the top right")
    public void clickMenuLanguage() {
        try {
            click(HomePageLocator.MENU_LANGUAGE.getBy());
            logger.info("Clicked the menu language");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click menu language");
        }
    }

    @Step("Select a language to modify")
    public void selectLanguage(String language) {
        try {
            click(HomePageLocator.ITEM_LANGUAGE.getBy(language));
            logger.info("Selected language '{}'", language);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to choose language");
        }
    }

    @Step("Click the button 'Confirm' to change language")
    public void clickButtonConfirmToChangeLanguage() {
        try {
            click(HomePageLocator.BUTTON_CONFIRM_CHANGE_LANGUAGE.getBy());
            logger.info("Clicked the button 'Confirm' to change language");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'Confirm'");
        }
    }

    @Step("From 'Homepage' browse to 'Category' page")
    public void browseToCategoryPage() {
        try {
            hoverOver(HomePageLocator.MENU_BUTTON_EXTENSIONS.getBy());
            logger.info("Hovered over 'Extensions'");
            click(HomePageLocator.ITEM_ALL_EXTENSIONS.getBy());
            logger.info("Clicked 'All extensions'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to navigate to 'Category' page");
        }
    }


}
