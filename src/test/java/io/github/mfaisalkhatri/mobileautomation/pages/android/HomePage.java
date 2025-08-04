package io.github.mfaisalkhatri.mobileautomation.pages.android;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    AndroidDriverManager driverManager;
    WebDriverWait        wait;

    public HomePage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
        this.wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (20));
    }

    public WebElement browserMenu () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Browser"));
    }

    public void clickPushNotificationMenu () {
        this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("pushNotification"))
            .click ();
    }

    public WebElement geoLocationBtn () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("geoLocation"));
    }

    public String getText () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("Textbox"))
            .getText ();
    }

    public WebElement notificationBar () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("action_bar"));
    }

    public WebElement notificationBtn () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("notification"));
    }

    public void openMenu () {
        this.driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("drawer open"))
            .click ();
    }

    public WebElement speedTestBtn () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("speedTest"));
    }

    public WebElement textBtn () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("Text"));
    }

    public WebElement toastBtn () {
        return this.driverManager.getDriver ()
            .findElement (AppiumBy.id ("toast"));
    }

    public String toastMessage () {
        return this.wait.until (
                ExpectedConditions.presenceOfElementLocated (AppiumBy.xpath ("//android.widget.Toast[1]")))
            .getText ();
    }

}