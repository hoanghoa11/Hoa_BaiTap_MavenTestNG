package BaiTap10.Page;

import com.hoa.drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

import static keywords.WebUI.waitForPageLoaded;

public class Category {
    private WebDriver driver;

    public Category(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By headerCategory = By.xpath("//h1[normalize-space()='All categories']");
    private By inputSearchCategory = By.xpath("//input[@id='search']");
    private By headerAddNewCategory = By.xpath("//h5[normalize-space()='Category Information']");

    private By inputNameCategory = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("//button[@title='No Parent']");
    private By searchParentCategory = By.xpath("(//input[@aria-label='Search'])[1]");
    private By selectParentCategory = By.xpath("//a[@id='bs-select-1-6']/child::span[normalize-space()='-------- QuynhNN']");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownTypeCategory = By.xpath("//button[@title='Physical']");
    private By selectTypeCateGory = By.xpath("//li[@class='selected active']");
    private By chooseBannerImage = By.xpath("(//label[@for='signinSrEmail'])[1]/following-sibling::div//div[@class='input-group']");
    private By selectImage1 = By.xpath("(//div[@title='product image test.jpg'])[2]");
    //    private By selectImage1 = By.xpath("//div[@class='card card-file aiz-uploader-select' and @title='giay.png']");
    private By buttonAddFileImage = By.xpath("//button[normalize-space()='Add Files']");
    private By selectImage2= By.xpath("//div[@title='jordanLogo.jpg']");
    //    private By selectImage2= By.xpath("//div[@class='card card-file aiz-uploader-select' and @title='jordanLogo.jpg']");
    private By chooseIconImage = By.xpath("(//label[@for='signinSrEmail'])[2]/following-sibling::div//div[@class='input-group']");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By dropdownFilterAttribute = By.xpath("(//div[@class='col-md-9'])[9]/div");
    private By searchFilterAttribute = By.xpath("//input[@aria-controls='bs-select-3']");
    private By selectValueFilterAttribute = By.xpath("//a[@id='bs-select-3-1']");
    private By buttonSaveCategory = By.xpath("//button[@type='submit']");

    private By messageSuccess = By.xpath("//span[@data-notify='message']");
    private By inputSearchCatelogy = By.xpath("//input[@id='search']");

    public void clickButtonAddNew() {
        WebUI.clickElement(buttonAddNewCategory);
    }

    public void verifyRedirectCategoryPageSuccess() {
        Assert.assertTrue(driver.findElement(headerCategory).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(driver.findElement(headerCategory).getText(), "All categories", "Header màn Category không đúng");
    }
    public void addCategory(String categoryName) {
        WebUI.setText(inputNameCategory,categoryName);

        WebUI.clickElement(dropdownParentCategory);
        WebUI.setText(searchParentCategory,"Gio qua tet");
        WebUI.sleep(1);
        driver.findElement(searchParentCategory).sendKeys(Keys.ENTER);

        WebUI.setText(inputOrderingNumber,"12345");

        WebUI.clickElement(dropdownTypeCategory);
        WebUI.clickElement(selectTypeCateGory);

        WebUI.clickElement(chooseBannerImage);
        WebUI.waitForElementVisible(selectImage1);
        WebUI.clickElement(selectImage1);
        WebUI.clickElement(buttonAddFileImage);

        WebUI.setText(inputMetaTitle,"Gio kieu moi");
        WebUI.setText(inputMetaDescription,"Gio bong dep");

        WebUI.clickElement(dropdownFilterAttribute);
        WebUI.clickElement(selectValueFilterAttribute);

        WebUI.clickElement(buttonSaveCategory);
    }

    public void verifyAddCategorySuccess() {
        Assert.assertTrue(driver.findElement(messageSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(driver.findElement(messageSuccess).getText(), "Category has been inserted successfully", "Nội dung message không chính xác");
    }


    //Lấy ra số lượng dữ liệu hợp lệ của mỗi bảng
    public void filterClientGroup(String value) {

        WebUI.setText(inputSearchCatelogy, value);
        WebUI.getWebElement(inputSearchCatelogy).sendKeys(Keys.ENTER);
    }

    public void checkSearchTableByColumn2(int column, String value) {
        filterClientGroup(value);
        waitForPageLoaded();
        WebUI.sleep(2);
        //Xác định số dòng của table sau khi search

        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);
        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }
    public void searchDataProductTable(String categoryName) {
        WebUI.setText(inputSearchCatelogy, categoryName);
        driver.findElement(inputSearchCatelogy).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        WebUI.waitForPageLoaded();
    }

    //Lấy ra số lượng dữ liệu hợp lệ của mỗi bảng
    public int checkSearchTableByColumn(int column, String value) {
        WebElement pagination = driver.findElement(By.className("pagination"));

        // Lấy danh sách tất cả các thẻ <li> bên trong <ul>
        List<WebElement> liElements = pagination.findElements(By.tagName("li"));

        // Đếm số lượng thẻ <li>
        int count = liElements.size();

        int totalpage = count -2;

        WebElement table = driver.findElement(By.id("sort_categories")); // Thay thế bằng selector phù hợp

        // Lấy danh sách các thẻ <tr> trong bảng
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Đếm số hàng
        int rowCount = rows.size();

        int productInPage = rowCount-1;
        int total = productInPage * (totalpage -1);

        WebElement lastLi = liElements.get(totalpage);
        lastLi.click();
        WebUI.sleep(2);
        WebElement tablelast = driver.findElement(By.id("sort_categories")); // Thay thế bằng selector phù hợp

        // Lấy danh sách các thẻ <tr> trong bảng
        List<WebElement> rowslast = tablelast.findElements(By.tagName("tr"));
        int rowCountlast = rowslast.size();

        int productInPagelast = rowCountlast-1;
        int totalProductSearch = total + productInPagelast;


//
//        // Lấy ra phần tử cuối
//        List<WebElement> pagination = driver.findElements(totalPage);
//        int last_pages = 1; // Khởi tạo số trang là 1 nếu không có phân trang
//
//        if (pagination.size() > 1) {
//            // Lấy phần tử thứ hai từ cuối (size() - 2)
//            String pageText = pagination.get(pagination.size() - 2).getText();
//
//            // Chuyển đổi chuỗi thành số nguyên
//            last_pages = Integer.parseInt(pageText);
//        }
//
//        int total_products = 0;
//
//        // Duyệt qua từng trang
//        for (int page = 1; page <= last_pages; page++) {
//            // Nếu có nhiều trang, bạn cần logic để chuyển trang tại đây
//            if (page > 1) {
//                driver.findElement(By.xpath("//a[contains(text(), '" + page + "')]")).click();
//            }
//
//            // Xác định số dòng của table sau khi search
//            List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
//            int rowTotal = row.size(); // Lấy ra số dòng
//            System.out.println("Số dòng tìm thấy: " + rowTotal);
//
//            // Duyệt từng dòng
//            for (int i = 1; i <= rowTotal; i++) {
//                WebElement elementCheck = driver.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));
//
//                // Scroll xuống từng dòng, true là trên, false là dưới
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].scrollIntoView(false);", elementCheck);
//
//                System.out.print(value + " - ");
//                System.out.println(elementCheck.getText()); // actual result
//                Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
//            }
//
//            // Cộng dồn số lượng sản phẩm của trang hiện tại
//            total_products += rowTotal;
//        }
//
//        // Trả về tổng số sản phẩm tìm thấy
        System.out.println("Tổng số sản phẩm hợp lệ: " + totalProductSearch);
        return totalProductSearch;
    }
}
