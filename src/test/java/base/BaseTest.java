package base;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.WebFormPage;
import utils.ConfigReader;
import utils.ElementUtil;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> WAIT = new ThreadLocal<>();

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        logger.info("Starting test setup");
        driver = DriverFactory.initDriver();
        DRIVER.set(driver);
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(ConfigReader.get("timeout"))));
        WAIT.set(wait);
        logger.info("Test setup completed");
    }

    protected WebDriver getDriver() {
        return DRIVER.get();
    }

    protected WebDriverWait getWait() {
        return WAIT.get();
    }

    protected WebFormPage getPage() {
        return new WebFormPage(new ElementUtil(getDriver(), getWait()));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        DRIVER.remove();
        WAIT.remove();
        logger.info("Test teardown completed");
    }
}
