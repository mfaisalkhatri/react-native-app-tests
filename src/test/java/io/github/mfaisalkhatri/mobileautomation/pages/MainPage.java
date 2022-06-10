package io.github.mfaisalkhatri.mobileautomation.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.github.mfaisalkhatri.drivers.DriverManager;


public class MainPage {

    DriverManager driverManager;

    public MainPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public MobileElement textButton() {
      return  driverManager.getDriver ().findElement (MobileBy.id ("Text"));
    }

    public String getText() {
        return driverManager.getDriver ().findElement (MobileBy.id ("Textbox")).getText ();
    }
}
