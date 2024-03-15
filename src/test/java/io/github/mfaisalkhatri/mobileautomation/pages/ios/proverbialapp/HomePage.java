package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final IOSDriverManager iosDriverManager;
    private final WebDriverWait wait;

    public HomePage (final IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
        this.wait = new WebDriverWait (iosDriverManager.getDriver (), Duration.ofSeconds (20));
    }

    public WebElement textBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Text"));
    }

    public String getText () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Textbox"))
            .getText ();
    }

    public WebElement notificationBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("notification"));
    }

    public WebElement notificationBar () {
        return this.wait.until (
            ExpectedConditions.presenceOfElementLocated (AppiumBy.accessibilityId ("NotificationShortLookView")));
    }

    public WebElement toastBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("toast"));
    }

    public String toastMessage () {
        return this.wait.until (ExpectedConditions.presenceOfElementLocated (
                AppiumBy.xpath ("//*[contains(@label, 'Toast should be visible')]")))
            .getText ();
    }

    public WebElement geoLocationBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("geoLocation"));
    }

    public WebElement speedTestBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("speedTest"));
    }

    public WebElement browserMenu () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Browser"));
    }

}
