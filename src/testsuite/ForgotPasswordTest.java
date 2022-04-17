package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find the forgot password link and click on th forgot password link
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/index.php/auth/requestPasswordResetCode']"));
        forgotPassword.click();
        // this message from requirement
        String expectedErrorMessage = "Forgot Your Password?";
        // this message from requirement
        String actualErrorMessage = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]")).getText();
        //Validate actual and expected message
        Assert.assertEquals("Forgot Your Password? Message Not Displayed correctly", expectedErrorMessage, actualErrorMessage);

    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}

