package io.github.mfaisalkhatri.server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServiceManager {

    private static AppiumServiceBuilder     serviceBuilder;
    private static AppiumDriverLocalService service;

    public static void startService () {
        serviceBuilder = new AppiumServiceBuilder ().usingAnyFreePort ()
            .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument (GeneralServerFlag.LOG_LEVEL, "true");
        service = AppiumDriverLocalService.buildService (serviceBuilder);
        service.start ();
    }

    public static void stopService () {
        service.stop ();
    }
}
