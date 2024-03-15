package io.github.mfaisalkhatri.mobileautomation.tests.android;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected AndroidDriverManager androidDriverManager;

    @Parameters({"buildName", "testName", "app", "platformName", "platformVersion", "deviceName"})
    @BeforeClass
    public void setupTest(final String buildName, final String testName, @Optional("app") final String app, final String platformName, final String platformVersion,
                          final String deviceName) {

        this.androidDriverManager = AndroidDriverManager.builder()
                .buildName(buildName)
                .testName(testName)
                .app(app)
                .platformName(platformName)
                .platformVersion(platformVersion)
                .deviceName(deviceName)
                .build()
                .createAndroidDriver();
    }

    @AfterClass
    public void tearDown() {
        this.androidDriverManager.quitDriver();
    }
}
