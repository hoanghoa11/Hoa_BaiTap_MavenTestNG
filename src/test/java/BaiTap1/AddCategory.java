package BaiTap1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AddCategory {
    public static WebDriver driver;

    public static void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    public static void closeDriver() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        //Open driver
        createDriver();

        driver.get("https://cms.anhtester.com/login");

        //Log in vào CMS
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Add category
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='main-menu']/descendant::span[normalize-space()='Products']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='main-menu']/descendant::a[@href='https://cms.anhtester.com/admin/categories']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='https://cms.anhtester.com/admin/categories/create']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Giỏ quà bánh Tết");

        driver.findElement(By.xpath("//select[@name='parent_id']/following-sibling::button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name='parent_id']/following-sibling::div//input")).sendKeys("Gio qua Tet");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='parent_id']/following-sibling::div//descendant::span)[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div/input[@id='order_level']")).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@name='digital']/following-sibling::button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//select[@name='digital']/following-sibling::div//a)[1]")).click();

        driver.findElement(By.xpath("(//div/label[@for='signinSrEmail']/following-sibling::div//div[normalize-space()='Browse'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("Cosy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='Cosy.png') and (@data-value=2601)]")).click();
        driver.findElement(By.xpath("//div//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//div/label[@for='signinSrEmail']/following-sibling::div//div[normalize-space()='Browse'])[3]")).click();
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/descendant::input[@name='aiz-uploader-search']")).sendKeys("hoa tuyết mai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[(@title='hoa tuyết mai.png') and (@data-value=2618)]")).click();
        driver.findElement(By.xpath("//div//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div/label[normalize-space()='Meta Title']/following-sibling::div/input")).sendKeys("ABC");

        driver.findElement(By.xpath("//div/textarea[@name='meta_description']")).sendKeys("This is test");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@name='filtering_attributes[]']/following-sibling::button")).click();
        driver.findElement(By.xpath("//ul[@role='presentation']/descendant::a[@id='bs-select-3-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name='filtering_attributes[]']/following-sibling::button")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();

        //Kiểm tra lại category vừa add
        driver.findElement(By.xpath("//div/input[@id='search']")).sendKeys("Giỏ quà bánh Tết");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //Get text kết quả trường Name ở dòng đầu tiên
        Thread.sleep(2000);
        if((driver.findElement(By.xpath("(//div[normalize-space()='Categories']/following-sibling::div//td)[2]")).getText()).equals("Giỏ quà bánh Tết")){
            System.out.println("Tạo mới category thành công");
        } else {
            System.out.println("Category chưa được tạo thành công");
        }

        //Close driver
        closeDriver();
    }
}
