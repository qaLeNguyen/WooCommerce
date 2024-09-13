package objects;

import org.openqa.selenium.By;

public enum CategoryPageLocator {

    FIELD_SEARCH(Type.ID,"wccom-search__q"),
    BUTTON_SEARCH(Type.CSS,".wccom-search__search-icon"),
    BUTTON_NEXT_PAGINATION(Type.XPATH,"//a[@class='page-numbers next' and @aria-label='Next Page']"),

    DISPLAYED_PRODUCT(Type.XPATH,"//a[contains(text(), '{text}')]"),
    MENU_CART(Type.CSS, ".header-menu-cart"),
    TEXT_CATEGORY_FILTER(Type.XPATH,"//div[@class='search-results__header']//b[contains(text(), '{text}')]"),
    FILTER_CATEGORY(Type.XPATH,"//div[@class='wccom-search-content__product-widgets']//label[.='{text}']"),
    PRICE_OF_PRODUCT(Type.XPATH,"//span[contains(@class, 'wccom-product-card__price')]//span[@aria-hidden='true']"),
    PRICE_OF_FIRST_PRODUCT(Type.CSS,"section:nth-of-type(1) .wccom-product-card__price"),
    FREE_DOWNLOAD_PRODUCT(Type.CLASS_NAME,"wccom-product-card__price"),
    NAME_OF_PRODUCT(Type.CLASS_NAME,"wccom-card__title-link"),
    FILTER_PRICE(Type.XPATH,"//fieldset[@class='wccom-widget wccom-price-widget']//label[contains(text(), '{text}')]"),
    PRICE_ANNUALLY(Type.CLASS_NAME,"wccom-product-card__period"),


    ;
    private final Type type;
    private final String locatorString;

    CategoryPageLocator(Type type, String value) {
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
