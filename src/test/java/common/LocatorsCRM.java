package common;




public class LocatorsCRM {


    public static String headerLogin = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[@type='submit']";
    public static String menuDashboard = "//span[normalize-space()='Dashboard']";
    public static String menuProduct = "//ul[@id='main-menu']/descendant::span[normalize-space()='Products']";
    public static String menuCategory = "//ul[@id='main-menu']/descendant::a[@href='https://cms.anhtester.com/admin/categories']";
    public static String headerCategory = "//h1[normalize-space()='All categories']";
    public static String buttonCreateCategory = "//a[@href='https://cms.anhtester.com/admin/categories/create']";
    public static String headerAddNewCategory = "//h5[normalize-space()='Category Information']";
    public static String textBoxName = "//input[@id='name']";
    public static String dropListParentCategory = "//select[@name='parent_id']/following-sibling::button";
    public static String parentCategorySearch = "//select[@name='parent_id']/following-sibling::div//input";
    public static String textBoxOrderNumber = "//div/input[@id='order_level']";
    public static String dropListType = "//select[@name='digital']/following-sibling::button";
    public static String bannerImage = "(//div/label[@for='signinSrEmail']/following-sibling::div//div[normalize-space()='Browse'])[1]";
    public static String bannerImageAddFile = "//div//button[normalize-space()='Add Files']";
    public static String iconImage = "(//div/label[@for='signinSrEmail']/following-sibling::div//div[normalize-space()='Browse'])[3]";
    public static String iconImageAddFile = "//div//button[normalize-space()='Add Files']";
    public static String metaTitleTextbox = "//div/label[normalize-space()='Meta Title']/following-sibling::div/input";
    public static String metaDescription = "//div/textarea[@name='meta_description']";
    public static String dropListFilteringAttributes = "//select[@name='filtering_attributes[]']/following-sibling::button";
    public static String saveButton = "//div/button[@type='submit']";
    public static String addSuccessMessage = "//span[normalize-space()='Category has been inserted successfully']";
    public static String buttonEditCategory = "(//a[contains(@href,'https://cms.anhtester.com/admin/categories/edit/')])[1]";
    public static String editSuccessMessage = "//div/span[normalize-space()='Category has been updated successfully']";
    public static String buttonDeleteCategory = "(//a[contains(@data-href,'https://cms.anhtester.com/admin/categories/destroy/')])[1]";
    public static String deleteSuccessMessage = "//div/span[normalize-space()='Category has been deleted successfully']";
    //Add new Product
    //Product Information
    public static String menuAddNewProduct = "//span[normalize-space()='Add New Product']";
    public static String titleNewProductPage = "//h5[normalize-space()='Add New Product']";
    public static String inputProductName = "//label[contains(normalize-space(),'Product Name')]/following-sibling::div/input";
    public static String dropdownCategoryProduct ="//label[.='Category *']/following-sibling::div/div";
    public static String inputSearchCategoryProduct = "//div[@id='category']//input";
    public static String dropdownBrand = "//button[@data-id='brand_id']";
    public static String inputSearchBrand = "//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']";
    public static String inputUnit = "//input[@name='unit']";
    public static String inputWeight = "//input[@name='weight']";
    public static String inputMinPurchaseQty = "//input[@name='min_qty']";
    public static String inputTags = "//span[@role='textbox']";
    //product image
    public static String selectGalleryImages ="//label[.='Gallery Images (600x600)']/following-sibling::div/div[@data-type='image']";
    public static String selectThumbnailImages ="//label[contains(.,'Thumbnail Image')]/following-sibling::div/div[@data-type='image']";
    //Product Videos
    public static String inputVideoProvider = "//button[@data-id='video_provider']";
    public static String inputLinkVideo = "//input[@name='video_link']";
    //Product Variation
    public static String buttonEnableColors="//div[@class='col-md-1']//span";
    public static String dropdownColors = "//button[@data-id='colors']";
    public static String  selectColor1 ="//a[@id='bs-select-4-0']";
    public static String  selectColor2 ="//a[@id='bs-select-4-1']";
    public static String  selectColor3="//a[@id='bs-select-4-2']";
    public static String dropdownAttributes = "//button[@data-id='choice_attributes']";
    public static String inputSearchAttributes="//div[@class='dropdown-menu show']//input[@aria-label='Search']";

    //Product price + stock
    public static String inputUnitPrice = "//input[@name='unit_price']";
    public static String inputDiscountRangeDate = "//input[@placeholder='Select Date']";
    public static String inputDiscount = "//input[@name='discount']";
    public static String inputQuantity = "//input[@name='current_stock']";
    public static String inputSku = "//input[@name='sku']";
    public static String inputExternalLinks = "//input[@name='external_link']";
    public static String inputExternalLinkButtonText = "//input[@name='external_link_btn']";
    //Product Description
    public static String inputDescription = "//input[@name='min_qty']";
    //PDF Specification
    public static String uploadFilePDF = "//div[@data-type='document']";
    //Button Save
    public static String buttonSavePublish ="//button[normalize-space()='Save & Publish']";
    public static String buttonSaveUnpublish ="//button[normalize-space()='Save & Publish']";
}