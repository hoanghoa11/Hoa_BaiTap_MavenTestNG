package common;


import com.hoa.drivers.DriverManager;
import com.hoa.drivers.PropertiesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {



    public static WebDriver driver;

    public void sleep(double secord) {
        try {
            Thread.sleep((long) (1000 * secord));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    } @BeforeMethod
    public void createBrowser() {
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public void createBrowser(String browserName) {
        if (browserName.trim().toLowerCase().equals("chrome")) { //chuyen ve chu thuong cat khoang trang o 2   dau
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browserName) {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser("browserName");

        DriverManager.setDriver(driver);
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                //set chrome as Headless
                options.addArguments("--headless");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

//    @BeforeMethod
//    @Parameters({"browser"})
//    public void createDriver(@Optional("chrome") String browser) {
//        setupDriver(browser);
//    }
//    public void setupDriver(String browserName) {
//        if (browserName.trim().toLowerCase().equals("chrome")) { //chuyen ve chu thuong cat khoang trang o 2   dau
//            driver = new ChromeDriver();
//        }
//        if (browserName.trim().toLowerCase().equals("firefox")) {
//            driver = new FirefoxDriver();
//        }
//        if (browserName.trim().toLowerCase().equals("edge")) {
//            driver = new EdgeDriver();
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//    }

    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    @AfterMethod
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }
    public static void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
    }

}