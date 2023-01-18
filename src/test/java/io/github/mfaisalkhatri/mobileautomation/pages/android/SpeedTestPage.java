package io.github.mfaisalkhatri.mobileautomation.pages.android;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.WebElement;

public class SpeedTestPage {

    private DriverManager driverManager;

    public SpeedTestPage (final DriverManager driverManager) {
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
