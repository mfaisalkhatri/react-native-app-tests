package io.github.mfaisalkhatri.drivers;

import static java.text.MessageFormat.format;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Builder;
import lombok.SneakyThrows;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

@Builder
public class DriverManager {

    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<> ();

    private              String   buildName;
    private              String   testName;
    private              Platform platform;
    private              String   platformVersion;
    private              String   deviceName;
    private              String   app;
    private static final String   LT_USERNAME     = System.getenv ("username");
    private static final String   LT_ACCESS_TOKEN = System.getenv ("token");
    private static final String   GRID_URL        = "@mobile-hub.lambdatest.com/wd/hub";
    private static final String   URL             = "http://localhost:4723/wd/hub";

    @SneakyThrows
    public DriverManager createRemoteDriver () {
        DRIVER.set (new AppiumDriver (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)),
            setCapabilities ()));
        setupDriverTimeouts ();
        return this;
    }

    @SneakyThrows
    public DriverManager createAndroidDriver () {
        DRIVER.set (new AndroidDriver (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)),
            setCapabilities ()));
        setupDriverTimeouts ();
        return this;
    }

    @SneakyThrows
    public DriverManager createIOSDriver () {
        DRIVER.set (new IOSDriver (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)),
            setCapabilities ()));
        setupDriverTimeouts ();
        return this;
    }

    @SuppressWarnings ("unchecked")
    public <D extends AppiumDriver> D getDriver () {
        if (null == DRIVER.get ()) {
            createRemoteDriver ();
        }
        return (D) DRIVER.get ();
    }

    public void quitDriver () {
        if (null != DRIVER.get ()) {
            getDriver ().quit ();
            DRIVER.remove ();
        }
    }

    private void setupDriverTimeouts () {
        getDriver ().manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
    }

    private DesiredCapabilities setCapabilities () {

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        HashMap<String, Object> ltOptions = new HashMap<String, Object> ();
        ltOptions.put ("w3c", true);
        ltOptions.put ("build", buildName);
        ltOptions.put ("name", testName);
        ltOptions.put (MobileCapabilityType.PLATFORM_NAME, platform);
        ltOptions.put (MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        ltOptions.put (MobileCapabilityType.DEVICE_NAME, deviceName);
        ltOptions.put (MobileCapabilityType.APP, app);
        ltOptions.put (IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
        ltOptions.put (IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, true);
        ltOptions.put (AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
       // ltOptions.put ("autoAcceptAlerts", true);
        //ltOptions.put ("autoGrantPermissions", true);
        ltOptions.put (MobileCapabilityType.FULL_RESET, true);
        //ltOptions.put ("autoLaunch", false);
        ltOptions.put ("isRealMobile", true);
        ltOptions.put ("network", true);
        ltOptions.put ("visual", true);
        ltOptions.put ("console", true);
        ltOptions.put ("devicelog", true);
        capabilities.setCapability ("lt:options", ltOptions);
        return capabilities;
    }
}
