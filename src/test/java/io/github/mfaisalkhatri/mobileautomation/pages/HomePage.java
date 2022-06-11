package io.github.mfaisalkhatri.mobileautomation.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.github.mfaisalkhatri.drivers.DriverManager;

public class HomePage {

    DriverManager driverManager;

    public HomePage (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public MobileElement textButton () {
        return driverManager.getDriver ()
            .findElement (MobileBy.id ("Text"));
    }

    public String getText () {
        return driverManager.getDriver ()
            .findElement (MobileBy.id ("Textbox"))
            .getText ();
    }

    public MobileElement notificationBtn() {
        return driverManager.getDriver ().findElement (MobileBy.id ("notification"));
    }

    public MobileElement notificationBar() {
        return driverManager.getDriver ().findElement (MobileBy.id ("action_bar"));
    }

    public String getNotificationText () {
        return notificationBar ().getText ();
    }


    public MobileElement toastBtn() {
        return driverManager.getDriver ().findElement (MobileBy.id ("toast"));
    }

    public MobileElement toastMessage () {
        return driverManager.getDriver ().findElement (MobileBy.xpath ("//hierarchy/android.widget.Toast"));
    }
}
