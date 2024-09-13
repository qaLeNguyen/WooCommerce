package verification;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.CategoryPageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Check extends ActionBase {
    private static final Logger logger = LogManager.getLogger(Check.class);

    public Check() {
        super();
    }

    private final By buttonBackPagination = By.cssSelector(".fa-arrow-left");



    @Step("Go to next page")
    public void goToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.cssSelector(".fa-arrow-right"));
            nextButton.click();
            logger.info("Clicked next button");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click next button");
        }
    }

    @Step("Check different vendors")
    public void ifDevelopByVendor(String expectedVendorName) {
        List<WebElement> vendorElements = driver.findElements(By.xpath("//section[6]//div[@class='wccom-card__vendor']//a"));

        for (WebElement vendor : vendorElements) {
            String vendorName = vendor.getText();

            Assert.assertTrue(vendorName.contains(expectedVendorName),
                    "The different vendor {" + vendor.getText() + "} is found");
            logger.info("All vendors '{}' are displayed correctly", expectedVendorName);
        }
    }






    @Step("Check if product is displayed on a specific page")
    public boolean ifProductDisplayedInPage(String productNameDisplayed) {
        List<WebElement> productNames = driver.findElements(CategoryPageLocator.NAME_OF_PRODUCT.getBy());

        for (WebElement eachProductName : productNames) {
            String productName = eachProductName.getText();

            if (productName.equalsIgnoreCase(productNameDisplayed)) {
                logger.info("Product '{}' is displayed on the page", productNameDisplayed);
                return true;
            }
        }
        return false;
    }






}
