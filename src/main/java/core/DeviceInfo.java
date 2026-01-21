package core;

import utils.ConfigReader;

public class DeviceInfo {

    // Static defaults from mobile.properties
    private static final String RUN_ON = ConfigReader.get("RUN_ON");
    private static final String PLATFORM_NAME_DEFAULT = ConfigReader.get("PLATFORM_NAME");
    private static final String AUTOMATION_NAME = ConfigReader.get("AUTOMATION_NAME");
    private static final String DEVICE_NAME_DEFAULT = ConfigReader.get("DEVICE_NAME");
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
    private static final String BS_DEVICE_ANDROID_DEFAULT = ConfigReader.get("BS_DEVICE_ANDROID");
    private static final String BS_OS_VERSION_ANDROID_DEFAULT = ConfigReader.get("BS_OS_VERSION_ANDROID");

    private static final String BS_APP_IOS = ConfigReader.get("BS_APP_IOS");
    private static final String BS_DEVICE_IOS_DEFAULT = ConfigReader.get("BS_DEVICE_IOS");
    private static final String BS_OS_VERSION_IOS_DEFAULT = ConfigReader.get("BS_OS_VERSION_IOS");

    // ThreadLocal overrides from TestNG XML
    private static final ThreadLocal<String> platformNameOverride = new ThreadLocal<>();
    private static final ThreadLocal<String> deviceOverride = new ThreadLocal<>();
    private static final ThreadLocal<String> osVersionOverride = new ThreadLocal<>();

    private DeviceInfo() {}


    // Set XML parameters for current thread
    public static void setOverrides(String platformName, String device, String osVersion) {
        platformNameOverride.set(platformName);
        deviceOverride.set(device);
        osVersionOverride.set(osVersion);
    }


    // Getters with fallback to defaults
    public static String getRunOn() {
        return RUN_ON;
    }

    public static String getPlatformName() {
        return platformNameOverride.get() != null ? platformNameOverride.get() : PLATFORM_NAME_DEFAULT;
    }

    public static boolean isAndroid() {
        return "Android".equalsIgnoreCase(getPlatformName());
    }

    public static boolean isIOS() {
        return "iOS".equalsIgnoreCase(getPlatformName());
    }

    public static boolean isBrowserStack() {
        return "browserstack".equalsIgnoreCase(RUN_ON);
    }

    public static boolean isLocal() {
        return "local".equalsIgnoreCase(RUN_ON);
    }

    public static String getDeviceName() {
        if (deviceOverride.get() != null) {
            return deviceOverride.get();
        }
        if (isAndroid()) {
            return BS_DEVICE_ANDROID_DEFAULT != null ? BS_DEVICE_ANDROID_DEFAULT : DEVICE_NAME_DEFAULT;
        }
        if (isIOS()) {
            return BS_DEVICE_IOS_DEFAULT != null ? BS_DEVICE_IOS_DEFAULT : DEVICE_NAME_DEFAULT;
        }
        return DEVICE_NAME_DEFAULT;
    }

    public static String getOsVersion() {
        if (osVersionOverride.get() != null) {
            return osVersionOverride.get();
        }
        if (isAndroid()) {
            return BS_OS_VERSION_ANDROID_DEFAULT;
        }
        if (isIOS()) {
            return BS_OS_VERSION_IOS_DEFAULT;
        }
        return null;
    }

    public static String getAutomationName() { return AUTOMATION_NAME; }
    public static String getAppPackage() { return APP_PACKAGE; }
    public static String getAppActivity() { return APP_ACTIVITY; }
    public static boolean isNoReset() { return Boolean.parseBoolean(NO_RESET); }
    public static String getAppiumServer() { return APPIUM_SERVER; }
    public static String getBrowserStackUsername() { return BROWSERSTACK_USERNAME; }
    public static String getBrowserStackAccessKey() { return BROWSERSTACK_ACCESS_KEY; }
    public static String getBrowserStackServer() { return BS_SERVER; }
    public static String getBrowserStackProject() { return BS_PROJECT; }
    public static String getBrowserStackBuild() { return BS_BUILD; }
    public static String getBrowserStackAppAndroid() { return BS_APP_ANDROID; }
    public static String getBrowserStackAppIos() { return BS_APP_IOS; }


    public static void clearOverrides() {
        platformNameOverride.remove();
        deviceOverride.remove();
        osVersionOverride.remove();
    }
}
