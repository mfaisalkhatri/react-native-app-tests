package io.github.mfaisalkhatri.utilities;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

public class Helper {

    AndroidDriverManager driverManager;

    public Helper (final AndroidDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public static void clickOn (WebElement element) {
        element.click ();
    }

    @SneakyThrows
    public static void waitForsomeTime () {
        Thread.sleep (2000);
    }
}
