package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        Assert.assertEquals(loginPage.getProductsTitle(), "Products");
    }
}