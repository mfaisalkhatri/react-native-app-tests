package io.github.mfaisalkhatri.mobileautomation.tests.ios;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.mobileautomation.pages.ios.findmyapp.Device;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.findmyapp.MainPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp.BrowserPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp.GeoLocationPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp.HomePage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp.SpeedTestPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IOSTests extends BaseTest {

    private BrowserPage     browserPage;
    private GeoLocationPage geoLocationPage;
    private HomePage        homePage;
    private SpeedTestPage   speedTestPage;

    @Test
    public void browserTest () {
        clickOn (this.homePage.browserMenu ());
        this.browserPage.searchFor ("https://lambdatest.com");
    }

    @Test
    public void findMyAppTest () {
        final Device device = new Device (this.iosDriverManager);
        device.openFindMyApp ();
        final MainPage mainPage = new MainPage (this.iosDriverManager);
        assertTrue (mainPage.isDevicesBtnDisplayed ());
    }

    @Test
    public void geoLocationTest () {
        clickOn (this.homePage.geoLocationBtn ());
        assertTrue (this.geoLocationPage.banner ()
            .isDisplayed ());
        this.geoLocationPage.navigateToHomePage ();
    }

    @Test
    public void notificationTest () {
        clickOn (this.homePage.notificationBtn ());
        assertTrue (this.homePage.notificationBar ()
            .isDisplayed ());
        //        final NotificationPage notificationPage = new NotificationPage (this.iosDriverManager);
        //        notificationPage.openNotificationPanel ();
        //        assertTrue (notificationPage.getNotificationText ()
        //            .contains ("Test Notification, Please enjoy this notification"));

    }

    @BeforeClass
    public void setupTest () {
        this.homePage = new HomePage (this.iosDriverManager);
        this.geoLocationPage = new GeoLocationPage (this.iosDriverManager);
        this.browserPage = new BrowserPage (this.iosDriverManager);
        this.speedTestPage = new SpeedTestPage (this.iosDriverManager);
    }

    @Test
    public void speedTestPageTest () {
        clickOn (this.homePage.speedTestBtn ());
        assertEquals (this.speedTestPage.headerText (), "Speedtest");
        this.speedTestPage.navigateToHomePage ();
    }

    @Test
    public void textTests () {
        assertEquals (this.homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        clickOn (this.homePage.textBtn ());
        assertEquals (this.homePage.getText (), "Proverbial");
    }

    @Test
    public void toastMessageTest () {
        clickOn (this.homePage.toastBtn ());

    }
}
