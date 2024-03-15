package io.github.mfaisalkhatri.mobileautomation.pages.android;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    AndroidDriverManager driverManager;
    WebDriverWait wait;

    public HomePage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (20));
    }

    public WebElement textBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("Text"));
    }

    public String getText () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("Textbox"))
            .getText ();
    }

    public WebElement notificationBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("notification"));
    }

    public WebElement notificationBar () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("action_bar"));
    }

    public WebElement toastBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("toast"));
    }

    public String toastMessage () {
        return wait.until (ExpectedConditions.presenceOfElementLocated (AppiumBy.xpath ("//android.widget.Toast[1]")))
            .getText ();
    }

    public WebElement geoLocationBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("geoLocation"));
    }

    public WebElement speedtTestBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("speedTest"));
    }

    public WebElement browserMenu () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("Browser"));
    }

    public void openMenu () {
        driverManager.getDriver ().findElement (AppiumBy.accessibilityId ("drawer open")).click ();
    }

    public void clickPushNotificationMenu () {
        driverManager.getDriver ().findElement (AppiumBy.id ("pushNotification")).click ();
    }



}
