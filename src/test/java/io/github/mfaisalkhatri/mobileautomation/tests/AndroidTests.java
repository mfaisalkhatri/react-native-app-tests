package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.mobileautomation.pages.android.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static org.testng.Assert.assertTrue;

public class AndroidTests extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    public void setupTest () {
        homePage = new HomePage (driverManager);
    }

    @Test
    public void textTests () {
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        clickOn (homePage.textBtn ());
        assertEquals (homePage.getText (), "Proverbial");
    }

    @Test
    public void notificationTest() {
        clickOn (homePage.notificationBtn ());
        assertTrue (homePage.notificationBar ().isDisplayed ());
        clickOn (homePage.notificationBar ());
    }

    @Test
    public void toastMessageTest () {
        clickOn (homePage.toastBtn ());
        assertEquals (homePage.toastMessage (), "Toast should be visible");
    }
}
