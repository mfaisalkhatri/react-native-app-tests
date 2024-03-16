package io.github.mfaisalkhatri.mobileautomation.pages.android;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoLocationPage {

    private final AndroidDriverManager driverManager;
    private final WebDriverWait wait;

    public GeoLocationPage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
        this.wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (30));
    }

    public WebElement content () {
        return this.wait.until (ExpectedConditions.presenceOfElementLocated (AppiumBy.id ("android:id/content")));
    }

    public void navigateToHomePage () {
        this.driverManager.getDriver ()
            .navigate ()
            .back ();
    }

}
