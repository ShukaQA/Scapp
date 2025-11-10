package drivers;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public interface DriverFactory {
    AppiumDriver createDriver() throws MalformedURLException;
}
