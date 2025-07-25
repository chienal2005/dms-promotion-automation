package test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.utilities.BaseTest;
import test.utilities.ConfigReader;
import test.Page.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard") || currentUrl.contains("home"));
    }
}
