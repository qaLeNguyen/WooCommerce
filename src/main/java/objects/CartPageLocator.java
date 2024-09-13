package objects;
import org.openqa.selenium.By;

public enum CartPageLocator {

    BUTTON_PROCEED_TO_CHECKOUT(Type.XPATH,"//span[.='Proceed to Checkout']"),
    BUTTON_EXPAND_TO_ADD_A_COUPON(Type.CSS,".wc-block-components-panel__button-icon"),
    BUTTON_APPLY_COUPON(Type.XPATH,"//span[.='Apply']"),
    BUTTON_PLUS_QUANTITY(Type.CSS,".wc-block-components-quantity-selector__button--plus"),
    BUTTON_MINUS_QUANTITY(Type.CSS,".wc-block-components-quantity-selector__button--minus"),
    FIELD_INPUT_COUPON(Type.XPATH,"//div[@class='wc-block-components-text-input wc-block-components-totals-coupon__input']/input[1]"),
    NAME_PRODUCTS_DISPLAYED(Type.XPATH,"//a[.='{text}']"),
    TEXT_MY_CART(Type.CSS,".wccom-cart__page-title"),
    MSG_COUPON_DOES_NOT_WORK(Type.XPATH,"//p[.='This coupon doesn‘t work.']"),
    MENU_BUTTON_EXTENSIONS(Type.CSS,".wccom-main-menu .with-5-description-items > .wccom-main-menu-item__title"),
    ITEM_ALL_EXTENSIONS(Type.XPATH,"//nav[@class='wccom-main-menu']//div[.='All extensions']//span[@class='wccom-main-menu-item__title']"),
    BUTTON_BACK(Type.CSS,".wccom-cart__back-link"),

    ;

    private final Type type;
    private final String locatorString;

    CartPageLocator(Type type, String value) {
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
