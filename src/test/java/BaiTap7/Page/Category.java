package BaiTap7.Page;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
}
