package BaiTap5.Testcase;

import BaiTap5.Page.Category;
import BaiTap5.Page.DashBoard;
import BaiTap5.Page.Login;
import BaiTap5.Page.Product;
import com.hoa.constants.ConfigData;
import common.BaseTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    //Khai bao đối tượng
    Login loginPage;
    DashBoard dashboardPage;
    Product productPage;
    private String PRODUCT_NAME = "Gio loại 1";

    @Test
    public void AddProduct_Success() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectNewProductPageSuccess();
        productPage.addProduct(PRODUCT_NAME);
        productPage.verifyAddProductSuccess();
    }
}