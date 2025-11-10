package utils;

import io.appium.java_client.remote.MobileCapabilityType;

public interface MobileCapabilityTypeScapp extends MobileCapabilityType {
    String APP_PACKAGE = "appPackage";
    String APP_ACTIVITY = "appActivity";
    String NO_RESET = "noReset";

}
