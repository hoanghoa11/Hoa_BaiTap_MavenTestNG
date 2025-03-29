package BaiTap12.Testcase;

import BaiTap12.Page.Brand;
import BaiTap12.Page.DashBoard;
import BaiTap12.Page.Login;
import BaiTap12.Page.Product;
import com.hoa.constants.ConfigData;
import com.hoa.helpers.CaptureHelper;
import com.hoa.helpers.ExcelHelper;
import common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {
    Login loginPage;
    DashBoard dashboardPage;
    Product productPage;
    Brand brandPage;
    private String BRAND_NAME = "Zara";

    @Test
    public void testAddBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Brand");
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();

        brandPage.inputDataBrand(excelHelper.getCellData("Name Brand", 1),excelHelper.getCellData("Title Brand", 1),excelHelper.getCellData("Description Brand", 1));
//        brandPage.verify_AddBrand_Success();
        CaptureHelper.captureScreenshot("testAddBrand_Success");

    }

    @Test
    public void testEditBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Brand");
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();

        brandPage.searchBrand("Zara");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        brandPage.editBrand();
        brandPage.editDataBrand(excelHelper.getCellData("Name Brand", 2),excelHelper.getCellData("Title Brand", 2),excelHelper.getCellData("Description Brand", 2));
//        brandPage.verify_EditBrand_Success();
        brandPage = dashboardPage.clickMenuBrand2();
        brandPage.searchBrand("ZaraTinNgoan");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        CaptureHelper.captureScreenshot("testEditBrand_Success");
    }
    @Test
    public void testDeleteBrand_Success() {
        loginPage = new Login(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();
        brandPage.searchBrand(BRAND_NAME);
        //  brandPage.searchBrand("Brand test2");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        brandPage.deleteBrand();
//        brandPage.verify_DeleteBrand_Success();
        CaptureHelper.captureScreenshot("testDeleteBrand_Success");
    }
}
