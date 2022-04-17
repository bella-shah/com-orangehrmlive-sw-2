package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // sending email to email field element
        usernameField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        // sending password to password field element
        passwordField.sendKeys("admin123");
        // find the login link and click on the login link
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        String expectedMessage = "Welcome Paul";
        // this message from requirement
        WebElement welcome = driver.findElement(By.partialLinkText("Welcome"));
        String actualMessage = welcome.getText();
        // verifying actual results and expected result
        Assert.assertEquals("Incorrect Login Detail", expectedMessage, actualMessage);
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}








