package test.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
