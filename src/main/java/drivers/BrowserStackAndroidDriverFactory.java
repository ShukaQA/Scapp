package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackAndroidDriverFactory implements DriverFactory {
    @Override
    public AppiumDriver createDriver() throws MalformedURLException {
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", ConfigReader.get("BROWSERSTACK_USERNAME"));
        bstackOptions.put("accessKey", ConfigReader.get("BROWSERSTACK_ACCESS_KEY"));
        bstackOptions.put("projectName", ConfigReader.getOrDefault("BS_PROJECT", "Scapp BS Automation"));
        bstackOptions.put("buildName", ConfigReader.getOrDefault("BS_BUILD", "browserstack build"));
        bstackOptions.put("sessionName", ConfigReader.getOrDefault("BS_SESSION", "Sample Session"));
        bstackOptions.put("local", false);

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(ConfigReader.get("BS_APP"))
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(ConfigReader.getOrDefault("BS_DEVICE", "Samsung Galaxy S22 Ultra"))
                .setPlatformVersion(ConfigReader.getOrDefault("BS_OS_VERSION", "12.0"))
                .amend("bstack:options", bstackOptions);

        return new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), options);
    }
}
