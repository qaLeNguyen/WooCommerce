package e2e;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.DataProviderService;

import java.util.Arrays;
import java.util.List;

public class TestPurchase extends End2EndTestBase {

    public TestPurchase() {
        super();
    }

    /**
     * @param productName   Product that user wants to buy
     * @param email         Required information in Checkout page
     * @param confirmEmail  Required information in Checkout page
     * @param firstName     Required information in Checkout page
     * @param lastName      Required information in Checkout page
     * @param countryRegion Required information in Checkout page
     * @param address1      Required information in Checkout page
     * @param city          Required information in Checkout page
     * @param state         Required information in Checkout page
     * @param postCode      Required information in Checkout page
     * @param method        Required information in Checkout page
     *
     * @TestSteps:
     * @Step 1: From 'Homepage' browse to 'Category' page
     * @Step 2: Verify 'Category' page title is displayed. Search product
     * @Step 3: Verify that searched product is displayed. Select product
     * @Step 4: Verify that the product's page title is displayed. Click the button 'Add to cart'. Click the menu cart
     * @Step 5: Verify 'Cart' page title is displayed. Verify that product is displayed. Click the button 'Proceed to checkout'
     * @Step 6: Verify 'Checkout' page title is displayed. Fill out all required information
     * @Step 7: Click the button 'Pay'
     *
     */
    @Description("Test Case: Buying a product")
    @Test(dataProvider = "buyProduct", dataProviderClass = DataProviderService.class)
    public void buyProduct(String productName,
                           String email,
                           String confirmEmail,
                           String firstName,
                           String lastName,
                           String countryRegion,
                           String address1,
                           String city,
                           String state,
                           String postCode,
                           String method) {
        homePage.browseToCategoryPage();
        verify.isCategoryTitlePresent();

        categoryPage.searchProduct(productName);
        verify.isSearchedProductDisplayed(productName);

        categoryPage.selectSearchedProduct(productName);
        verify.isProductPageTitlePresent(productName);

        productPage.clickButtonAddToCart();
        productPage.clickMenuCart();
        verify.isCartTitlePresent();
        verify.isProductDisplayed(productName);

        cartPage.clickButtonProceedToCheckout();
        verify.isCheckoutTitlePresent();

        checkoutPage.inputEmail(email);
        checkoutPage.inputConfirmEmail(confirmEmail);
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        checkoutPage.selectCountry(countryRegion);
        checkoutPage.inputAddress1(address1);
        checkoutPage.inputCity(city);
        checkoutPage.selectStateInUS(state);
        checkoutPage.inputPostCode(postCode);
        checkoutPage.selectMethod(method);

        checkoutPage.clickButtonPay();

    }

    @Description("Test Case: Buying several products")
    @Test(dataProvider = "buySeveralProducts", dataProviderClass = DataProviderService.class)
    public void buySeveralProducts(String productName1,
                                   String productName2,
                                   String productName3,
                                   String productName4,
                                   String productName5,
                                   String email,
                                   String confirmEmail,
                                   String firstName,
                                   String lastName,
                                   String countryRegion,
                                   String address1,
                                   String city,
                                   String state,
                                   String postCode,
                                   String method) {
        List<String> productNames = Arrays.asList(productName1, productName2,
                productName3, productName4, productName5);
        homePage.browseToCategoryPage();
        verify.isCategoryTitlePresent();

        for (String eachName : productNames) {
            categoryPage.searchProduct(eachName);
            verify.isSearchedProductDisplayed(eachName);

            categoryPage.selectSearchedProduct(eachName);
            verify.isProductPageTitlePresent(eachName);

            productPage.clickButtonAddToCart();
            productPage.browseToCategoryPage();
        }

        categoryPage.clickMenuCart();
        verify.isCartTitlePresent();

        for (String eachName : productNames) {
            verify.isProductDisplayed(eachName);
        }

        cartPage.clickButtonProceedToCheckout();
        verify.isCheckoutTitlePresent();

        checkoutPage.inputEmail(email);
        checkoutPage.inputConfirmEmail(confirmEmail);
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        checkoutPage.selectCountry(countryRegion);
        checkoutPage.inputAddress1(address1);
        checkoutPage.inputCity(city);
        checkoutPage.selectStateInUS(state);
        checkoutPage.inputPostCode(postCode);
        checkoutPage.selectMethod(method);

        checkoutPage.clickButtonPay();
    }

}
