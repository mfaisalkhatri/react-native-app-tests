package io.github.mfaisalkhatri.mobileautomation.tests;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.mobileautomation.pages.ios.BrowserPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.GeoLocationPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.HomePage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.SpeedTestPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IOSTests extends BaseTest {

    private HomePage        homePage;
    private GeoLocationPage geoLocationPage;
    private BrowserPage     browserPage;
    private SpeedTestPage   speedTestPage;

    @BeforeClass
    public void setupTest () {
        homePage = new HomePage (driverManager);
        geoLocationPage = new GeoLocationPage (driverManager);
        browserPage = new BrowserPage (driverManager);
        speedTestPage = new SpeedTestPage (driverManager);
    }

    @Test
    public void textTests () {
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        clickOn (homePage.textBtn ());
        assertEquals (homePage.getText (), "Proverbial");
    }

    @Test
    public void notificationTest () {
        clickOn (homePage.notificationBtn ());
        assertTrue (homePage.notificationBar ()
            .isDisplayed ());
    }

    @Test
    public void toastMessageTest () {
        clickOn (homePage.toastBtn ());

    }

    @Test
    public void geoLocationTest () {
        clickOn (homePage.geoLocationBtn ());
        assertTrue (geoLocationPage.banner ()
            .isDisplayed ());
        geoLocationPage.navigateToHomePage ();
    }

    @Test
    public void speedTestPageTest () {
        clickOn (homePage.speedtTestBtn ());
        assertEquals (speedTestPage.headerText (), "Speedtest");
        speedTestPage.navigateToHomePage ();
    }

    @Test
    public void browserTest () {
        clickOn (homePage.browserMenu ());
        browserPage.searchFor ("https://lambdatest.com");
    }
}
