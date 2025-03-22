package BaiTap5.Testcase;


import BaiTap5.Page.Category;
import BaiTap5.Page.DashBoard;
import BaiTap5.Page.Login;
import com.hoa.constants.ConfigData;
import common.BaseTest;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    //Khai bao đối tượng
    Login loginPage;
    DashBoard dashboardPage;
    Category categoryPage;
    private String CATEGORY_NAME = "Giay cao got";

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