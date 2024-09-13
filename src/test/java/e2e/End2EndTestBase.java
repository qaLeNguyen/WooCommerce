package e2e;

import common.WebDriverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;
import verification.Check;
import verification.Verify;

public class End2EndTestBase {
    private static final Logger logger = LogManager.getLogger(End2EndTestBase.class);

    protected WebDriver driver;
    protected CartPage cartPage;
    protected CategoryPage categoryPage;
    protected CheckoutPage checkoutPage;
    protected CreateAnAccountPage createAnAccountPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected Check check;
    protected Verify verify;

    @BeforeClass
    public void setUpClass() {
        this.driver = WebDriverUtil.getDriver();
        this.cartPage = new CartPage();
        this.categoryPage = new CategoryPage();
        this.checkoutPage = new CheckoutPage();
        this.createAnAccountPage = new CreateAnAccountPage();
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.productPage = new ProductPage();
        this.check = new Check();
        this.verify = new Verify();

        logger.info("setUpClass is completed. Initialize all Objects");
    }

    @BeforeMethod
    public void setUpMethod() {
        driver.get("https://woocommerce.com/");
        logger.info("setUpMethod is completed. Navigated to homepage url");
    }

    @AfterMethod
    public void tearDownMethod() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            logger.info("tearDownMethod is completed. Driver clear all cookies");
        }
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
        logger.info("tearDownClass is completed. Driver quit");
    }

}
