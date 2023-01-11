package io.github.mfaisalkhatri.mobileautomation.pages.ios;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;

public class SpeedTestPage {

    DriverManager driverManager;

    public SpeedTestPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String headerText () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.iOSClassChain ("**/XCUIElementTypeImage[`label == \"Speedtest\"`]"))
            .getText ();
    }

    public void navigateToHomePage () {
        driverManager.getDriver ()
            .navigate ()
            .back ();
    }
}
