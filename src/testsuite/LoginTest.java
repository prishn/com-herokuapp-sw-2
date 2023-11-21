package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * Enter “tomsmith” username
 * Enter “SuperSecretPassword!” password
 * Click on ‘LOGIN’ button
 * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * <p>
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(2000);
        // Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        Thread.sleep(2000);
        // Verify the text “Secure Area”
        String expectedResult = "Secure Area";
        String actualResult = driver.findElement(By.xpath("//div[@class ='example']//h2")).getText();
        Assert.assertEquals("Not found", expectedResult, actualResult);
    }

    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        Thread.sleep(2000);
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(2000);
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        Thread.sleep(2000);
        // Verify the error message “Your username is invalid!”
        String expectedResult = "Your username is invalid!\n×";
        String actualResult = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        // Enter “SuperSecretPassword” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        // Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        Thread.sleep(2000);
        // Verify the error message “Your password is invalid!”
        String expectedResult = "Your password is invalid!\n×";
        String actualResult = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
