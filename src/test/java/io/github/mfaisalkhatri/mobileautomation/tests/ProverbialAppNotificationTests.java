package io.github.mfaisalkhatri.mobileautomation.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.mobileautomation.pages.android.HomePage;
import io.github.mfaisalkhatri.mobileautomation.pages.android.NotificationPage;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 1/12/2023
 **/
public class ProverbialAppNotificationTests extends BaseTest {

    @Test
    public void testNotification () {
        HomePage homePage = new HomePage (driverManager);
        homePage.openMenu ();
        homePage.clickPushNotificationMenu ();
        NotificationPage notificationPage = new NotificationPage (driverManager);
        notificationPage.openNotificationPanel ();
        assertEquals ("Test Notification", notificationPage.getFirstNotificationTitle ());
        assertEquals ("Please enjoy this notification", notificationPage.getFirstNotificationText ());
    }

}
