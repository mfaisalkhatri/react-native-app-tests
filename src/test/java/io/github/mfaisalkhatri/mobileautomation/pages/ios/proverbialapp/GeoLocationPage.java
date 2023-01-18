package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoLocationPage {

    DriverManager driverManager;
    WebDriverWait wait;

    public GeoLocationPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (30));
    }

    public WebElement banner () {
        return wait.until (ExpectedConditions.presenceOfElementLocated (AppiumBy.accessibilityId ("banner")));
    }

    public WebElement backBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Back"));
    }

    public void navigateToHomePage () {
        clickOn (backBtn ());
    }

}
