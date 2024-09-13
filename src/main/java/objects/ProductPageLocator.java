package objects;

import org.openqa.selenium.By;

public enum ProductPageLocator {

    BUTTON_ADD_TO_CART(Type.XPATH, "//div[@class='wccom-product-add-to-cart-button']//div[@class='wccom-button__text']"),
    MENU_CART(Type.CSS, ".header-menu-cart"),
    BUTTON_BUY_NOW(Type.XPATH, "//div[@class='wccom-product-add-to-cart-button wccom-product-primary-action-button']/a[.='Buy now']"),
    MENU_BUTTON_EXTENSIONS(Type.CSS,".wccom-main-menu .with-5-description-items > .wccom-main-menu-item__title"),
    ITEM_ALL_EXTENSIONS(Type.XPATH,"//nav[@class='wccom-main-menu']//div[.='All extensions']//span[@class='wccom-main-menu-item__title']"),
    ;

    private final Type type;
    private final String locatorString;

    ProductPageLocator(Type type, String value) {
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
