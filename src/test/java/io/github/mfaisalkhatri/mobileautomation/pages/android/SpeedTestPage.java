package io.github.mfaisalkhatri.mobileautomation.pages.android;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;

public class SpeedTestPage {

    private AndroidDriverManager driverManager;

    public SpeedTestPage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement headerText () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Speedtest"));
    }

    public void navigateToHomePage () {
        driverManager.getDriver ()
            .navigate ()
            .back ();
    }

}
