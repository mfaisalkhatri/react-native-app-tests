package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;

public class SpeedTestPage {

    private final IOSDriverManager iosDriverManager;

    public SpeedTestPage (final IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
    }

    public String headerText () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.iOSClassChain ("**/XCUIElementTypeImage[`label == \"Speedtest\"`]"))
            .getText ();
    }

    public void navigateToHomePage () {
        this.iosDriverManager.getDriver ()
            .navigate ()
            .back ();
    }
}
