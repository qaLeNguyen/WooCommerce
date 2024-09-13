package objects;

import org.openqa.selenium.By;

public enum LoginPageLocator {

    ERROR_EMAIL_ALREADY_EXISTS(Type.XPATH, "//span[@class='notice__text' and contains(text(), 'This email address is already associated with an account')]"),
    TEXT_LOG_IN_TO_YOUR_ACCOUNT(Type.XPATH,"//div[@class='login__form-header']//h3[contains(text(), 'Log in to your account.')]"),
    BUTTON_CONTINUE_AS(Type.XPATH,"//a[.='Continue as {text}']"),
    FIELD_INPUT_EMAIL_OR_USERNAME(Type.ID,"usernameOrEmail"),

    ;

    private final Type type;
    private final String locatorString;

    LoginPageLocator(Type type, String value) {
        this.type = type;
        this.locatorString = value;
    }

    public By getBy(String text) {
        return type.buildBy(locatorString.replace("{text}", text));
    }

    public By getBy() {
        return type.buildBy(locatorString);
    }
}
