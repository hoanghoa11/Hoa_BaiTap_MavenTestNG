package BaiTap5.Testcase;

import BaiTap5.Page.Category;
import BaiTap5.Page.DashBoard;
import BaiTap5.Page.Login;
import BaiTap5.Page.Product;
import common.BaseTest;
import org.testng.annotations.Test;

import static keywords.WebUI.waitForPageLoaded;

public class DashBoardTest extends BaseTest {
    Login loginPage;
    DashBoard dashboardPage;
    Category categoryPage;
    Product productPage;

    @Test
    public void testOpenProductPage() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
    }
    @Test
    public void testOpenCategoryPage() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();
        categoryPage = dashboardPage.clickMenuCategory();
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        //customerPage = new CustomerPage(driver); thay thế dòng này bằng dòng trên để thu gọn code
        categoryPage.verifyRedirectCategoryPageSuccess();
    }

    @Test
    public void logout() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();

        loginPage = dashboardPage.clickLogout();
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyRedirectLoginPage();
    }
}
