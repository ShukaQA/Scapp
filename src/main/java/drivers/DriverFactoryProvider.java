package drivers;

public class DriverFactoryProvider {
    public static DriverFactory getFactory(String runOn) {
        if ("browserstack".equalsIgnoreCase(runOn)) {
            return new BrowserStackAndroidDriverFactory();
        } else {
            return new LocalDriverFactory();
        }
    }
}
