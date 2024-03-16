package io.github.mfaisalkhatri.mobileautomation.pages.ios.proverbialapp;

import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
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
    private final IOSDriverManager iosDriverManager;

    public NotificationPage (final IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
    }

    @SneakyThrows
    public void openNotificationPanel () {
        Thread.sleep (5000);
        final var screenSize = this.iosDriverManager.getDriver ()
            .manage ()
            .window ()
            .getSize ();
        final var yMargin = 5;
        final var xTop = screenSize.width;
        final var top = new Point (xTop, yMargin);
        final var bottom = new Point (xTop, screenSize.height - yMargin);

        final PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH, "finger");
        final Sequence swipe = new Sequence (finger, 1);
        swipe.addAction (
            finger.createPointerMove (Duration.ofMillis (0), PointerInput.Origin.viewport (), top.x, top.y));
        swipe.addAction (finger.createPointerDown (PointerInput.MouseButton.LEFT.asArg ()));
        swipe.addAction (
            finger.createPointerMove (Duration.ofMillis (1000), PointerInput.Origin.viewport (), bottom.x, bottom.y));
        swipe.addAction (finger.createPointerUp (PointerInput.MouseButton.LEFT.asArg ()));
        this.iosDriverManager.getDriver ()
            .perform (List.of (swipe));

    }

    private WebElement notificationElement () {
        return this.iosDriverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("NotificationCell"));
    }

    public String getNotificationText () {
        return notificationElement ().getText ();
    }

}
