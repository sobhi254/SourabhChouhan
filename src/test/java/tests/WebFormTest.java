package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.WebFormPage;
import utils.ExcelUtil;

public class WebFormTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(WebFormTest.class);

    @DataProvider(name = "formData")
    public Object[][] getData() {
        return ExcelUtil.readSheet(
                "src/test/resources/testdata/webform-data.xlsx",
                "webform"
        );
    }

    @Test(dataProvider = "formData")
    public void testFormSubmission(String user, String password, String message, String option) {

        logger.info("Starting testFormSubmission for user: {}", user);
        WebFormPage page = getPage();
        page.open();

        page.fillForm(user, password, message);
        page.selectOption(option);
        page.clickCheckbox();
        page.submitForm();

        Assert.assertEquals(page.getMessage(), "Form submitted");
        logger.info("Finishedd testFormSubmission for user: {}", user);
    }
}
