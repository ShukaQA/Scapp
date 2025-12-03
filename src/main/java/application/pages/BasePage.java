package application.pages;

import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import utils.LoggerHelper;

public abstract class BasePage {

    protected final AppiumDriver driver;
    protected final Logger log;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.log = LoggerHelper.getLogger(this.getClass()); // use LoggerHelper here
        log.info("Initialized Page Object: {}", this.getClass().getSimpleName());
    }

    /**
     * Common helper method for logging steps
     */
    protected void logStep(String message) {
        log.info("[STEP] {}", message);
    }

    /**
     * Common helper method for logging errors
     */
    protected void logError(String message, Throwable t) {
        log.error("[ERROR] {}", message, t);
    }
}
