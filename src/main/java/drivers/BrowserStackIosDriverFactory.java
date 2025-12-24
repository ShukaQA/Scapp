package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

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

        String buildName = ConfigReader.getOrDefault("BS_BUILD", "browserstack build") +
                " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", ConfigReader.get("BROWSERSTACK_USERNAME"));
        bstackOptions.put("accessKey", ConfigReader.get("BROWSERSTACK_ACCESS_KEY"));
        bstackOptions.put("projectName", ConfigReader.getOrDefault("BS_PROJECT", "Scapp BS Automation"));
        bstackOptions.put("buildName", buildName);
        bstackOptions.put("local", false);

        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);
        bstackOptions.put("video", true);
        bstackOptions.put("consoleLogs", "verbose");
        bstackOptions.put("appiumLogs", true);

        log.debug("BrowserStack iOS capabilities loaded: {}", bstackOptions);

        XCUITestOptions options = new XCUITestOptions()
                .setApp(ConfigReader.get("BS_APP_IOS"))
                .setPlatformName(ConfigReader.get("PLATFORM_NAME"))
                .setAutomationName("XCUITest")
                .setDeviceName(ConfigReader.getOrDefault("BS_DEVICE_IOS", "iPhone 14"))
                .setPlatformVersion(ConfigReader.getOrDefault("BS_OS_VERSION_IOS", "17"))
                .amend("bstack:options", bstackOptions);

        log.info("Connecting to BrowserStack hub...");

        try {
            IOSDriver driver = new IOSDriver(new URL(ConfigReader.get("BS_SERVER")), options);
            log.info("BrowserStack iOS driver created successfully.");
            return driver;
        } catch (Exception e) {
            log.error("Failed to initialize BrowserStack iOS driver: {}", e.getMessage(), e);
            throw e;
        }
    }
}
