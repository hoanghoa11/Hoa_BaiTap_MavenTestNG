package BaiTap9.Page;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Product {
    private WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By headerNewProduct = By.xpath("//h5[normalize-space()='Add New Product']");
    private By headerAllProducts = By.xpath("//span[normalize-space()='All products']");
    //Product Information
    private By inputProductName = By.xpath("//label[contains(normalize-space(),'Product Name')]/following-sibling::div/input");
    private By dropdownCategoryProduct = By.xpath("//label[normalize-space()='Category']/following-sibling::div/div");
    private By inputSearchCategoryProduct = By.xpath("//div[@id='category']//input");
    private By dropdownBrand = By.xpath("//button[@data-id='brand_id']");
    private By inputSearchBrand = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']");
    private By inputUnit = By.xpath("//input[@name='unit']");
    private By inputWeight = By.xpath("//input[@name='weight']");
    private By inputMinPurchaseQty = By.xpath("//input[@name='min_qty']");
    private By inputTags = By.xpath("//span[@role='textbox']");
    //product image
    private By selectGalleryImages = By.xpath("//label[.='Gallery Images (600x600)']/following-sibling::div/div[@data-type='image']");
    private By selectThumbnailImages = By.xpath("//label[contains(.,'Thumbnail Image')]/following-sibling::div/div[@data-type='image']");
    //Product Videos
    private By inputVideoProvider = By.xpath("//button[@data-id='video_provider']");
    private By inputLinkVideo = By.xpath("//input[@name='video_link']");
    //Product Variation
    private By buttonEnableColors = By.xpath("//div[@class='col-md-1']//span");
    private By dropdownColors = By.xpath("//button[@data-id='colors']");
    private By selectColor1 = By.xpath("//a[@id='bs-select-4-0']");
    private By selectColor2 = By.xpath("//a[@id='bs-select-4-1']");
    private By selectColor3 = By.xpath("//a[@id='bs-select-4-2']");
    private By dropdownAttributes = By.xpath("//button[@data-id='choice_attributes']");
    private By inputSearchAttributes = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    //Product price + stock
    private By inputUnitPrice = By.xpath("//input[@name='unit_price']");
    private By inputDiscountRangeDate = By.xpath("//input[@placeholder='Select Date']");
    private By inputDiscount = By.xpath("//input[@name='discount']");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");
    private By inputSku = By.xpath("//input[@name='sku']");
    private By inputExternalLinks = By.xpath("//input[@name='external_link']");
    private By inputExternalLinkButtonText = By.xpath("//input[@name='external_link_btn']");
    //Product Description
    private By inputDescription = By.xpath("//input[@name='min_qty']");
    //PDF Specification
    private By uploadFilePDF = By.xpath("//div[@data-type='document']");
    //Button Save
    private By buttonSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");

    private By messageSuccess = By.xpath("//span[@data-notify='message']");

    //search lại sản phẩm vừa tạo
    private By inputSearchProduct = By.xpath("//input[@id='search']");
    private By firstItemOnProductTable = By.xpath("(//div[@class='col'])[2]//span");
    //Edit sản phẩm vừa tạo
    private By buttonAllProducts = By.xpath("//span[normalize-space()='All products']");


    private By firstIconProductEdit = By.xpath("(//form[@id='sort_products']//div//tr//td//a[@title='Edit'])[1]");
    private By selectCategory1 = By.xpath("(//span[@class='text'][normalize-space()='------ TestExcel1'])[1]");
    private By buttonUpdateProduct = By.xpath("//button[normalize-space()='Update Product']");
    private By msgUpdateProductSuccess = By.xpath("//div[@role='alert']");

    //XD cac ham xu ly chinh tren trang nay
    public void clickButtonAddProduct() {
        WebUI.clickElement(buttonAddNewProduct);
    }

    public void verifyRedirectNewProductPageSuccess() {
        Assert.assertTrue(driver.findElement(headerNewProduct).isDisplayed(), "Không tìm thấy header page");
        Assert.assertEquals(driver.findElement(headerNewProduct).getText(), "Add New Product", "Header màn New Product không đúng");
    }

    public void addProduct(String productName) {
        WebUI.setText(inputProductName, productName);
        WebUI.clickElement(dropdownCategoryProduct);
        WebUI.setText(inputSearchCategoryProduct, "Gio qua tet");
        WebUI.sleep(1);
        driver.findElement(inputSearchCategoryProduct).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownBrand);
        WebUI.setText(inputSearchBrand, "test1");
        WebUI.sleep(1);
        driver.findElement(inputSearchBrand).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        WebUI.setText(inputUnit, "VNĐ");
        WebUI.sleep(2);
        driver.findElement(inputWeight).clear();
        WebUI.setText(inputWeight, "0.3");
        WebUI.sleep(2);
        driver.findElement(inputMinPurchaseQty).clear();
        WebUI.setText(inputMinPurchaseQty, "100");
        WebUI.sleep(2);
        WebUI.setText(inputTags, "S");
        driver.findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        WebUI.setText(inputTags, "M");
        driver.findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        driver.findElement(inputUnitPrice).clear();
        WebUI.setText(inputUnitPrice, "250,000");
        WebUI.sleep(2);
        driver.findElement(inputDiscount).clear();
        WebUI.setText(inputDiscount, "0");
        WebUI.sleep(2);
        driver.findElement(inputQuantity).clear();
        WebUI.setText(inputQuantity, "100");
        WebUI.sleep(2);
        WebUI.clickElement(buttonSavePublish);
    }
    public void verifyAddProductSuccess() {
        Assert.assertTrue(driver.findElement(messageSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(driver.findElement(messageSuccess).getText(), "Product has been inserted successfully", "Nội dung message không chính xác");
    }
    public void clickButtonAllProducts() {
        WebUI.clickElement(buttonAllProducts);
    }

    public void verifyRedirectAllProductPageSuccess() {
        Assert.assertTrue(driver.findElement(headerAllProducts).isDisplayed(), "Không tìm thấy header page");
        Assert.assertEquals(driver.findElement(headerAllProducts).getText(), "All products", "Header màn All Products không đúng");
    }

    public void searchProduct(String productName) {
        WebUI.clickElement(headerAllProducts);
        WebUI.setText(inputSearchProduct,productName);
        driver.findElement(inputSearchProduct).sendKeys(Keys.ENTER);
    }
    public void clickButtonEditProducts() {
        WebUI.clickElement(firstIconProductEdit);
    }

    public void editProduct(String productName) {
        driver.findElement(inputProductName).clear();
        WebUI.setText(inputProductName, productName);
        WebUI.sleep(3);

        WebUI.clickElement(dropdownCategoryProduct);
        WebUI.setText(inputSearchCategoryProduct, "Gio qua tet");
        WebUI.sleep(1);
        driver.findElement(inputSearchCategoryProduct).sendKeys(Keys.ENTER);
        WebUI.sleep(2);

        WebUI.clickElement(dropdownBrand);
        WebUI.setText(inputSearchBrand, "test1");
        WebUI.sleep(1);
        driver.findElement(inputSearchBrand).sendKeys(Keys.ENTER);
        WebUI.sleep(2);

        driver.findElement(inputUnit).clear();
        WebUI.setText(inputUnit, "VNĐ");

        driver.findElement(inputWeight).clear();
        WebUI.setText(inputWeight, "0.3");
        WebUI.sleep(2);

        driver.findElement(inputMinPurchaseQty).clear();
        WebUI.setText(inputMinPurchaseQty, "100");
        WebUI.sleep(2);

        WebUI.setText(inputTags, "S");
        driver.findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.sleep(1);

        driver.findElement(inputUnitPrice).clear();
        WebUI.sleep(1);
        WebUI.setText(inputUnitPrice, "200");

        driver.findElement(inputDiscount).clear();
        WebUI.setText(inputDiscount, "0");
        WebUI.sleep(2);

//        driver.findElement(inputQuantity).clear();
//        WebUI.setText(inputQuantity, "100");
//        WebUI.sleep(2);

        WebUI.clickElement(buttonUpdateProduct);
    }

    public void verifyEditProductSuccess() {
        Assert.assertTrue(driver.findElement(msgUpdateProductSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(driver.findElement(msgUpdateProductSuccess).getText(), "Product has been updated successfully", "Nội dung message không chính xác");
    }
    /*Viết thêm hàm search data table cho Product page và Category page */
    public void searchDataProductTable(String companyName) {
        WebUI.setText(inputSearchProduct, companyName);
        driver.findElement(inputSearchProduct).sendKeys(Keys.ENTER);
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

        WebElement table = driver.findElement(By.id("sort_products")); // Thay thế bằng selector phù hợp

        // Lấy danh sách các thẻ <tr> trong bảng
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Đếm số hàng
        int rowCount = rows.size();

        int productInPage = rowCount-1;
        int total = productInPage * (totalpage -1);

        WebElement lastLi = liElements.get(totalpage);
        lastLi.click();
        WebUI.sleep(2);
        WebElement tablelast = driver.findElement(By.id("sort_products")); // Thay thế bằng selector phù hợp

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
