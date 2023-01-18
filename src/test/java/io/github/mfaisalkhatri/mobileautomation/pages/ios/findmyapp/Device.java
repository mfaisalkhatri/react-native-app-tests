package io.github.mfaisalkhatri.mobileautomation.pages.ios.findmyapp;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Faisal Khatri
 * @since 1/12/2023
 **/
public class Device {

    DriverManager driverManager;

    public Device (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void openFindMyApp () {
        driverManager.getDriver ()
            .findElement (AppiumBy.iOSNsPredicateString ("label==\"Find My\""))
            .click ();
    }
}
