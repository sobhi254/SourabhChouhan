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
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(value);
    }

    public void click(By locator) {
        logger.debug("Clicking element: {}", locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void select(By locator, String text) {
        logger.debug("Selecting '{}' from element: {}", text, locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        new Select(element).selectByVisibleText(text);
    }

    public String getText(By locator) {
        logger.debug("Getting text from element: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
