package io.github.mfaisalkhatri.mobileautomation.pages.android;

import java.time.Duration;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPLocationPage {

    private final AndroidDriverManager driverManager;
    private final WebDriverWait        wait;

    public IPLocationPage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
        this.wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (30));
    }

    public String getCountryText () {
        return this.wait.until (
                ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".table > tbody > tr:nth-child(4) > td")))
            .getText ();
    }

    public String getLatitude () {
        return this.wait.until (
                ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".table > tbody > tr:nth-child(2) > td")))
            .getText ();
    }

    public String getLongitude () {
        return this.wait.until (
                ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".table > tbody > tr:nth-child(3) > td")))
            .getText ();
    }
}