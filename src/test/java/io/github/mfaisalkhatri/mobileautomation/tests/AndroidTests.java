package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.mobileautomation.pages.android.BrowserPage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.GeoLocationPage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.HomePage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.SpeedTestPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        takeScreenshot ();
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

    public void takeScreenshot () {
        Date date = new Date ();
        SimpleDateFormat format = new SimpleDateFormat ("dd_MM_YYYY_HH_mm");

        File scrFile = ((TakesScreenshot) driverManager.getDriver ()).getScreenshotAs (OutputType.FILE);
        try {
            FileUtils.copyFile (scrFile, new File ("./screenshot_" + format.format (date.getTime ()) + ".png"));
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
}
