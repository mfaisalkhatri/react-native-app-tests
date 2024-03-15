package io.github.mfaisalkhatri.mobileautomation.pages.android;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;
import static io.github.mfaisalkhatri.utilities.Helper.waitForsomeTime;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;

public class BrowserPage {

    private AndroidDriverManager driverManager;

    public BrowserPage (final AndroidDriverManager driverManager) {
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
