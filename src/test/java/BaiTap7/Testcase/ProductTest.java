package BaiTap7.Testcase;

import BaiTap7.Page.DashBoard;
import BaiTap7.Page.Login;
import BaiTap7.Page.Product;
import com.hoa.constants.ConfigData;
import common.BaseTest;
import org.testng.annotations.Test;

import static com.hoa.constants.ConfigData.EMAIL;
import static com.hoa.constants.ConfigData.PASSWORD;

public class ProductTest extends BaseTest {
    //Khai bao đối tượng
    Login loginPage;
    DashBoard dashboardPage;
    Product productPage;
    private String PRODUCT_NAME = "Áo thun loại 1";

    @Test
    public void AddProduct_Success() {
        loginPage = new Login(driver);
        dashboardPage=loginPage.LoginCMS(EMAIL,PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectNewProductPageSuccess();
        sleep(1);
        productPage.addProduct(PRODUCT_NAME);
        productPage.verifyAddProductSuccess();
    }
    @Test
    public void EditProduct_Success(){
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAllProductPageSuccess();
        productPage.searchProduct(PRODUCT_NAME);
        sleep(3);
        productPage.clickButtonEditProducts();

        productPage.editProduct(PRODUCT_NAME);
        productPage.verifyEditProductSuccess();
    }
}