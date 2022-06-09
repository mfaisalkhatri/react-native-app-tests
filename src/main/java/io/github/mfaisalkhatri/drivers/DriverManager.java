package io.github.mfaisalkhatri.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Builder;
import lombok.SneakyThrows;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static io.github.mfaisalkhatri.server.ServiceManager.startService;
import static io.github.mfaisalkhatri.server.ServiceManager.stopService;
import static java.text.MessageFormat.format;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.text.MessageFormat;

@Builder
public class DriverManager {

    private static final ThreadLocal<AppiumDriver<MobileElement>> DRIVER = new ThreadLocal<> ();

    private              Platform platform;
    private              String   platformVersion;
    private              String   deviceName;
    private static final String   LT_USERNAME     = System.getenv ("username");
    private static final String   LT_ACCESS_TOKEN = System.getenv ("token");
    private static final String   GRID_URL        = "@mobile-hub.lambdatest.com/wd/hub";
    private static final String   URL             = "http://localhost:4723/wd/hub";

    @SneakyThrows
    public DriverManager createRemoteDriver () {
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("build", "Remote build ");
        capabilities.setCapability ("name", "Proverbial apk tests");
        capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability (MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability (MobileCapabilityType.APP, "lt://APP100202361654757345879208");
        capabilities.setCapability ("isRealMobile", true);
        capabilities.setCapability ("network", true);
        capabilities.setCapability ("visual", true);
        capabilities.setCapability ("console", true);
        capabilities.setCapability ("devicelog", true);
        DRIVER.set (new AppiumDriver<> (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)),
            capabilities));
        return this;
    }

    @SneakyThrows
    public DriverManager createAndroidDriver () {
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("build", "android");
        capabilities.setCapability ("name", "Proverbial apk tests");
        capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability (MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, deviceName);
        DRIVER.set (new AndroidDriver<> (new URL (format ("https://{0}", URL)), capabilities));
        return this;
    }

    @SneakyThrows
    public DriverManager createiOSDriver () {
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("build", "IOS");
        capabilities.setCapability ("name", "Proverbial IOS tests");
        capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability (MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, deviceName);
        DRIVER.set (new IOSDriver<> (new URL (format ("https://{0}", URL)), capabilities));
        return this;
    }

    @SuppressWarnings ("unchecked")
    public <D extends AppiumDriver<MobileElement>> D getDriver () {
        if (null == DRIVER.get ()) {
            startService ();
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
}
