package io.github.mfaisalkhatri.mobileautomation.tests.ios;

import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected IOSDriverManager iosDriverManager;

    @Parameters({"buildName", "testName", "app", "platformName", "platformVersion", "deviceName"})
    @BeforeClass
    public void setupTest(final String buildName, final String testName, @Optional("app") final String app, final String platformName, final String platformVersion,
                          final String deviceName) {

        this.iosDriverManager = IOSDriverManager.builder()
                .buildName(buildName)
                .testName(testName)
                .app(app)
                .platformName(platformName)
                .platformVersion(platformVersion)
                .deviceName(deviceName)
                .build()
                .createIOSDriver();
    }

    @AfterClass
    public void tearDown() {
        this.iosDriverManager.quitDriver();
    }

}
