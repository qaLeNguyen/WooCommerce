package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.CheckoutPageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutPage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);

    public CheckoutPage() {
        super();
    }

    @Step("Input 'email'")
    public void inputEmail(String email) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_EMAIL_ADDRESS.getBy(), email);
            logger.info("Inputted 'email' '{}'",email);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'email'");

        }
    }

    @Step("Input 'confirm email'")
    public void inputConfirmEmail(String confirmEmail) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_CONFIRM_EMAIL.getBy(), confirmEmail);
            logger.info("Inputted 'confirm email' '{}'",confirmEmail);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'confirm email'");

        }
    }

    @Step("Input 'first name'")
    public void inputFirstName(String firstName) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_FIRST_NAME.getBy(), firstName);
            logger.info("Inputted 'first name' '{}'",firstName);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'first name'");

        }
    }

    @Step("Input 'last name'")
    public void inputLastName(String lastName) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_LAST_NAME.getBy(), lastName);
            logger.info("Inputted 'last name' '{}'",lastName);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'last name'");
        }
    }

    @Step("Input 'address1'")
    public void inputAddress1(String address1) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_ADDRESS1.getBy(), address1);
            logger.info("Inputted 'address1' '{}'",address1);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'address1'");

        }
    }

    @Step("Input 'city'")
    public void inputCity(String city) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_CITY.getBy(), city);
            logger.info("Inputted 'city' '{}'",city);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'city'");

        }
    }

    @Step("Input 'state'")
    public void inputState(String state) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_STATE.getBy(), state);
            logger.info("Inputted 'state' '{}'",state);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'state'");
        }
    }

    @Step("Input 'post code'")
    public void inputPostCode(String postCode) {
        try {
            input(CheckoutPageLocator.FIELD_INPUT_POSTCODE.getBy(), postCode);
            logger.info("Inputted 'post code' '{}'",postCode);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input 'post code'");
        }
    }

    @Step("Select 'country/region'")
    public void selectCountry(String countryRegion) {
        try {
            click(CheckoutPageLocator.DROPDOWN_COUNTRY_REGION.getBy());
            logger.info("Clicked the dropdown in 'country/region'");

            input(CheckoutPageLocator.FIELD_INPUT_COUNTRY_REGION.getBy(), countryRegion);
            logger.info("Inputted 'country/region' '{}'",countryRegion);

            click(CheckoutPageLocator.ITEM_COUNTRY_REGION.getBy(countryRegion));
            logger.info("Select country '{}' in the dropdown 'country/region'", countryRegion);

        } catch (Exception e) {
            logger.error("Exception occurred. Failed to select country in 'country/region'");
        }
    }

    @Step("Select 'state'")
    public void selectStateInUS(String state) {
        try {
            click(CheckoutPageLocator.DROPDOWN_STATE_US.getBy());
            logger.info("Clicked the dropdown in 'state'");

            input(CheckoutPageLocator.FIELD_INPUT_STATE_US.getBy(), state);
            logger.info("Inputted 'US State' '{}'",state);

            click(CheckoutPageLocator.ITEM_STATE.getBy(state));
            logger.info("Select country '{}' in the dropdown 'state'", state);

        } catch (Exception e) {
            logger.error("Exception occurred. Failed to select State in dropdown 'state'");
        }
    }

    @Step("Select method in the dropdown 'how do you use our products'")
    public void selectMethod(String method) {
        try {
            click(CheckoutPageLocator.DROPDOWN_HOW_DO_YOU_USE_OUR_PRODUCTS.getBy());
            logger.info("Clicked the dropdown 'how do you use our products'");

            clickWithRetry(CheckoutPageLocator.ITEM_HOW_DO_YOU_USE_OUR_PRODUCTS.getBy(method),3);
            logger.info("Select method '{}' in the dropdown 'how do you use our products'", method);

        } catch (Exception e) {
            logger.error("Exception occurred. Failed to select method in the dropdown 'how do you use our products'");
        }
    }

    @Step("Click the button 'pay'")
    public void clickButtonPay() {
        try {
            scrollToTopOfElement(CheckoutPageLocator.BUTTON_PLACE_ORDER.getBy());
            click(CheckoutPageLocator.BUTTON_PLACE_ORDER.getBy());
            logger.info("Clicked the button 'pay'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'pay'");
        }
    }

    @Step("Fill out all required information for Checkout process")
    public void fillOutInformationForCheckout() {
        fillOutInformationForCheckout(null, null, null, null, null, null, null, null, null, null);
    }

    @Step("Fill out all required information for Checkout process")
    public void fillOutInformationForCheckout(String email,
                                              String confirmEmail,
                                              String firstName,
                                              String lastName,
                                              String countryRegion,
                                              String address1,
                                              String city,
                                              String state,
                                              String postCode,
                                              String method) {
        inputEmail(email);
        inputConfirmEmail(confirmEmail);
        inputFirstName(firstName);
        inputLastName(lastName);
        selectCountry(countryRegion);
        inputAddress1(address1);
        inputCity(city);
        inputState(state);
        inputPostCode(postCode);
        selectMethod(method);
        clickButtonPay();
    }

}
