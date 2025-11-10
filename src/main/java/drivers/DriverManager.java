package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import utils.ConfigReader;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            try {
                String runOn = ConfigReader.getOrDefault("RUN_ON", "local");
                DriverFactory factory = DriverFactoryProvider.getFactory(runOn);

                AppiumDriver newDriver = factory.createDriver();
                newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.set(newDriver);
            } catch (Exception e) {
                throw new RuntimeException("Driver initialization failed", e);
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } catch (Exception e) {
                System.out.println("Warning: Driver quit failed: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }

    public static void closeApplication() {
        if (driver.get() != null) {
            try {
                if (driver.get() instanceof AndroidDriver) {
                    String appPackage = ConfigReader.getOrDefault("APP_PACKAGE", "");
                    if (!appPackage.isEmpty()) {
                        ((AndroidDriver) driver.get()).terminateApp(appPackage);
                    }
                } else if (driver.get() instanceof IOSDriver) {
                    String bundleId = ConfigReader.getOrDefault("BUNDLE_ID", "");
                    if (!bundleId.isEmpty()) {
                        ((IOSDriver) driver.get()).terminateApp(bundleId);
                    }
                }
            } catch (Exception e) {
                System.out.println("Warning: Failed to close app: " + e.getMessage());
            }
        }
    }
}
