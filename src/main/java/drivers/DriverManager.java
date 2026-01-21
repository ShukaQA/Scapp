package drivers;

import core.DeviceInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import java.time.Duration;

public class DriverManager {

    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            try {
                String runOn = ConfigReader.getOrDefault("RUN_ON", "local");
                log.info("Creating driver for environment: {}", runOn);

                DriverFactory factory = DriverFactoryProvider.getFactory(runOn);

                AppiumDriver newDriver = factory.createDriver();
                newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

                driver.set(newDriver);
                log.info("Driver successfully created and configured.");
            } catch (Exception e) {
                log.error("Driver initialization failed: {}", e.getMessage(), e);
                throw new RuntimeException("Driver initialization failed", e);
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                log.info("Quitting driver...");
                driver.get().quit();
                log.info("Driver quit successfully.");
            } catch (Exception e) {
                log.warn("Warning: Driver quit failed: {}", e.getMessage());
            } finally {
                driver.remove();
            }
        } else {
            log.debug("quitDriver() called but no driver was present.");
        }
    }

    public static void closeApplication() {
        if (driver.get() == null) {
            log.debug("closeApplication() called but driver is null.");
            return;
        }

        try {
            if (DeviceInfo.isAndroid()) {
                String appPackage = DeviceInfo.getAppPackage();
                if (!appPackage.isEmpty()) {
                    log.info("Terminating Android app: {}", appPackage);
                    ((AndroidDriver) driver.get()).terminateApp(appPackage);
                }
            } else if (DeviceInfo.isIOS()) {
                String bundleId = ConfigReader.getOrDefault("BUNDLE_ID", "");
                if (!bundleId.isEmpty()) {
                    log.info("Terminating iOS app: {}", bundleId);
                    ((IOSDriver) driver.get()).terminateApp(bundleId);
                }
            }
        } catch (Exception e) {
            log.warn("Failed to close application: {}", e.getMessage());
        }
    }
}
