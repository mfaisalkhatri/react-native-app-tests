package io.github.mfaisalkhatri.mobileautomation.pages.android;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static io.github.mfaisalkhatri.utilities.Helper.waitForsomeTime;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.WebElement;

public class BrowserPage {

    private DriverManager driverManager;

    public BrowserPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public WebElement searchBox () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("url"));
    }

    public void searchFor (String url) {
        searchBox ().sendKeys (url);
        clickOn (findBtn ());
        waitForsomeTime ();
    }

    public WebElement findBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.id ("find"));
    }

    public void navigateToHomePage () {
        driverManager.getDriver ()
            .navigate ()
            .back ();
    }

}
