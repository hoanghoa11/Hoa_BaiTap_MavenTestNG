package BaiTap2;

import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddCatelogy extends BaseTest {

    @Test(priority = 1, description = "Kiểm tra Log in thành công")
    public void testLoginCSM() {
        createBrowser();
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        closeBrowser();
    }

    @Test(priority = 2, description = "Kiểm tra xem user đã vào đến trang Category hay chưa")
    public void testCategoryPage() throws InterruptedException {
        createBrowser();
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();
        closeBrowser();
    }

    @Test(priority = 3, description = "Kiểm tra việc tạo một category mới thành công")
    public void testCreateCategory() throws InterruptedException {
        createBrowser();
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonCreateCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.textBoxName)).sendKeys("Giỏ quà bánh Tết");

        driver.findElement(By.xpath(LocatorsCRM.dropListParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.parentCategorySearch)).sendKeys("Gio qua Tet");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='parent_id']/following-sibling::div//descendant::span)[1]")).click();
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
        closeBrowser();
    }

    @Test(priority = 4, description = "Kiểm tra lại category vừa add đã chính xác chưa")
    public void testCreatedCategory() throws InterruptedException {
        createBrowser();
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();

        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        if ((driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText()).equals("Giỏ quà bánh Tết")) {
            System.out.println("Tạo mới category thành công");
        } else {
            System.out.println("Category chưa được tạo thành công");

        }
        closeBrowser();
    }
}
