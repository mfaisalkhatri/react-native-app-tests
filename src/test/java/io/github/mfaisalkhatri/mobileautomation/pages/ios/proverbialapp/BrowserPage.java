package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static io.github.mfaisalkhatri.utilities.Helper.waitForSomeTime;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.openqa.selenium.WebElement;

public class BrowserPage {

    private final IOSDriverManager iosDriverManager;

    public BrowserPage (final IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
    }

    public WebElement findBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Find"));
    }

    public void navigateToHomePage () {
        this.iosDriverManager.getDriver ()
            .navigate ()
            .back ();
    }

    public WebElement searchBox () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("url"));
    }

    public void searchFor (final String url) {
        searchBox ().sendKeys (url);
        clickOn (findBtn ());
        waitForSomeTime ();
    }

}
