package io.github.mfaisalkhatri.utilities;

import io.github.mfaisalkhatri.drivers.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

public class Helper {

    DriverManager driverManager;

    public Helper (final DriverManager driverManager) {
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
