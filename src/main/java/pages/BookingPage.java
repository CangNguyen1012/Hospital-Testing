package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {
//    viet test case cho flow booking lich kham
//    B1: login voi account patient

//    B2: tim menu "Dat lich kham: trong HomePage va click vao menu do

//    B3: select chi nhanh muon kham

//    B4: select doctor o chi nhanh da chon

//    B5: pick ngay kham - November 30, 2025

//    B6: pick gio kham -  06:00 - 17:00

//    B7: chon goi kham benh

//    B8: booking lich kham

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    //    Tim element
//    menu dat lich kham
//    <a class="nav-link text-secondary" href="/booking" data-discover="true">Đặt lịch khám</a>
//    //a -> tim tat ca nhung the a co trong HTML
//    [...] -> liet ke nhung dieu kien de tim element muon lay
    private By BookingMenuLink = By.xpath("//a[text()='Đặt lịch khám' and @href='/booking']");

    //    <div class="mb-3">
//        <label class="form-label">Chi nhánh</label>
//        <select class="form-select">
//            <option value="">Chọn chi nhánh</option>
//            <option value="1">Chi nhánh trung tâm</option>
//        </select>
//    </div>
//    //label[text()='Chi nhánh']/../select
//    /.. -> di den 1 cap, tuc la den the cha cua label
//    /select -> tu the cha, tim the select
    private By branchSelect = By.xpath("//label[text()='Chi nhánh']/../select");

    private By dodtorSelect = By.xpath("//label[text()='Bác sĩ']/../select");

    //    <abbr aria-label="November 30, 2025">30</abbr>
//    %s: placeholder de truyen gia tri vao string
//    private static final String dateAppointment = "//button[.//abbr[@aria-label='%s' and text()='%s']]";
    private static final String dateAppointment = "//button[.//abbr[contains(@aria-label,'%s') and text()='%s']]";
//    private By dateAppointment = By.xpath("//button[.//abbr[@aria-label='%s' and text()='%s']]");

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    //    B1: login (dung lai tu LoginPage)
//    B2: ham openBookingFromMenu
    public void openBookingFromMenu() throws Exception {
//        Tim va click vao menu booking
//        C1: dung ham findElement
//        Thread.sleep(2000);
//        WebElement bookingMenu = driver.findElement(BookingMenuLink);
//        bookingMenu.click();
//        C2: explicitWait
        WebElement bookingMenuEx = wait.until(ExpectedConditions.elementToBeClickable(BookingMenuLink));
        bookingMenuEx.click();
    }

    public void selectBranch(String branchName) {
        WebElement branchElement = wait.until(ExpectedConditions.presenceOfElementLocated(branchSelect));
//        scroll xuong cai element muon xet
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", branchElement);
        Select select = new Select(branchElement);
        select.selectByVisibleText(branchName);
    }

    public void selectDoctor(String doctorName) {
        WebElement doctorElement = wait.until(ExpectedConditions.presenceOfElementLocated(dodtorSelect));
//        scroll xuong cai element muon xet
//        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", doctorElement);
        Select select = new Select(doctorElement);
        select.selectByVisibleText(doctorName);
    }

    public void pickDateAppointment(String date) throws Exception {
//        B1: mapping date vao xpath
//        date: November 30, 2025
//        => 30
//        November 30, 2025 => ['November', '30', '2025']

        String[] parts = date.split(" ");
//        '30,' => '30'
        String day = parts[1].replace(",", "");
        String appointmentXpath = String.format(dateAppointment, date, day);

        WebElement appointmentElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(appointmentXpath)));
        appointmentElement.click();
    }

}
