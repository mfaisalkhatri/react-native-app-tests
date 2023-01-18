package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

/**
 * @author Faisal Khatri
 * @since 1/13/2023
 **/
public class NotificationPage {
    DriverManager driverManager;

    public NotificationPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @SneakyThrows
    public void openNotificationPanel () {
        Thread.sleep (5000);
        var screenSize = driverManager.getDriver ()
            .manage ()
            .window ()
            .getSize ();
        var yMargin = 5;
        var xTop = screenSize.width;
        var top = new Point (xTop, yMargin);
        var bottom = new Point (xTop, screenSize.height - yMargin);

        PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence (finger, 1);
        swipe.addAction (
            finger.createPointerMove (Duration.ofMillis (0), PointerInput.Origin.viewport (), top.x, top.y));
        swipe.addAction (finger.createPointerDown (PointerInput.MouseButton.LEFT.asArg ()));
        swipe.addAction (
            finger.createPointerMove (Duration.ofMillis (1000), PointerInput.Origin.viewport (), bottom.x, bottom.y));
        swipe.addAction (finger.createPointerUp (PointerInput.MouseButton.LEFT.asArg ()));
        driverManager.getDriver ()
            .perform (List.of (swipe));

    }

    private WebElement notificationElement () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("NotificationCell"));
    }

    public String getNotificationText () {
        return notificationElement ().getText ();
    }

}
