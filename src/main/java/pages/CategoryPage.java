package pages;

import common.ActionBase;
import io.qameta.allure.Step;
import objects.CategoryPageLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;


public class CategoryPage extends ActionBase {
    private static final Logger logger = LogManager.getLogger(CategoryPage.class);

    public CategoryPage() {
        super();
    }

    public Wait<WebDriver> createFluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    @Step("Search product")
    public void searchProduct(String productName) {
        try {
            input(CategoryPageLocator.FIELD_SEARCH.getBy(), productName);
            logger.info("Inputted '{}' into search field", productName);

            click(CategoryPageLocator.BUTTON_SEARCH.getBy());
            logger.info("Clicked the button search");

        } catch (Exception e) {
            logger.error("Exception occurred. Failed to search product");
        }
    }

    @Step("Select product")
    public void selectSearchedProduct(String productName) {
        try {
            click(CategoryPageLocator.DISPLAYED_PRODUCT.getBy(productName));
            logger.info("Selected the product '{}'", productName);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to select product");
        }
    }

    @Step("Click the menu cart")
    public void clickMenuCart() {
        try {
            click(CategoryPageLocator.MENU_CART.getBy());
            logger.info("Clicked menu cart");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click the menu cart");
        }
    }

    @Step("Sort by 'Category'")
    public void sortByCategory(String category) {
        try {
            scrollToCenterOfElement(CategoryPageLocator.FILTER_CATEGORY.getBy(category));
            click(CategoryPageLocator.FILTER_CATEGORY.getBy(category));
            logger.info("Clicked Category '{}'", category);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click 'Category'");
        }
    }

    @Step("Sort by range of 'Price'")
    public void sortByRangePrice(String rangePrice) {
        try {
            getElementClickable(CategoryPageLocator.FILTER_PRICE.getBy(rangePrice));
            scrollToCenterOfElement(CategoryPageLocator.FILTER_PRICE.getBy(rangePrice));
            click(CategoryPageLocator.FILTER_PRICE.getBy(rangePrice));
            logger.info("Clicked Price '{}'", rangePrice);
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click 'Price'");
        }
    }

    @Step("Sort by free 'Price'")
    public void sortByFreePrice(String freePrice) {
        try {
            scrollToCenterOfElement(CategoryPageLocator.FILTER_PRICE.getBy(freePrice));
            click(CategoryPageLocator.FILTER_PRICE.getBy(freePrice));
            logger.info("Clicked 'Free' Price");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click 'Free' Price");
        }
    }

    @Step("Check if the next page button is available")
    public boolean isNextButtonAvailable() {
        try {
            WebElement nextButton = driver.findElement
                    (CategoryPageLocator.BUTTON_NEXT_PAGINATION.getBy());

            boolean isDisplayed = nextButton.isDisplayed();
            boolean isEnabled = nextButton.isEnabled();

            return isDisplayed && isEnabled;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Go to next page")
    public void navigateToNextPage() {
        try {
            scrollToCenterOfElement(CategoryPageLocator.BUTTON_NEXT_PAGINATION.getBy());
            WebElement nextButton = driver.findElement
                    (CategoryPageLocator.BUTTON_NEXT_PAGINATION.getBy());
            nextButton.click();

            logger.info("Clicked next button");
        } catch (Exception e) {
            logger.error("Exception occurred. Failed to click next button");
        }
    }

    @Step("Wait for Price to update")
    public void waitForPriceToUpdate() {
        Wait<WebDriver> fluentWait = createFluentWait();
        try {
            fluentWait.until(driver -> {
                List<WebElement> annuallyPrice = driver.findElements(CategoryPageLocator.PRICE_ANNUALLY.getBy());
                return annuallyPrice.size() > 3;
            });
        } catch (TimeoutException e) {
            logger.error("Timeout while waiting for price to update: ", e);
        } catch (Exception e) {
            logger.error("Exception occurred while waiting for price to update: ", e);
        }
    }

    @Step("Scroll to the top of 'Category' page")
    public void scrollToTopOfCategoryPage() {
        scrollToTop();
    }

    public void scrollDownGradually() {
        scrollByAmount(350);
    }

    @Step("")
    public void scrollToFirstProductOfPage() {
        scrollToCenterOfElement(CategoryPageLocator.PRICE_OF_FIRST_PRODUCT.getBy());
    }

    @Step("Check all the product's price on current view is in range")
    public boolean checkPriceInRangeOnCurrentView(int beginPrice, int endPrice) {
        List<WebElement> priceElements = driver.findElements(CategoryPageLocator.PRICE_OF_PRODUCT.getBy());
        List<WebElement> productNames = driver.findElements(CategoryPageLocator.NAME_OF_PRODUCT.getBy());

        logger.info("Page loaded with '{}' products.", priceElements.size());

        boolean allPricesInRange = true;

        for (int i = 0; i < priceElements.size(); i++) {
            WebElement priceElement = priceElements.get(i);
            WebElement productNameElement = productNames.get(i);

            String priceText = priceElement.getText().replaceAll("[$]", "").trim();
            String productName = productNameElement.getText();

            try {
                double price = Double.parseDouble(priceText);

                if (price < beginPrice || price > endPrice) {
                    allPricesInRange = false;
                    logger.error("Product '{}' with price '{}' is out of range '{} - {}'",
                            productName, price, beginPrice, endPrice);
                }
            } catch (NumberFormatException e) {
                allPricesInRange = false;
                logger.error("Failed to parse price '{}' for product '{}'. Skipping product.", priceText, productName);
            }
        }

        return allPricesInRange;
    }

    @Step("Get the count of products currently loaded on the page")
    public int getProductCount() {
        List<WebElement> foundProducts = driver.findElements(CategoryPageLocator.PRICE_ANNUALLY.getBy());
        return foundProducts.size();
    }

    @Step("Check if the required number of products are loaded")
    public boolean checkProductUpdate() {
        int requiredProductCount = 24;
        int currentProductCount = getProductCount();
        By productLocator = CategoryPageLocator.PRICE_OF_PRODUCT.getBy();

        int attempts = 0;
        int maxAttempts = 2;

        try {
            do {
                waitForThePageLoad();

                logger.info("Current product count: {}", currentProductCount);

                scrollDownGradually();

                try {
                    Wait<WebDriver> fluentWait = createFluentWait();
                    List<WebElement> updatedProducts = fluentWait.until(
                            ExpectedConditions.numberOfElementsToBeMoreThan(productLocator, currentProductCount)
                    );

                    int newProductCount = updatedProducts.size();
                    logger.info("Updated product count after scrolling: {}", newProductCount);

                    if (newProductCount > currentProductCount) {
                        currentProductCount = newProductCount;
                        attempts = 0;
                    } else {
                        attempts++;
                    }

                } catch (TimeoutException e) {
                    logger.warn("Timeout while waiting for new products, attempting next scroll");
                    attempts++;
                }

                if (currentProductCount >= requiredProductCount) {
                    logger.info("Required product count reached: {}", currentProductCount);
                    return true;
                }

            } while (attempts < maxAttempts);

            if (currentProductCount > 0) {
                logger.info("Loaded {} products, which is fewer than the required count but valid.", currentProductCount);
                return true;
            } else {
                logger.warn("No products found after scrolling.");
                return false;
            }

        } catch (Exception e) {
            logger.error("An unexpected error occurred while loading products", e);
            return false;
        }
    }

    @Step("Scroll down and check if the product's price is valid")
    public void scrollDownAndCheckPriceOfProduct(int minPrice, int maxPrice) {
        boolean moreProductsLoad = true;

        int maxAttempts = 2;
        int attempts = 0;

        while (moreProductsLoad && attempts < maxAttempts) {
            checkPriceInRangeOnCurrentView(minPrice, maxPrice);

            if (checkProductUpdate()) {
                logger.info("Scrolling to see new products...");
            } else {
                logger.info("No new products found or the required product count has been reached.");
                moreProductsLoad = false;
            }
            attempts++;
        }

        if (attempts == maxAttempts) {
            logger.warn("Reached the maximum number of attempts without finding enough products.");
        } else {
            logger.info("Finished loading and checking product prices.");
        }
    }

    @Step("Scroll through all pages and check product prices in range")
    public void scrollDownInAllPagesAndCheckPrice(int minPrice, int maxPrice) {
        boolean moreProductsLoad = true;
        int pageAttempts = 0;

        while (moreProductsLoad) {
            logger.info("Checking page {} for product prices...", pageAttempts + 1);
            scrollToTop();
            waitForThePageLoad();
            scrollDownAndCheckPriceOfProduct(minPrice, maxPrice);

            if (!isNextButtonAvailable()) {
                logger.info("No more pages available or required products have been found.");
                moreProductsLoad = false;
            }

            else {
                navigateToNextPage();
                pageAttempts++;
                logger.info("Navigated to page {}.", pageAttempts + 1);
            }
        }

        logger.info("Finished checking product prices across all pages.");
    }

    @Step("Wait for the page to load completely")
    public boolean waitForThePageLoad() {
        try {
            Wait<WebDriver> fluentWait = createFluentWait();
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                    (CategoryPageLocator.PRICE_OF_PRODUCT.getBy()));
            return true;
        } catch (TimeoutException e) {
            logger.warn("Page did not load within the expected time.");
            return false;
        }
    }








}




