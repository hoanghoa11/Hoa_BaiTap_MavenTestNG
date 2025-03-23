package BaiTap7.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    private String url = "https://cms.anhtester.com/login";
    //Khai bao bien
    private WebDriver driver;
    private WebDriverWait wait;

    //Tao ham xay dung
    public Login(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //khai bao tat ca cac object(element) tren page nay
    By headerLoginPage = By.xpath("//h1[@class='h3 text-primary mb-0']");
    By descriptionLoginPage = By.xpath("//p[normalize-space()='Login to your account.']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By checkboxRememberMe = By.xpath("//label[@class='aiz-checkbox']");
    By linkForgotPW = By.xpath("//a[normalize-space()='Forgot password ?']");
    By errorEmailMessage = By.xpath("//span[@data-notify='message']");
    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");


    //XD cac ham xu ly chinh tren trang nay
    private void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
        System.out.println("Set email value: " + email);
    }

    private void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
        System.out.println("Set password value: " + password);
    }

    private void clickbuttonLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    private void clickCheckboxRemember() {
        driver.findElement(checkboxRememberMe).click();
    }

    private void clickLinkForgotPW() {
        driver.findElement(linkForgotPW).click();
    }

    public DashBoard LoginCMS(String email, String password) {
        driver.get(url);
        enterEmail(email);
        enterPassword(password);
        clickbuttonLogin();
        return new DashBoard(driver);
    }

    public void LoginCMS_SelectCheckboxRemember(String email, String password) {
        driver.get(url);
        enterEmail(email);
        enterPassword(password);
        clickCheckboxRemember();
        clickbuttonLogin();
    }

    public void LoginCMS_ForgotPW(String email, String password) {
        driver.get(url);
        enterEmail(email);
        enterPassword(password);
        clickLinkForgotPW();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(driver.findElement(menuDashBoard).isDisplayed());
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.findElement(errorEmailMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(errorEmailMessage).getText(), "Invalid login credentials");
    }

    public void verifyLoginFail_WithNullEmailField() {
        WebElement inputElement = driver.findElement(inputEmail);
        String validationMessage = inputElement.getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Email field not match.");
    }

    public void verifyLoginFail_WithNullPasswordField() {
        WebElement inputElement = driver.findElement(inputPassword);
        String validationMessage = inputElement.getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Password field not match.");
    }

    public void verifyCheckbox() {
        // Kiểm tra xem checkbox đã được chọn hay chưa
        boolean isChecked = (driver.findElement(checkboxRememberMe).isSelected());
        // Sử dụng assert để kiểm tra điều kiện
        Assert.assertTrue(isChecked, "checkbox chưa được chọn");
    }

    public void verifyNavigateForgotPW() {
        Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Send Password Reset Link']")).isDisplayed());
    }
    public void verifyRedirectLoginPage() {
        Assert.assertTrue(driver.findElement(headerLoginPage).isDisplayed()
                && driver.findElement(descriptionLoginPage).isDisplayed());
        Assert.assertEquals(driver.findElement(headerLoginPage).getText(),"Welcome to Active eCommerce CMS", "Header of Login Page not match");
        Assert.assertEquals(driver.findElement(descriptionLoginPage).getText(),"Login to your account.","Description of Login Page not match");
    }
}
