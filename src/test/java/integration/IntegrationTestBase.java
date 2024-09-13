package integration;

import common.WebDriverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.LoginPage;
import verification.Verify;

public class IntegrationTestBase {
    private static final Logger logger = LogManager.getLogger(IntegrationTestBase.class);

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CreateAnAccountPage createAnAccountPage;
    protected Verify verify;

    @BeforeClass
    public void setUpClass() {
        this.driver = WebDriverUtil.getDriver();
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.createAnAccountPage = new CreateAnAccountPage();
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
