package objects;

import org.openqa.selenium.By;

public enum CheckoutPageLocator {

    TEXT_YOUR_ORDER(Type.ID,"order_review_heading"),
    TEXT_CONTACT_INFORMATION(Type.XPATH,"//h4[.='Contact information']"),
    TEXT_BILLING_ADDRESS(Type.XPATH,"//h4[.='Billing address']"),
    FIELD_INPUT_EMAIL_ADDRESS(Type.ID,"billing_email"),
    FIELD_INPUT_CONFIRM_EMAIL(Type.ID,"billing_email_confirm"),
    FIELD_INPUT_FIRST_NAME(Type.ID,"billing_first_name"),
    FIELD_INPUT_LAST_NAME(Type.ID,"billing_last_name"),
    FIELD_INPUT_COUNTRY_REGION(Type.CSS,".select2-search__field"),
    FIELD_INPUT_ADDRESS1(Type.CSS,"[placeholder='House number and street name']"),
    FIELD_INPUT_CITY(Type.ID,"billing_city"),
    FIELD_INPUT_STATE(Type.ID,"billing_state"),
    DROPDOWN_STATE_US(Type.ID,"select2-billing_state-container"),
    FIELD_INPUT_STATE_US(Type.CSS,".select2-search__field"),
    ITEM_STATE(Type.XPATH,"//li[.='{text}']"),
    FIELD_INPUT_POSTCODE(Type.ID,"billing_postcode"),
    DROPDOWN_HOW_DO_YOU_USE_OUR_PRODUCTS(Type.ID,"mailchimp-using-products"),
    DROPDOWN_COUNTRY_REGION(Type.ID,"select2-billing_country-container"),
    ITEM_HOW_DO_YOU_USE_OUR_PRODUCTS(Type.XPATH,"//select[@id='mailchimp-using-products']//option[.='{text}']"),
    ITEM_COUNTRY_REGION(Type.XPATH,"//li[.='{text}']"),
    BUTTON_PLACE_ORDER(Type.ID,"place_order"),

    ;

    private final Type type;
    private final String locatorString;

    CheckoutPageLocator(Type type, String value) {
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
