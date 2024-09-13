package objects;

import org.openqa.selenium.By;

public enum CreateAnAccountLocator {

    FIELD_INPUT_EMAIL(Type.ID, "signup-email"),
    BUTTON_CONTINUE_WITH_EMAIL(Type.CSS, ".is-primary"),
    ERROR_REQUIRE_VALID_EMAIL(Type.XPATH, "//span[.='Please provide a valid email address.']"),
    ;

    private final Type type;
    private final String locatorString;

    CreateAnAccountLocator(Type type, String value) {
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
