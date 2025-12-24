package drivers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

public class DriverFactoryProvider {

    private static final Logger log = LoggerFactory.getLogger(DriverFactoryProvider.class);

    public static DriverFactory getFactory(String runOn) {
        String platform = ConfigReader.getOrDefault("PLATFORM_NAME", "Android");
        log.info("Selected platform: {}, runOn: {}", platform, runOn);

        if ("browserstack".equalsIgnoreCase(runOn)) {
            switch (platform.toLowerCase()) {
                case "ios":
                    log.info("Using BrowserStack iOS Driver Factory");
                    return new BrowserStackIosDriverFactory();
                case "android":
                default:
                    log.info("Using BrowserStack Android Driver Factory");
                    return new BrowserStackAndroidDriverFactory();
            }
        }

        log.info("Using Local Driver Factory");
        return new LocalDriverFactory();
    }
}
