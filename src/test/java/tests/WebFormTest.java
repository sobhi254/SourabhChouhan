package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebFormPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebFormTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(WebFormTest.class);

    @Test(enabled=true)
    public void testFormSubmission() {

        logger.info("Starting testFormSubmission");
        WebFormPage page = getPage();
        page.open();

        page.fillForm("Sourabh", "password123", "Learning Selenium");
        page.selectOption("Two");
        page.clickCheckbox();
        page.submitForm();

        Assert.assertEquals(page.getMessage(), "Form submitted");
        logger.info("Finished testFormSubmission");
    }

    @Test(enabled = true)
    public void testFormSubmission2() {

        logger.info("Starting testFormSubmission2");
        WebFormPage page = getPage();
        page.open();

        page.fillForm("Sourabh2", "password123", "Learning Selenium");
        page.selectOption("Two");
        page.clickCheckbox();
        page.submitForm();

        Assert.assertEquals(page.getMessage(), "Form submitted");
        logger.info("Finished testFormSubmission2");
    }
}
