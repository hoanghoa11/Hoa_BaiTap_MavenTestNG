package BaiTap7.Testcase;


import BaiTap7.Page.Category;
import BaiTap7.Page.DashBoard;
import BaiTap7.Page.Login;
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

}