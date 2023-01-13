package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.PerformsTouchID;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    DriverManager driverManager;
    WebDriverWait wait;

    public HomePage (final DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (20));
    }

    public WebElement textBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Text"));
    }

    public String getText () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Textbox"))
            .getText ();
    }

    public WebElement notificationBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("notification"));
    }

    public WebElement notificationBar () {
        return wait.until (
            ExpectedConditions.presenceOfElementLocated (AppiumBy.accessibilityId ("NotificationShortLookView")));
    }

    public WebElement toastBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("toast"));
    }

    public String toastMessage () {
        return wait.until (ExpectedConditions.presenceOfElementLocated (
                AppiumBy.xpath ("//*[contains(@label, 'Toast should be visible')]")))
            .getText ();
    }

    public WebElement geoLocationBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("geoLocation"));
    }

    public WebElement speedtTestBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("speedTest"));
    }

    public WebElement browserMenu () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Browser"));
    }

}
