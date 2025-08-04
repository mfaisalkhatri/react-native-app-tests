package io.github.mfaisalkhatri.utilities;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

public class Helper {

    public static void clickOn (final WebElement element) {
        element.click ();
    }

    @SneakyThrows
    public static void waitForSomeTime () {
        Thread.sleep (2000);
    }

    AndroidDriverManager driverManager;

    public Helper (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
    }
}