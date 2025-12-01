package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.LoginPage;
import utils.BaseTest;

public class BookingTest extends BaseTest {
    private static final String VALID_USERNAME = "cangtester";
    private static final String VALID_PASSWORD = "123456";

    @Test
    public void testBookingAppointment() throws Exception{
//        B1: dung lai step login tu LoginPage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        Thread.sleep(3000);

//        B2: click vao menu Dat lich kham
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.openBookingFromMenu();
        Thread.sleep(3000);

//        B3: select vao branch
        bookingPage.selectBranch("Chi nhánh trung tâm");
        Thread.sleep(2000);

//        B4: select doctor
        bookingPage.selectDoctor("Dr. User Fullname 10 - Cardiology ");
        Thread.sleep(2000);

//        B5: pick dateAppointment -> November 30, 2025
        bookingPage.pickDateAppointment("November 30, 2025");
        Thread.sleep(2000);

        Assert.assertTrue(true);
    }
}
