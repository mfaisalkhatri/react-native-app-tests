package io.github.mfaisalkhatri.mobileautomation.pages.android;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IPLocationPage {

    private AndroidDriverManager driverManager;
    private WebDriverWait wait;

    public IPLocationPage (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WebDriverWait (driverManager.getDriver (), Duration.ofSeconds (30));
    }

    public String getCountryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".table > tbody > tr:nth-child(4) > td"))).getText();
    }

    public String getLatitude() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".table > tbody > tr:nth-child(2) > td"))).getText();
    }

    public String getLongitude() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".table > tbody > tr:nth-child(3) > td"))).getText();
    }

}
