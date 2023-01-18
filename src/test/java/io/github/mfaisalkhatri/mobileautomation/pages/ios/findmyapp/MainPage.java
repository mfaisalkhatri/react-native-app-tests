package io.github.mfaisalkhatri.mobileautomation.pages.ios.findmyapp;

import static io.github.mfaisalkhatri.utilities.Helper.clickOn;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Faisal Khatri
 * @since 1/12/2023
 **/
public class MainPage {

    DriverManager driverManager;
    WebDriverWait wait;

    public MainPage (final DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (20));
    }

    private WebElement continueBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.iOSClassChain (
                "**/XCUIElementTypeButton[`label == \"Continue\"`]**/XCUIElementTypeButton[`label == \"Continue\"`]"));
    }

    private WebElement devicesBtn () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.iOSNsPredicateString ("label == \"Devices\""));
    }

    private WebElement meButton () {
        return driverManager.getDriver ()
            .findElement (AppiumBy.accessibilityId ("meButton"));
    }

    public boolean isDevicesBtnDisplayed (){
        return devicesBtn ().isDisplayed ();
    }


    public boolean isContinueBtnDisplayed () {
        return continueBtn ().isDisplayed ();
    }

    public void clickMeBtn () {
        clickOn (meButton ());
    }

}
