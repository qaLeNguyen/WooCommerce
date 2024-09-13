package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.CreateAnAccountLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateAnAccountPage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(CreateAnAccountPage.class);

    public CreateAnAccountPage() {
        super();
    }

    @Step("Input email address into 'Your email' field")
    public void inputEmail(String email) {
        try {
            input(CreateAnAccountLocator.FIELD_INPUT_EMAIL.getBy(), email);
            logger.info("Inputted email '{}'", email);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input email");
        }
    }

    @Step("Click the button 'Continue with email'")
    public void clickButtonContinueWithEmail() {
        try {
            click(CreateAnAccountLocator.BUTTON_CONTINUE_WITH_EMAIL.getBy());
            logger.info("Clicked button 'Continue with email'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click button 'Continue with email'");
        }
    }

}
