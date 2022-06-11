package io.github.mfaisalkhatri.mobileautomation.tests;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.mobileautomation.pages.ios.BrowserPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.GeoLocationPage;
import io.github.mfaisalkhatri.mobileautomation.pages.ios.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IOSTests extends BaseTest{

    private HomePage homePage;
    private GeoLocationPage geoLocationPage;
    private BrowserPage     browserPage;

    @BeforeClass
    public void setupTest () {
        homePage = new HomePage (driverManager);
        geoLocationPage = new GeoLocationPage (driverManager);
        browserPage = new BrowserPage (driverManager);
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
    }

    @Test
    public void toastMessageTest () {
        clickOn (homePage.toastBtn ());
//        assertEquals (homePage.toastMessage (), "Toast should be visible");
    }

    @Test
    public void geoLocationTest () {
        clickOn (homePage.geoLocationBtn ());
        assertTrue (geoLocationPage.banner ().isDisplayed ());
        geoLocationPage.navigateToHomePage ();
    }

    @Test
    public void speedTest() {

    }

    @Test
    public void browserTest () {
        clickOn (homePage.browserMenu ());
        browserPage.searchFor ("https://lambdatest.com");
        browserPage.navigateToHomePage ();
    }


}
