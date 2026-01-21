package drivers;

import core.DeviceInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackAndroidDriverFactory implements DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(BrowserStackAndroidDriverFactory.class);

    @Override
    public AppiumDriver createDriver() throws MalformedURLException {

        log.info("Initializing BrowserStack Android driver...");

        String buildName = DeviceInfo.getBrowserStackBuild() +
                " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // BrowserStack capabilities
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", DeviceInfo.getBrowserStackUsername());
        bstackOptions.put("accessKey", DeviceInfo.getBrowserStackAccessKey());
        bstackOptions.put("projectName", DeviceInfo.getBrowserStackProject());
        bstackOptions.put("buildName", buildName);
        bstackOptions.put("local", false);

        // Debug/logging capabilities
        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);
        bstackOptions.put("video", true);
        bstackOptions.put("consoleLogs", "verbose");
        bstackOptions.put("appiumLogs", true);
        bstackOptions.put("appProfiling", true);

        log.debug("BrowserStack capabilities loaded: {}", bstackOptions);

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(DeviceInfo.getBrowserStackAppAndroid())
                .setPlatformName(DeviceInfo.getPlatformName())
                .setAutomationName(DeviceInfo.getAutomationName())
                .setDeviceName(DeviceInfo.getDeviceName())
                .setPlatformVersion(DeviceInfo.getOsVersion())
                .amend("bstack:options", bstackOptions);

        log.info("Connecting to BrowserStack hub...");

        AndroidDriver driver;

        try {
            driver = new AndroidDriver(
                    new URL(DeviceInfo.getBrowserStackServer()),
                    options);
            log.info("BrowserStack Android driver created successfully.");
        } catch (Exception e) {
            log.error("Failed to initialize BrowserStack Android driver: {}", e.getMessage(), e);
            throw e;
        }

        return driver;
    }
}
