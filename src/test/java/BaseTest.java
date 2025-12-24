import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserStackUtils;

import java.lang.reflect.Method;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        log.info("Setting up test: {}", method.getName());

        AppiumDriver driver = DriverManager.getDriver();
        if (driver == null) {
            log.error("Driver is NULL in @BeforeMethod! BrowserStack session name cannot be set.");
            return;
        }

        try {
            BrowserStackUtils.setSessionName(driver, method.getName());
            log.info("BrowserStack session name set: {}", method.getName());
        } catch (Exception e) {
            log.error("Failed to set BrowserStack session name: {}", e.getMessage(), e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        log.info("TearDown started for test: {}", result.getName());

        AppiumDriver driver = DriverManager.getDriver();
        if (driver == null) {
            log.warn("No driver found. Skipping BrowserStack status update.");
            DriverManager.quitDriver();
            return;
        }

        try {
            // Single ternary call to update BrowserStack status
            BrowserStackUtils.setStatus(
                    driver,
                    result.getStatus() == ITestResult.SUCCESS ? "passed" :
                            result.getStatus() == ITestResult.FAILURE ? "failed" : "unknown",
                    result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null ?
                            result.getThrowable().getMessage() : null
            );

            log.info("BrowserStack session '{}' status updated.", result.getName());

        } catch (Exception e) {
            log.error("BrowserStack status update failed: {}", e.getMessage(), e);
        }

        try {
            DriverManager.closeApplication();
        } catch (Exception e) {
            log.warn("Error while closing application: {}", e.getMessage());
        }

        DriverManager.quitDriver();
        log.info("TearDown completed for test: {}", result.getName());
    }
}
