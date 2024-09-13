package objects;

import org.openqa.selenium.By;

public enum HomePageLocator {

    BUTTON_CREATE_AN_ACCOUNT(Type.ID,"menuItemSignupButton"),
    BUTTON_LOG_IN(Type.CSS,".header-menu-login"),
    BUTTON_LOG_OUT_DEFAULT(Type.XPATH, "//span[.='Log Out']"),
    BUTTON_CONFIRM_CHANGE_LANGUAGE(Type.XPATH, "//button[@class='wccom-button is-style-primary']/div[@class='wccom-button__text']"),
    ICON_SEARCH(Type.XPATH,"//div[@class='wccom-comp-header-search']/button[@class='wccom-header-search__search-button']"),
    ICON_ACCOUNT(Type.ID,"wccom-user"),
    LOGGED_IN_EMAIL(Type.XPATH,"//div[contains(text(), '{text}')]"),
    MENU_BUTTON_SELL(Type.XPATH,"//nav[@class='wccom-main-menu']//button[@class='wccom-main-menu-item with-10-description-items is-top-level with-items with-description-children']/span[@class='wccom-main-menu-item__title']"),
    MENU_BUTTON_EXTENSIONS(Type.CSS,".wccom-main-menu .with-5-description-items > .wccom-main-menu-item__title"),
    MENU_BUTTON_RESOURCES(Type.XPATH,"//nav[@class='wccom-main-menu']//button[@class='wccom-main-menu-item with-7-description-items is-top-level has-fake-children with-items is-selected with-ad with-description-children with-other-children with-children-submenu with-open-children']/span[@class='wccom-main-menu-item__title']"),
    MENU_LANGUAGE(Type.XPATH,"//div[@class='wccom-user-preference-switcher wccom-header-menu-top__language']//div[@class='wccom-button__text']"),
    MENU_CURRENCY(Type.XPATH,"//div[@class='wccom-user-preference-switcher wccom-header-menu-top__currency']//div[@class='wccom-button__text']"),
    ITEM_LANGUAGE(Type.XPATH,"//div[@class='wccom-menu-preferences']//div[.='{text}']"),
    ITEM_CURRENCY(Type.XPATH,"//div[@class='wccom-menu-preferences']//div[.='{text}']"),
    ITEM_ALL_EXTENSIONS(Type.XPATH,"//nav[@class='wccom-main-menu']//div[.='All extensions']//span[@class='wccom-main-menu-item__title']"),

    BUTTON_CREATE_AN_ACCOUNT_LANGUAGE(Type.XPATH,"//a[@id='menuItemSignupButton' and contains(text(), '{text}')]"),
    BUTTON_LOGIN_LANGUAGE(Type.XPATH,"//div[@id='wccom-user']/a[.='{text}']"),
    HOW_WOO_HELP_YOU(Type.XPATH,"//h2[@id='h-how-can-woo-help-you' and contains(text(), '{text}')]"),
    GET_EXPERT_HELP(Type.XPATH,"//h2[@id='h-get-expert-helpwith-woocommerce' and contains(text(), '{text}')]"),
    SOLUTIONS(Type.XPATH,"//h2[@id='h-custom-solutionsfor-high-volume-stores' and contains(text(), '{text}')]"),
    LOVE_BY_MILLIONS_OF_BRANDS(Type.XPATH,"//h2[@id='h-loved-by-millions-of-brands' and contains(text(), '{text}')]"),
    POWER_UP_WOO_STORE(Type.XPATH,"//h2[@id='h-power-up-yourwoocommerce-store' and contains(text(), '{text}')]"),
    TRUST_ECOMMERCE_PLATFORM(Type.XPATH,"//h2[@id='h-the-most-trusted-ecommerce-platform-for-building-success' and contains(text(), '{text}')]"),
    FOOTER_CONTEXT(Type.XPATH,"//div[@id='social-legal']//strong[.='{text}']"),

    ;

    private final Type type;
    private final String locatorString;

    HomePageLocator(Type type, String value) {
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
