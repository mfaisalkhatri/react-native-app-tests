package io.github.mfaisalkhatri.mobileautomation.tests.android;

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
        final HomePage homePage = new HomePage (this.androidDriverManager);
        homePage.openMenu ();
        homePage.clickPushNotificationMenu ();

        final NotificationPage notificationPage = new NotificationPage (this.androidDriverManager);
        notificationPage.openNotificationPanel ();
        assertEquals (notificationPage.getFirstNotificationTitle (), "Test Notification");
        assertEquals (notificationPage.getFirstNotificationText (), "Please enjoy this notification");
    }

}
