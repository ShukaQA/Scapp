package core;

import utils.ConfigReader;

public class DeviceInfo {

    private static final String RUN_ON = ConfigReader.get("RUN_ON");

    private static final String PLATFORM_NAME = ConfigReader.get("PLATFORM_NAME");

    private static final String AUTOMATION_NAME = ConfigReader.get("AUTOMATION_NAME");
    private static final String DEVICE_NAME = ConfigReader.get("DEVICE_NAME");
    private static final String APP_PACKAGE = ConfigReader.get("APP_PACKAGE");
    private static final String APP_ACTIVITY = ConfigReader.get("APP_ACTIVITY");
    private static final String NO_RESET = ConfigReader.get("NO_RESET");
    private static final String APPIUM_SERVER = ConfigReader.get("APPIUM_SERVER");

    private static final String BROWSERSTACK_USERNAME = ConfigReader.get("BROWSERSTACK_USERNAME");
    private static final String BROWSERSTACK_ACCESS_KEY = ConfigReader.get("BROWSERSTACK_ACCESS_KEY");

    private static final String BS_SERVER = ConfigReader.get("BS_SERVER");
    private static final String BS_PROJECT = ConfigReader.get("BS_PROJECT");
    private static final String BS_BUILD = ConfigReader.get("BS_BUILD");

    private static final String BS_APP_ANDROID = ConfigReader.get("BS_APP_ANDROID");
    private static final String BS_DEVICE_ANDROID = ConfigReader.get("BS_DEVICE_ANDROID");
    private static final String BS_OS_VERSION_ANDROID = ConfigReader.get("BS_OS_VERSION_ANDROID");

    private static final String BS_APP_IOS = ConfigReader.get("BS_APP_IOS");
    private static final String BS_DEVICE_IOS = ConfigReader.get("BS_DEVICE_IOS");
    private static final String BS_OS_VERSION_IOS = ConfigReader.get("BS_OS_VERSION_IOS");

    private DeviceInfo() {
        // prevent instantiation
    }

    public static String getRunOn() {
        return RUN_ON;
    }

    public static String getPlatformName() {
        return PLATFORM_NAME;
    }

    public static boolean isAndroid() {
        return "Android".equalsIgnoreCase(PLATFORM_NAME);
    }

    public static boolean isIOS() {
        return "iOS".equalsIgnoreCase(PLATFORM_NAME);
    }

    public static String getDeviceName() {
        if (isAndroid()) {
            return BS_DEVICE_ANDROID != null ? BS_DEVICE_ANDROID : DEVICE_NAME;
        }
        if (isIOS()) {
            return BS_DEVICE_IOS;
        }
        return null;
    }

    public static String getOsVersion() {
        if (isAndroid()) {
            return BS_OS_VERSION_ANDROID;
        }
        if (isIOS()) {
            return BS_OS_VERSION_IOS;
        }
        return null;
    }

    public static boolean isBrowserStack() {
        return "browserstack".equalsIgnoreCase(RUN_ON);
    }

    public static boolean isLocal() {
        return "local".equalsIgnoreCase(RUN_ON);
    }

    public static String getAutomationName() {
        return AUTOMATION_NAME;
    }

    public static String getLocalDeviceName() {
        return DEVICE_NAME;
    }

    public static String getAppPackage() {
        return APP_PACKAGE;
    }

    public static String getAppActivity() {
        return APP_ACTIVITY;
    }

    public static boolean isNoReset() {
        return Boolean.parseBoolean(NO_RESET);
    }

    public static String getAppiumServer() {
        return APPIUM_SERVER;
    }

    public static String getBrowserStackUsername() {
        return BROWSERSTACK_USERNAME;
    }

    public static String getBrowserStackAccessKey() {
        return BROWSERSTACK_ACCESS_KEY;
    }

    public static String getBrowserStackServer() {
        return BS_SERVER;
    }

    public static String getBrowserStackProject() {
        return BS_PROJECT;
    }

    public static String getBrowserStackBuild() {
        return BS_BUILD;
    }

    public static String getBrowserStackAppAndroid() {
        return BS_APP_ANDROID;
    }

    public static String getBrowserStackDeviceAndroid() {
        return BS_DEVICE_ANDROID;
    }

    public static String getBrowserStackOsVersionAndroid() {
        return BS_OS_VERSION_ANDROID;
    }

    public static String getBrowserStackAppIos() {
        return BS_APP_IOS;
    }

    public static String getBrowserStackDeviceIos() {
        return BS_DEVICE_IOS;
    }

    public static String getBrowserStackOsVersionIos() {
        return BS_OS_VERSION_IOS;
    }

}
