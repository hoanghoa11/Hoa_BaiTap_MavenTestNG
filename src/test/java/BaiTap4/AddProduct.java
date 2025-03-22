package BaiTap4;

import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AddProduct extends BaseTest {


    public String CATEGORY_NAME = "Gio qua Tet 1";


    @Test
    public void addNewProduct() throws AWTException {
        createBrowser();
        //Log in
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
//        addNewCategory();
        driver.findElement(By.xpath(LocatorsCRM.menuProduct)).click();
        driver.findElement(By.xpath(LocatorsCRM.menuCategory)).click();
        driver.findElement(By.xpath(LocatorsCRM.menuAddNewProduct)).click();

        //Nhap data vao man
        driver.findElement(By.xpath(LocatorsCRM.inputProductName)).sendKeys("Giỏ quà Tết 1");

        driver.findElement(By.xpath(LocatorsCRM.dropdownCategoryProduct)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCategoryProduct)).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCategoryProduct)).sendKeys(Keys.ENTER);
        sleep(2);

        driver.findElement(By.xpath(LocatorsCRM.inputUnit)).sendKeys("VNĐ");

        WebElement inputField = driver.findElement(By.xpath(LocatorsCRM.inputMinPurchaseQty));
        inputField.clear();//xoa gia tri mac dinh ban dau cua trg
        inputField.sendKeys("200");
        sleep(1);

        //Tạo  3 trường Tags
        /*Cách 1: Tạo bthg
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).sendKeys("S");
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).sendKeys("M");
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).sendKeys("L");
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).sendKeys(Keys.ENTER);
        sleep(1); */
        //Cách 2 sử dụng Robot Class
        driver.findElement(By.xpath(LocatorsCRM.inputTags)).click();
        Robot robot = new Robot();
        robot.setAutoDelay(100); // phải có delay, nếu k có delay kQ là s, sm , sml
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Cuon chuot sd Action Class
        WebElement element1 = driver.findElement(By.xpath(LocatorsCRM.dropdownAttributes));
        Actions actions = new Actions(driver);
        actions.scrollToElement(element1).perform();
        sleep(1);

        driver.findElement(By.xpath(LocatorsCRM.buttonEnableColors)).click();
        sleep(1);

        String COLOR_NAME = "3 items selected"; //Sử dụng biến toàn cục
        driver.findElement(By.xpath(LocatorsCRM.dropdownColors)).click();
        driver.findElement(By.xpath(LocatorsCRM.selectColor3)).click();
        driver.findElement(By.xpath(LocatorsCRM.selectColor1)).click();
        driver.findElement(By.xpath(LocatorsCRM.selectColor2)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownColors)).click();
        sleep(1);
        //Kiem tra Text của item sau khi chọn xem đúng không
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.dropdownColors)).getText(),COLOR_NAME);
        sleep(3);

        driver.findElement(By.xpath(LocatorsCRM.inputUnitPrice)).sendKeys("100");
        driver.findElement(By.xpath(LocatorsCRM.inputDiscount)).sendKeys("10%");
        sleep(1);
        //driver.findElement(By.xpath(LocatorsCRM.inputQuantity)).sendKeys("10"); // khi chọn màu color thì trường Quatity bị mất đi

        //Cuon chuot xuong cuoi man de click nút Save & Publish
        WebElement element2 = driver.findElement(By.xpath(LocatorsCRM.buttonSavePublish));
        actions.scrollToElement(element2).perform();
        sleep(2);
        driver.findElement(By.xpath(LocatorsCRM.buttonSavePublish)).click();
        closeBrowser();
    }
}
