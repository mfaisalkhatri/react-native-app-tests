package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.drivers.DriverManager;
import io.github.mfaisalkhatri.mobileautomation.driversetup.Setup;
import io.github.mfaisalkhatri.mobileautomation.pages.MainPage;
import org.openqa.selenium.Platform;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LambdaTests extends BaseTest{

    private MainPage mainPage;

    @BeforeClass
    public void setupTest () {
        mainPage = new MainPage (driverManager);
    }

    @Test
    public void testAndroid () {
        mainPage.textButton ().click ();
        assertEquals (mainPage.getText (), "Proverbial");
    }
}
