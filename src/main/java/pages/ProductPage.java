package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.CartPageLocator;
import objects.ProductPageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ProductPage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        super();
    }

    @Step("Click the button 'Add to cart'")
    public void clickButtonAddToCart() {
        try {
            click(ProductPageLocator.BUTTON_ADD_TO_CART.getBy());
            logger.info("Clicked the button 'Add to cart'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'Add to cart'");
        }
    }

    @Step("Click the menu cart")
    public void clickMenuCart() {
        try {
            click(ProductPageLocator.MENU_CART.getBy());
            logger.info("Clicked menu cart");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the menu cart");
        }
    }

    @Step("Click the button 'Buy now'")
    public void clickButtonBuyNow() {
        try {
            click(ProductPageLocator.BUTTON_BUY_NOW.getBy());
            logger.info("Clicked the button 'Buy now'");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the button 'Buy now'");
        }
    }

    @Step("From 'Product' page, browse to 'Category' page ")
    public void browseToCategoryPage() {
        try {
            hoverOver(ProductPageLocator.MENU_BUTTON_EXTENSIONS.getBy());
            logger.info("Hovered over 'Extensions'");

            click(ProductPageLocator.ITEM_ALL_EXTENSIONS.getBy());
            logger.info("Clicked 'All extensions'");

        } catch (Exception e) {
            logger.error("Exception occurred. Failed to navigate to 'Category' page");
        }
    }

}
