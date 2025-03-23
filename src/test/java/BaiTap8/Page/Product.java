package BaiTap8.Page;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
}
