package BaiTap7.Testcase;

import BaiTap7.Page.Login;
import common.BaseTest;
import org.testng.annotations.Test;

import static keywords.WebUI.waitForPageLoaded;

public class LoginTest extends BaseTest {

    //Khai bao đôi tượng
    Login loginPage;

    @Test
    public void testLoginCMS_Success() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("admin@example.com", "123456");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCMS_WithEmailPasswordInvalid() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("admin1@example.com", "1234");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithEmailInvalid() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("admin1@example.com", "123456");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithPasswordlInvalid() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("admin@example.com", "123");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithNullEmailPassword() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("", "");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullEmail() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("", "123456");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullPassword() {
        loginPage = new Login(driver);
        loginPage.LoginCMS("admin@example.com", "");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginFail_WithNullPasswordField();
    }

    //Login thành công khi tích checkbox remember
    @Test
    public void testLoginCMS_Success_WithCheckbox() {
        loginPage = new Login(driver);
        loginPage.LoginCMS_SelectCheckboxRemember("admin@example.com", "123456");

        loginPage.verifyLoginSuccess();
    }

    //Navigate to ForgotPWW
    @Test
    public void testNavigateToForgotPW() {
        loginPage = new Login(driver);
        loginPage.LoginCMS_ForgotPW("", "");

        loginPage.verifyNavigateForgotPW();
    }
}
