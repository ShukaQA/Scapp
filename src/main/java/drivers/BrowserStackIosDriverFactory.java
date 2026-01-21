package drivers;

import core.DeviceInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackIosDriverFactory implements DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(BrowserStackIosDriverFactory.class);

    @Override
    public AppiumDriver createDriver() throws MalformedURLException {

        log.info("Initializing BrowserStack iOS driver...");

        String buildName = DeviceInfo.getBrowserStackBuild() +
                " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", DeviceInfo.getBrowserStackUsername());
        bstackOptions.put("accessKey", DeviceInfo.getBrowserStackAccessKey());
        bstackOptions.put("projectName", DeviceInfo.getBrowserStackProject());
        bstackOptions.put("buildName", buildName);
        bstackOptions.put("local", false);

        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);
        bstackOptions.put("video", true);
        bstackOptions.put("consoleLogs", "verbose");
        bstackOptions.put("appiumLogs", true);

        log.debug("BrowserStack iOS capabilities loaded: {}", bstackOptions);

        XCUITestOptions options = new XCUITestOptions()
                .setApp(DeviceInfo.getBrowserStackAppIos())
                .setPlatformName(DeviceInfo.getPlatformName())
                .setAutomationName("XCUITest")
                .setDeviceName(DeviceInfo.getDeviceName())
                .setPlatformVersion(DeviceInfo.getOsVersion())
                .amend("bstack:options", bstackOptions);

        log.info("Connecting to BrowserStack hub...");

        try {
            IOSDriver driver = new IOSDriver(
                    new URL(DeviceInfo.getBrowserStackServer()),
                    options);
            log.info("BrowserStack iOS driver created successfully.");
            return driver;
        } catch (Exception e) {
            log.error("Failed to initialize BrowserStack iOS driver: {}", e.getMessage(), e);
            throw e;
        }
    }
}
