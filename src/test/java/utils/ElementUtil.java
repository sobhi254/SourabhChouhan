package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ElementUtil {

    private static final Logger logger = LogManager.getLogger(ElementUtil.class);
    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtil(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void type(By locator, String value) {
        logger.debug("Typing into element: {}", locator);
        WebElement element = waitForClickable(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void click(By locator) {
        logger.debug("Clicking element: {}", locator);
        wait.until(driver -> {
            try {
                waitForClickable(locator).click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
    }

    public void select(By locator, String text) {
        logger.debug("Selecting '{}' from element: {}", text, locator);
        WebElement element = waitForClickable(locator);
        new Select(element).selectByVisibleText(text);
    }

    public String getText(By locator) {
        logger.debug("Getting text from element: {}", locator);
        return wait.until(driver -> {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
            } catch (StaleElementReferenceException e) {
                return null;
            }
        });
    }

    private WebElement waitForClickable(By locator) {
        return wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                return element.isDisplayed() && element.isEnabled() ? element : null;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return null;
            }
        });
    }
}
