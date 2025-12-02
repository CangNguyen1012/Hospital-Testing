package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {
    private static final String VALID_USERNAME = "cangtester";
    private static final String VALID_PASSWORD = "123456";
    private static final String INVALID_USERNAME = "invalid";
    private static final String INVALID_PASSWORD = "111111";

    @Test
    public void testLoginSuccess() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        Thread.sleep(3000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("login"));
    }

    @Test
    public void testLoginFailed() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);
        Thread.sleep(2000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testLoginWithEmptyFields() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login("", "");
        Thread.sleep(2000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testLoginWithEmptyUsername() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login("", VALID_PASSWORD);
        Thread.sleep(2000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testLoginWithEmptyPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login(VALID_USERNAME, "");
        Thread.sleep(2000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testLoginWithWrongUsername() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login(INVALID_USERNAME, VALID_PASSWORD);
        Thread.sleep(2000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testLoginWithWrongPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login(VALID_USERNAME, INVALID_PASSWORD);
        Thread.sleep(2000);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testRegisterLink() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.clickRegisterLink();
        Thread.sleep(2000);

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("register"));
    }

    @Test
    public void testForgotPasswordLink() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Thread.sleep(2000);
        loginPage.clickForgotPasswordLink();
        Thread.sleep(2000);

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("forgot-password"));
    }
}
