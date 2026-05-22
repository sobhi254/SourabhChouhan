package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.ElementUtil;

public class WebFormPage {

    private static final Logger logger = LogManager.getLogger(WebFormPage.class);
    private ElementUtil util;

    public WebFormPage(ElementUtil util) {
        this.util = util;

    }

    public void open() {
        logger.info("Opening web form page");
        util.getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    private By name = By.name("my-text");
    private By password = By.name("my-password");
    private By textarea = By.name("my-textarea");
    private By dropdown = By.name("my-select");
    private By checkbox = By.id("my-check-1");
    private By submitBtn = By.cssSelector("button");
    private By message = By.xpath("//h1");

    public void fillForm(String user, String pass, String msg) {
        logger.info("Filling web form for user: {}", user);
        util.type(name, user);
        util.type(password, pass);
        util.type(textarea, msg);
    }

    public void selectOption(String value) {
        logger.info("Selecting dropdown option: {}", value);
        util.select(dropdown, value);
    }

    public void clickCheckbox() {
        logger.info("Clicking checkbox");
        util.click(checkbox);
    }

    public void submitForm() {
        logger.info("Submitting form");
        util.click(submitBtn);
    }

    public String getMessage() {
        logger.info("Reading submitted form message");
        return util.getText(message);
    }
}
