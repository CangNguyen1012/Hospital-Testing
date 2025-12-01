package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //    define attribute
//    selenium => WebDriver
    private WebDriver driver;

    //    define các element trong Login page
//    form username
    private By usernameField = By.name("username");
    //    form password
    private By passwordField = By.name("password");
    //    button login
    private By loginButton = By.xpath("//button[@type='submit' or text()='Login']");
    //    endpoint của page login
    private String loginUrl = "https://demo6.cybersoft.edu.vn/login";

    //    Hàm khởi tạo
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //    Hàm mở trang login
    public void openLoginPage() {
        driver.get(loginUrl);
    }

    //    Hàm nhập username vào form input
    public void enterUsername(String username) {
//        B1: tìm element input username trên web
        WebElement usernameElement = driver.findElement(usernameField);
//        B2: Xóa dữ lieu cu tren form input neu co
        usernameElement.clear();
//        B3: Nhap username vao form input
        usernameElement.sendKeys(username);
    }

    //    Hàm nhập password vào form password
    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    //    Hàm click button login
    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    //    hàm login để tong hop cac buoc login
    public void login(String username, String password) {
        openLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    //    hàm get endpointUrl
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}