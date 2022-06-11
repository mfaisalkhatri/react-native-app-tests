package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.mobileautomation.pages.android.BrowserPage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.GeoLocationPage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.HomePage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.SpeedTestPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertTrue;

public class AndroidTests extends BaseTest{

    private HomePage homePage;
    private BrowserPage browserPage;
    private GeoLocationPage geoLocationPage;
    private SpeedTestPage speedTestPage;

    @BeforeClass
    public void setupTest () {
        homePage = new HomePage (driverManager);
        browserPage = new BrowserPage (driverManager);
        geoLocationPage = new GeoLocationPage (driverManager);
        speedTestPage = new SpeedTestPage (driverManager);

    }

    @Test
    public void textTests () {
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        clickOn (homePage.textBtn ());
        assertEquals (homePage.getText (), "Proverbial");
    }

    @Test
    public void notificationTest() {
        clickOn (homePage.notificationBtn ());
        assertTrue (homePage.notificationBar ().isDisplayed ());
        clickOn (homePage.notificationBar ());
    }

    @Test
    public void toastMessageTest () {
        clickOn (homePage.toastBtn ());
        assertEquals (homePage.toastMessage (), "Toast should be visible");
    }

    @Test
    public void geoLocationTest () {
        clickOn (homePage.geoLocationBtn ());
        assertTrue (geoLocationPage.content ()
            .isDisplayed ());
        geoLocationPage.navigateToHomePage ();
    }

    @Test
    public void speedTestPageTest () {
        clickOn (homePage.speedtTestBtn ());
        assertTrue (speedTestPage.headerText ().isDisplayed ());
        speedTestPage.navigateToHomePage ();
    }

    @Test
    public void browserTest () {
        clickOn (homePage.browserMenu ());
        browserPage.searchFor ("https://lambdatest.com");
    }
}
