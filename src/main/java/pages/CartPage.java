package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.CartPageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(CartPage.class);

    public CartPage() {
        super();
    }

    @Step("Click the button 'Proceed to checkout'")
    public void clickButtonProceedToCheckout() {
        try {
            click(CartPageLocator.BUTTON_PROCEED_TO_CHECKOUT.getBy());
            logger.info("Clicked the button 'Proceed to checkout'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'Proceed to checkout'");
        }
    }

    @Step("Click the expand button 'Add a coupon'")
    public void clickButtonExpandToAddACoupon() {
        try {
            click(CartPageLocator.BUTTON_EXPAND_TO_ADD_A_COUPON.getBy());
            logger.info("Clicked the expand button 'Add a coupon'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the expand button 'Add a coupon'");
        }
    }

    @Step("Input coupon")
    public void inputCoupon(String coupon) {
        try {
            input(CartPageLocator.FIELD_INPUT_COUPON.getBy(), coupon);
            logger.info("Inputted coupon '{}'", coupon);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to input coupon");
        }
    }

    @Step("Click the button 'Apply' to add a coupon")
    public void clickButtonApplyToAddACoupon() {
        try {
            click(CartPageLocator.BUTTON_APPLY_COUPON.getBy());
            logger.info("Clicked the button 'Apply'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'Apply'");
        }
    }

    @Step("Click the button to plus quantity")
    public void clickButtonPlusQuantity() {
        try {
            click(CartPageLocator.BUTTON_PLUS_QUANTITY.getBy());
            logger.info("Clicked plus button");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the plus button");
        }
    }

    @Step("Click the button to minus quantity")
    public void clickButtonMinusQuantity() {
        try {
            click(CartPageLocator.BUTTON_MINUS_QUANTITY.getBy());
            logger.info("Clicked minus button");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the minus button");
        }
    }

    @Step("From 'Cart' page, browse to 'Category' page ")
    public void browseToCategoryPage() {
        try {
            click(CartPageLocator.BUTTON_BACK.getBy());
            logger.info("Clicked the button 'Back'");

            hoverOver(CartPageLocator.MENU_BUTTON_EXTENSIONS.getBy());
            logger.info("Hovered over 'Extensions'");

            click(CartPageLocator.ITEM_ALL_EXTENSIONS.getBy());
            logger.info("Clicked 'All extensions'");

        } catch (Exception e) {
            logger.error("Exception occurred. Failed to navigate to 'Category' page");
        }
    }

}
