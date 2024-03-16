package io.github.mfaisalkhatri.mobileautomation.tests.android;

import io.appium.java_client.Location;
import io.github.mfaisalkhatri.mobileautomation.pages.android.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AndroidTests extends BaseTest {

    private HomePage homePage;
    private BrowserPage browserPage;
    private GeoLocationPage geoLocationPage;
    private SpeedTestPage speedTestPage;

    @BeforeClass
    public void setupTest() {
        this.homePage = new HomePage(this.androidDriverManager);
        this.browserPage = new BrowserPage(this.androidDriverManager);
        this.geoLocationPage = new GeoLocationPage(this.androidDriverManager);
        this.speedTestPage = new SpeedTestPage(this.androidDriverManager);

    }

    @Test
    public void textTests() {
        assertEquals(this.homePage.getText(), "Hello! Welcome to lambdatest Sample App called Proverbial");
        clickOn(this.homePage.textBtn());
        assertEquals(this.homePage.getText(), "Proverbial");
    }

    @Test
    public void notificationTest() {
        takeScreenshot();
        clickOn(this.homePage.notificationBtn());
        assertTrue(this.homePage.notificationBar().isDisplayed());
        clickOn(this.homePage.notificationBar());
    }

    @Test
    public void toastMessageTest() {
        clickOn(this.homePage.toastBtn());
        assertEquals(this.homePage.toastMessage(), "Toast should be visible");
    }

    @Test
    public void geoLocationTest() {
        clickOn(this.homePage.geoLocationBtn());
        assertTrue(this.geoLocationPage.content()
                .isDisplayed());
        this.geoLocationPage.navigateToHomePage();
    }

    @Test
    public void speedTestPageTest() {
        clickOn(this.homePage.speedTestBtn());
        assertTrue(this.speedTestPage.headerText().isDisplayed());
        this.speedTestPage.navigateToHomePage();
    }

    @Test
    public void browserTest() {
        clickOn(this.homePage.browserMenu());
        this.browserPage.searchFor("https://lambdatest.com");
    }

    public void takeScreenshot() {
        final Date date = new Date();
        final SimpleDateFormat format = new SimpleDateFormat("dd_MM_YYYY_HH_mm");

        final File scrFile = ((TakesScreenshot) this.androidDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./screenshot_" + format.format(date.getTime()) + ".png"));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getGeoLocationCoOrdinatesTest() {
        final Location location = this.androidDriverManager.getDriver().getLocation();

        assertEquals(location.getLatitude(), 51.5072);
        assertEquals(location.getLongitude(), 0.1276);
    }

    @Test
    public void testGeoLocation() {
        this.androidDriverManager.getDriver().get("https://iplocation.com/");
        final IPLocationPage ipLocationPage = new IPLocationPage(this.androidDriverManager);
        assertEquals(ipLocationPage.getCountryText(), "United Kingdom");
    }
}
