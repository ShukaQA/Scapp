package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverFactory implements DriverFactory {
    @Override
    public AppiumDriver createDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(ConfigReader.get("PLATFORM_NAME"));
        options.setAutomationName(ConfigReader.get("AUTOMATION_NAME"));
        options.setDeviceName(ConfigReader.get("DEVICE_NAME"));
        options.setAppPackage(ConfigReader.get("APP_PACKAGE"));
        options.setAppActivity(ConfigReader.get("APP_ACTIVITY"));
        options.setNoReset(Boolean.parseBoolean(ConfigReader.get("NO_RESET")));

        return new AndroidDriver(new URL(ConfigReader.get("APPIUM_SERVER")), options);
    }
}
