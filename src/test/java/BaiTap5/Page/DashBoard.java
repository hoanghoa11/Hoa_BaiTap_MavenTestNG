package BaiTap5.Page;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashBoard {
    private WebDriver driver;

    public DashBoard(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By dropdownProfile = By.xpath("//a[@class='dropdown-toggle no-arrow text-dark']");
    private By optionLogout = By.xpath("//span[normalize-space()='Logout']");
    private By optionMyProfile = By.xpath("//span[normalize-space()='Profile']");

    public Product clickMenuProduct(){ //Thay thế void = CustomerPage vì để vào đc màn customer thi phải đi qua màn dashboard, customer là trang sẽ lket đến
        WebUI.clickElement(menuProduct);
        System.out.println("Click on menu Product");
        return new Product(driver); // nhớ thêm return nhé
    }
    public Category clickMenuCategory(){
        WebUI.clickElement(menuProduct);
        System.out.println("Click on menu Product");
        WebUI.clickElement(menuCategory);
        System.out.println("Click on menu Category");
        return new Category(driver); // nhớ thêm return nhé
    }
    public Login clickLogout(){
        WebUI.clickElement(dropdownProfile);
        System.out.println("Click on dropdownProfile");
        WebUI.sleep(1);
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");
        return new Login(driver);
    }
}
