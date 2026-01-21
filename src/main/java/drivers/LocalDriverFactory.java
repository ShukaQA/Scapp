package drivers;

import core.DeviceInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverFactory implements DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(LocalDriverFactory.class);

    @Override
    public AppiumDriver createDriver() throws MalformedURLException {
        log.info("Initializing local Appium driver for platform {}", DeviceInfo.getPlatformName());

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(DeviceInfo.getPlatformName())
                .setAutomationName(DeviceInfo.getAutomationName())
                .setDeviceName(DeviceInfo.getDeviceName())
                .setAppPackage(DeviceInfo.getAppPackage())
                .setAppActivity(DeviceInfo.getAppActivity())
                .setNoReset(DeviceInfo.isNoReset());

        log.debug("Local capabilities: platformName={}, automationName={}, deviceName={}, appPackage={}, appActivity={}, noReset={}",
                DeviceInfo.getPlatformName(),
                DeviceInfo.getAutomationName(),
                DeviceInfo.getDeviceName(),
                DeviceInfo.getAppPackage(),
                DeviceInfo.getAppActivity(),
                DeviceInfo.isNoReset()
        );

        log.info("Connecting to local Appium server: {}", DeviceInfo.getAppiumServer());

        try {
            AndroidDriver driver = new AndroidDriver(
                    new URL(DeviceInfo.getAppiumServer()),
                    options);
            log.info("Local driver created successfully.");
            return driver;
        } catch (Exception e) {
            log.error("Failed to create local driver", e);
            throw e;
        }
    }
}
