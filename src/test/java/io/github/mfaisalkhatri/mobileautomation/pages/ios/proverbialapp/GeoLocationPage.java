package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoLocationPage {

    private final IOSDriverManager iosDriverManager;
    private final WebDriverWait wait;

    public GeoLocationPage (final IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
        this.wait = new WebDriverWait (iosDriverManager.getDriver (), Duration.ofSeconds (30));
    }

    public WebElement banner () {
        return this.wait.until (ExpectedConditions.presenceOfElementLocated (AppiumBy.accessibilityId ("banner")));
    }

    public WebElement backBtn () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Back"));
    }

    public void navigateToHomePage () {
        clickOn (backBtn ());
    }

}
