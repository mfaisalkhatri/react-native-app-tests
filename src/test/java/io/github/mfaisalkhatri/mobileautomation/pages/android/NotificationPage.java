package io.github.mfaisalkhatri.mobileautomation.pages.android;

import java.util.List;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 1/13/2023
 **/
public class NotificationPage {

    AndroidDriverManager driverManager;

    public NotificationPage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String getFirstNotificationText () {
        return notificationTexts ().get (0)
            .getText ();
    }

    public String getFirstNotificationTitle () {
        return notificationTitles ().get (0)
            .getText ();
    }

    public void openNotificationPanel () {
        this.driverManager.getDriver ()
            .openNotifications ();
    }

    private List<WebElement> notificationTexts () {
        return this.driverManager.getDriver ()
            .findElements (By.id ("android:id/text"));
    }

    private List<WebElement> notificationTitles () {
        return this.driverManager.getDriver ()
            .findElements (By.id ("android:id/title"));
    }
}