package BaiTap3;

import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddCategory extends BaseTest {

    @Test(priority = 1, description = "Kiểm tra Log in thành công")
    public void testLoginSuccess() {
        createBrowser();
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://cms.anhtester.com/login");

        //Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), "Header trang Login không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(), "Welcome to Active eCommerce CMS", "Giá trị header không đúng.");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        //Kiểm tra xem đã vào được trang Dashboard hay chưa - Log in thành công hay chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(), "Menu Dashboard không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).getText(), "Dashboard", "Giá trị Menu Dashboard không đúng.");
        softAssert.assertAll();
        closeBrowser();
    }

    @Test(priority = 2, description = "Kiểm tra xem user đã vào đến trang Category hay chưa")
    public void testCategoryPage() throws InterruptedException {
        createBrowser();
        SoftAssert softAssert = new SoftAssert();

        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();

        //Kiểm tra xem đã vào đến trang Category hay chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerCategory)).isDisplayed(), "Không hiển thị đúng trang Category.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerCategory)).getText(), "All categories", "Giá trị header trang Category không đúng.");
        softAssert.assertAll();
        closeBrowser();
    }

    @Test(priority = 3, description = "Kiểm tra việc tạo một category mới thành công")
    public void testCreateCategory() throws InterruptedException {
        createBrowser();
        SoftAssert softAssert = new SoftAssert();
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();
        Thread.sleep(1000);

        //Click vào button Add New Category
        driver.findElement(By.xpath(LocatorsCRM.buttonCreateCategory)).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerAddNewCategory)).isDisplayed(), "Không hiển thị đúng trang Thêm mới Category");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewCategory)).getText(), "Category Information", "Giá trị header trang Add New Category không đúng.");

        //Thêm mới Category
        driver.findElement(By.xpath(LocatorsCRM.textBoxName)).sendKeys("Giỏ quà bánh Tết");
        driver.findElement(By.xpath(LocatorsCRM.dropListParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.parentCategorySearch)).sendKeys("Gio qua Tet");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Gio qua Tet 1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.textBoxOrderNumber)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropListType)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='digital']/following-sibling::div//a)[1]")).click();
        driver.findElement(By.xpath(LocatorsCRM.bannerImage)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("Cosy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='Cosy.png') and (@data-value=2601)]")).click();
        driver.findElement(By.xpath(LocatorsCRM.bannerImageAddFile)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.iconImage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("hoa tuyết mai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='hoa tuyết mai.png') and (@data-value=2618)]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.iconImageAddFile)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.metaTitleTextbox)).sendKeys("ABC");
        driver.findElement(By.xpath(LocatorsCRM.metaDescription)).sendKeys("This is test");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropListFilteringAttributes)).click();
        driver.findElement(By.xpath("//ul[@role='presentation']/descendant::a[@id='bs-select-3-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropListFilteringAttributes)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRM.saveButton)).click();
        Thread.sleep(3000);
        //Kiểm tra xem đã add Category thành công hay chưa
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.addSuccessMessage)).getText().contains("inserted successfully"), "Category chưa được add mới thành công");
        softAssert.assertAll();
        closeBrowser();
    }

    @Test(priority = 4, description = "Kiểm tra lại category vừa add đã chính xác chưa")
    public void testCreatedCategory() throws InterruptedException {
        createBrowser();
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        //Click vào Menu Product và chọn Category
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();
        Thread.sleep(1000);

        //Kiểm tra lại category vừa add đã chính xác chưa
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText().equals("Giỏ quà bánh Tết"), "Tên Category vừa được tạo chưa hiển thị đúng");
        closeBrowser();
    }
}
