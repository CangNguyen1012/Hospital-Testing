package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
//        B1: cau hinh ChromeDriver
        WebDriverManager.chromedriver().setup();

//        B2: cau hinh cac tuy chon
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

//        B3: khoi tao ChromeDriver
        driver = new ChromeDriver(options);

//        B4: Doi khoang 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
