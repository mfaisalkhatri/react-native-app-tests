package io.github.mfaisalkhatri.drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.Builder;
import lombok.SneakyThrows;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static java.text.MessageFormat.format;

@Builder
public class IOSDriverManager {
    private static final ThreadLocal<IOSDriver> DRIVER = new ThreadLocal<>();
    private String buildName;
    private String testName;
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String app;
    private static final String LT_USERNAME = System.getenv("LT_USERNAME");
    private static final String LT_ACCESS_KEY = System.getenv("LT_ACCESS_KEY");
    private static final String GRID_URL = "@mobile-hub.lambdatest.com/wd/hub";


    @SneakyThrows
    public IOSDriverManager createIOSDriver() {
        DRIVER.set(new IOSDriver(new URL(format("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_KEY, GRID_URL)),
                xcuiTestOptions()));
        setupDriverTimeouts();
        return this;
    }


    private XCUITestOptions xcuiTestOptions() {
        final XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions
                .setAutoAcceptAlerts(true)
                .setAutoDismissAlerts(true)
                .withBrowserName("chrome")
                .setCapability("lt:Options", getLambdaTestOptions());

        return xcuiTestOptions;
    }

    public IOSDriver getDriver() {
        return DRIVER.get();
    }


    public void quitDriver() {
        if (null != DRIVER.get()) {
            getDriver().quit();
            DRIVER.remove();
        }
    }

    private void setupDriverTimeouts() {
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(30));
    }

    private HashMap<String, Object> getLambdaTestOptions() {
        final HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", this.platformName);
        ltOptions.put("platformVersion", this.platformVersion);
        ltOptions.put("deviceName", this.deviceName);
        ltOptions.put("app", this.app);
        ltOptions.put("build", this.buildName);
        ltOptions.put("name", this.testName);
        ltOptions.put("autoAcceptAlerts", true);
        ltOptions.put("autoDismissAlerts", true);
        ltOptions.put("isRealMobile", true);
        ltOptions.put("visual", true);
        ltOptions.put("console", true);
        ltOptions.put("devicelog", true);
        HashMap<String, String> locationObj = new HashMap<>();
        locationObj.put("lat", "51.5072");
        locationObj.put("long", "0.1276");
        ltOptions.put("location", locationObj);
        ltOptions.put("plugin", "java-testNG");
        return ltOptions;
    }


}
