package io.github.mfaisalkhatri.mobileautomation.driversetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Setup {

    public static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<> ();

    @Parameters ({ "platformName", "device", "version" })
    @BeforeClass
    public void setupDriver (Platform platformName, String device, String version) throws MalformedURLException {
        String ltUserName = System.getenv ("username");
        String ltAccessToken = System.getenv ("token");
        String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
       // String localUrl = "http://localhost:4723/wd/hub";
        if (platformName.equals (Platform.ANDROID)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "android");
            capabilities.setCapability("name", "Proverbial apk tests");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Galaxy S21 5G");
            capabilities.setCapability("platformVersion","11");
//            UiAutomator2Options options = new UiAutomator2Options ();
//            options.setDeviceName (device);
//            options.setPlatformVersion (version);
//            options.setApp ("lt://APP100202361654757345879208");
//            options.setApp ("F:\\Github\\react-native-app-mobile-testing\\app\\proverbial_android.apk");
//            options.amend ("isRealMobile", true);
//            options.amend ("network", true);
//            options.amend ("visual", true);
//            options.amend ("console", true);
//            options.amend ("devicelog", true);
            driver.set (new AndroidDriver (new URL ("https://" + ltUserName + ":" + ltAccessToken + gridURL), capabilities));
//            driver.set (new AndroidDriver (new URL (localUrl),options));
            setupBrowserTimeouts ();

        } else {
            System.out.println ("Not a valid driver option");
        }
    }

    public AppiumDriver getDriver () {
        return driver.get ();
    }

    @AfterClass
    public void tearDown () {
        if (driver != null) {
            getDriver ().quit ();
            driver.remove ();
        }

    }

    private void setupBrowserTimeouts () {
        getDriver ().manage ()
            .timeouts ()
            .implicitlyWait (30, TimeUnit.SECONDS);
    }
}
