package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected DriverManager driverManager;

    @Parameters ({ "buildName", "testName", "app", "platformName", "version", "device" })
    @BeforeClass
    public void setupTest (String buildName, String testName, String app, Platform platform, String platformVersion,
        String deviceName) {

        driverManager = DriverManager.builder ()
            .buildName (buildName)
            .testName (testName)
            .app (app)
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
