package e2e;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviderService;

import java.util.Arrays;
import java.util.List;

public class TestProductSearchAndFilter extends End2EndTestBase{
    private static final Logger logger = LogManager.getLogger(TestProductSearchAndFilter.class);

    @BeforeMethod
    @Override
    public void setUpMethod() {
        super.setUpMethod();

        homePage.browseToCategoryPage();
        verify.isCategoryTitlePresent();
        logger.info("setUpMethod is completed. Navigated to 'Category' page");
    }

    @Description("Test Case: Search products and verify it is displayed")
    @Test(dataProvider = "searchProducts", dataProviderClass = DataProviderService.class)
    public void searchProducts(String productName1,
                               String productName2,
                               String productName3,
                               String productName4,
                               String productName5,
                               String productName6,
                               String productName7,
                               String productName8,
                               String productName9,
                               String productName10,
                               String productName11,
                               String productName12,
                               String productName13,
                               String productName14,
                               String productName15,
                               String productName16,
                               String productName17,
                               String productName18,
                               String productName19,
                               String productName20) {
        List<String> productNames = Arrays.asList(
                productName1, productName2, productName3, productName4, productName5,
                productName6, productName7, productName8, productName9, productName10,
                productName11, productName12, productName13, productName14, productName15,
                productName16, productName17, productName18, productName19, productName20);
            for (String eachName : productNames) {
                categoryPage.searchProduct(eachName);
                verify.isSearchedProductDisplayed(eachName);
            }
        }

    @Description("Test Case: Filter products by 'Category' and verify it is displayed correctly")
    @Test(dataProvider = "filterProductsByCategory", dataProviderClass = DataProviderService.class)
    public void filterProductsByCategory(String category,
                                         String expectVendorName) {
        categoryPage.sortByCategory(category);
        verify.isTextCategoryDisplayed(category);
    }

    @Description("Test Case: Filter products by 'Price' and verify it is displayed")
    @Test(dataProvider = "filterProductsByPrice",dataProviderClass = DataProviderService.class)
    public void filterProductsByPrice(String rangePrice,
                                      int beginPrice,
                                      int endPrice) {

        categoryPage.sortByRangePrice(rangePrice);
        categoryPage.scrollToFirstProductOfPage();
        categoryPage.scrollDownInAllPagesAndCheckPrice(beginPrice, endPrice);
    }

    @Description("Test Case: Find product is displayed in a specific pagination")
    @Test(dataProvider = "findProducts",dataProviderClass = DataProviderService.class)
    public void findProducts(String productName) {



    }



}
