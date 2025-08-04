package io.github.mfaisalkhatri.mobileautomation.pages.android;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static io.github.mfaisalkhatri.utilities.Helper.waitForSomeTime;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;

public class BrowserPage {

    private final AndroidDriverManager driverManager;

    public BrowserPage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement findBtn () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("find"));
    }

    public void navigateToHomePage () {
        this.driverManager.getDriver ()
            .navigate ()
            .back ();
    }

    public WebElement searchBox () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("url"));
    }

    public void searchFor (final String url) {
        searchBox ().sendKeys (url);
        clickOn (findBtn ());
        waitForSomeTime ();
    }
}