package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.LoginPageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        super();
    }

    @Step("Click the button 'Continue as..'")
    public void clickButtonContinueAs(String email) {
        try {
            scrollToTopOfElement(LoginPageLocator.BUTTON_CONTINUE_AS.getBy(email));
            click(LoginPageLocator.BUTTON_CONTINUE_AS.getBy(email));
            logger.info("Clicked the button 'Continue as..'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'Continue as..'");
        }
    }

    @Step("Input email address into 'Your email or username' field")
    public void inputEmail(String email) {
        try {
            input(LoginPageLocator.FIELD_INPUT_EMAIL_OR_USERNAME.getBy(), email);
            logger.info("Inputted email '{}'", email);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input email '{}'", email);
        }
    }

    @Step("Input username into 'Your email or username' field")
    public void inputUserName(String userName) {
        try {
            input(LoginPageLocator.FIELD_INPUT_EMAIL_OR_USERNAME.getBy(), userName);
            logger.info("Inputted username '{}'", userName);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input username '{}'", userName);
        }
    }



}
