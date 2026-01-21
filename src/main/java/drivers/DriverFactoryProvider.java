package drivers;

import core.DeviceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactoryProvider {

    private static final Logger log = LoggerFactory.getLogger(DriverFactoryProvider.class);

    public static DriverFactory getFactory(String runOn) {
        String platform = DeviceInfo.getPlatformName();
        log.info("Selected platform: {}, runOn: {}", platform, runOn);

        if (DeviceInfo.isBrowserStack()) {
            if (DeviceInfo.isIOS()) {
                log.info("Using BrowserStack iOS Driver Factory");
                return new BrowserStackIosDriverFactory();
            } else if (DeviceInfo.isAndroid()) {
                log.info("Using BrowserStack Android Driver Factory");
                return new BrowserStackAndroidDriverFactory();
            } else {
                throw new RuntimeException("Unsupported platform for BrowserStack: " + platform);
            }
        }

        log.info("Using Local Driver Factory");
        return new LocalDriverFactory();
    }
}
