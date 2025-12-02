package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverFactory implements DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(LocalDriverFactory.class);

    @Override
    public AppiumDriver createDriver() throws MalformedURLException {
        log.info("Initializing local Appium Android driver...");

        UiAutomator2Options options = new UiAutomator2Options();

        String platformName = ConfigReader.get("PLATFORM_NAME");
        String automationName = ConfigReader.get("AUTOMATION_NAME");
        String deviceName = ConfigReader.get("DEVICE_NAME");
        String appPackage = ConfigReader.get("APP_PACKAGE");
        String appActivity = ConfigReader.get("APP_ACTIVITY");
        boolean noReset = Boolean.parseBoolean(ConfigReader.getOrDefault("NO_RESET", "false"));
        String appiumServer = ConfigReader.get("APPIUM_SERVER");

        log.debug("Loaded local capabilities: " +
                        "platformName={}, automationName={}, deviceName={}, appPackage={}, appActivity={}, noReset={}",
                platformName, automationName, deviceName, appPackage, appActivity, noReset
        );

        options.setPlatformName(platformName);
        options.setAutomationName(automationName);
        options.setDeviceName(deviceName);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setNoReset(noReset);

        log.info("Connecting to local Appium server: {}", appiumServer);

        try {
            AndroidDriver driver = new AndroidDriver(new URL(appiumServer), options);
            log.info("Local Android driver created successfully.");
            return driver;
        } catch (Exception e) {
            log.error("Failed to create local driver: {}", e.getMessage(), e);
            throw e;
        }
    }
}
