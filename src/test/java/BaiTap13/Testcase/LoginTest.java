package BaiTap13.Testcase;

import BaiTap13.Page.Login;
import com.hoa.helpers.CaptureHelper;
import com.hoa.helpers.ExcelHelper;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai bao đôi tượng
    Login loginPage;

    @Test
    public void testLoginCMS_Success() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");

        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
//        CaptureHelper.captureScreenshot("testLoginCMS_Success");

    }

    @Test
    public void testLoginCMS_WithEmailPasswordInvalid() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 2));
        loginPage.verifyLoginFail();

        CaptureHelper.captureScreenshot("testLoginCMS_WithEmailPasswordInvalid");
    }

    @Test
    public void testLoginCMS_WithEmailInvalid() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 3), excelHelper.getCellData("password", 3));
        loginPage.verifyLoginFail();
        CaptureHelper.captureScreenshot("testLoginCMS_WithEmailInvalid");
    }

    @Test
    public void testLoginCMS_WithPasswordlInvalid() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 4), excelHelper.getCellData("password", 4));
        loginPage.verifyLoginFail();
        CaptureHelper.captureScreenshot("testLoginCMS_WithEmailInvalid");
    }

    @Test
    public void testLoginCMS_WithNullEmailPassword() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        loginPage.verifyLoginFail_WithNullEmailField();
        CaptureHelper.captureScreenshot("testLoginCMS_WithEmailInvalid");
    }

    @Test
    public void testLoginCMS_WithNullEmail() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 6), excelHelper.getCellData("password", 6));
        loginPage.verifyLoginFail_WithNullEmailField();
        CaptureHelper.captureScreenshot("testLoginCMS_WithEmailInvalid");
    }

    @Test
    public void testLoginCMS_WithNullPassword() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 5), excelHelper.getCellData("password", 5));
        loginPage.verifyLoginFail_WithNullPasswordField();
        CaptureHelper.captureScreenshot("testLoginCMS_WithNullPassword");
    }

    //Login thành công khi tích checkbox remember
    @Test
    public void testLoginCMS_Success_WithCheckbox() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS_SelectCheckboxRemember(excelHelper.getCellData("email", 1), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
        CaptureHelper.captureScreenshot("testLoginCMS_Success_WithCheckbox");
    }

    //Navigate to ForgotPWW
    @Test
    public void testNavigateToForgotPW() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new Login(driver);
        loginPage.LoginCMS_ForgotPW(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        loginPage.verifyNavigateForgotPW();
        CaptureHelper.captureScreenshot("testNavigateToForgotPW");
    }
//
}
