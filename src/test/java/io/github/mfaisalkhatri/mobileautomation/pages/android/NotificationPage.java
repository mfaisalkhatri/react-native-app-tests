package io.github.mfaisalkhatri.mobileautomation.pages.android;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 1/13/2023
 **/
public class NotificationPage {

    DriverManager driverManager;

    public NotificationPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    private List<WebElement> notificationTitles () {
        return driverManager.getDriver ()
            .findElements (By.id ("android:id/title"));
    }

    public String getFirstNotificationTitle () {
        return notificationTitles ().get (0)
            .getText ();
    }

    private List<WebElement> notificationTexts () {
        return driverManager.getDriver ()
            .findElements (By.id ("android:id/text"));
    }

    public String getFirstNotificationText () {
        return notificationTexts ().get (0)
            .getText ();
    }

    public void openNotificationPanel () {
        driverManager.<AndroidDriver>getDriver ()
            .openNotifications ();
    }

}
