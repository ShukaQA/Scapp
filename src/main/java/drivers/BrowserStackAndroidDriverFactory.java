package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackAndroidDriverFactory implements DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(BrowserStackAndroidDriverFactory.class);

    @Override
    public AppiumDriver createDriver() throws MalformedURLException {

        log.info("Initializing BrowserStack Android driver...");

        // BrowserStack capabilities
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", ConfigReader.get("BROWSERSTACK_USERNAME"));
        bstackOptions.put("accessKey", ConfigReader.get("BROWSERSTACK_ACCESS_KEY"));
        bstackOptions.put("projectName", ConfigReader.getOrDefault("BS_PROJECT", "Scapp BS Automation"));
        bstackOptions.put("buildName", ConfigReader.getOrDefault("BS_BUILD", "browserstack build"));
        bstackOptions.put("sessionName", ConfigReader.getOrDefault("BS_SESSION", "Sample Session"));
        bstackOptions.put("local", false);

        // Debug/logging capabilities
        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);
        bstackOptions.put("video", true);
        bstackOptions.put("consoleLogs", "verbose");
        bstackOptions.put("appiumLogs", true);

        log.debug("BrowserStack capabilities loaded: {}", bstackOptions);

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(ConfigReader.get("BS_APP"))
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(ConfigReader.getOrDefault("BS_DEVICE", "Samsung Galaxy S22 Ultra"))
                .setPlatformVersion(ConfigReader.getOrDefault("BS_OS_VERSION", "12.0"))
                .amend("bstack:options", bstackOptions);

        log.info("Connecting to BrowserStack hub...");

        AndroidDriver driver;

        try {
            driver = new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), options);
            log.info("BrowserStack Android driver created successfully.");
        } catch (Exception e) {
            log.error("Failed to initialize BrowserStack Android driver: {}", e.getMessage(), e);
            throw e;
        }

        return driver;
    }
}
