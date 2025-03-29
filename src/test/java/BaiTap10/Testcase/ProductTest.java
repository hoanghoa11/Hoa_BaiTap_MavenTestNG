package BaiTap10.Testcase;

import BaiTap10.Page.DashBoard;
import BaiTap10.Page.Login;
import BaiTap10.Page.Product;
import com.hoa.constants.ConfigData;
import com.hoa.helpers.ExcelHelper;
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
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectNewProductPageSuccess();
        sleep(1);
        productPage.addProduct(excelHelper.getCellData("Product Name", 1));
//        productPage.verifyAddProductSuccess();
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
//        productPage.verifyEditProductSuccess();
    }
    @Test
    public void testCheckDataOnProductTable() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        //       loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.searchDataProductTable("s");
        productPage.checkSearchTableByColumn(2, "s"); // so sanh chứa contains

    }
}