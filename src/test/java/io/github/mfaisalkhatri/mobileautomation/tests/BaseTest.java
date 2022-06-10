package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected DriverManager driverManager;

    @Parameters ({ "platformName","version","device" })
    @BeforeClass
    public void setupTest (Platform platform, String platformVersion, String deviceName) {
        driverManager = DriverManager.builder ()
            .platform (platform)
            .platformVersion (platformVersion)
            .deviceName (deviceName)
            .build ()
            .createRemoteDriver ();
    }


    @AfterClass
    public void tearDown () {
        driverManager.quitDriver ();
    }
}
