package BaiTap9.Testcase;


import BaiTap9.Page.Category;
import BaiTap9.Page.DashBoard;
import BaiTap9.Page.Login;
import com.hoa.constants.ConfigData;
import common.BaseTest;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    //Khai bao đối tượng
    Login loginPage;
    DashBoard dashboardPage;
    Category categoryPage;
    public String CATEGORY_NAME = "Gio qua Tet 1";

    @Test

    public void testAddCategory_Success(){
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.addCategory(CATEGORY_NAME);
        categoryPage.verifyAddCategorySuccess();
    }
    @Test
    public void testHandleCheckDatatable() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
        categoryPage.searchDataProductTable("s");
        categoryPage.checkSearchTableByColumn(2, "s"); // so sanh chứa contains
    }

}