package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test(enabled = false)
    public void openGoogle() {
        driver.get("https://www.google.com");
    }
}