package BaiTap13.Testcase;


import BaiTap13.Page.Category;
import BaiTap13.Page.DashBoard;
import BaiTap13.Page.Login;
import com.hoa.constants.ConfigData;
import com.hoa.helpers.CaptureHelper;
import com.hoa.helpers.ExcelHelper;
import common.BaseTest;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    public String CATEGORY_NAME = "Gio qua Tet 1";
    //Khai bao đối tượng
    Login loginPage;
    DashBoard dashboardPage;
    Category categoryPage;

    @Test
    public void testAddCategory_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Category");
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.addCategory(excelHelper.getCellData("Category Name", 1));
        categoryPage.verifyAddCategorySuccess();
        CaptureHelper.captureScreenshot("testAddCategory_Success");
    }

    @Test
    public void testHandleCheckDatatable() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
        categoryPage.searchDataProductTable("s");
        categoryPage.checkSearchTableByColumn(2, "s"); // so sanh chứa contains
        CaptureHelper.captureScreenshot("testHandleCheckDatatable");

    }

}