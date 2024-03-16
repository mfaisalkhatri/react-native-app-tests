package io.github.mfaisalkhatri.mobileautomation.pages.ios.findmyapp;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;

/**
 * @author Faisal Khatri
 * @since 1/12/2023
 **/
public class Device {

    private final IOSDriverManager iosDriverManager;

    public Device(final IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
    }

    public void openFindMyApp () {
        iosDriverManager.getDriver()
            .findElement (AppiumBy.iOSNsPredicateString ("label==\"Find My\""))
            .click ();
    }
}
