package base;

import core.DeviceInfo;
import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.BrowserStackUtils;

import java.lang.reflect.Method;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Parameters({"PLATFORM_NAME", "DEVICE", "OS_VERSION"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method,
                      @Optional String platformName,
                      @Optional String device,
                      @Optional String osVersion) {

        // Set TestNG XML overrides
        DeviceInfo.setOverrides(platformName, device, osVersion);

        log.info("Setting up test: {} on {} {} {}", method.getName(),
                DeviceInfo.getPlatformName(),
                DeviceInfo.getDeviceName(),
                DeviceInfo.getOsVersion());

        AppiumDriver driver = DriverManager.getDriver();
        if (driver == null) {
            log.error("Driver is NULL in @BeforeMethod!");
            return;
        }

        try {
            BrowserStackUtils.setSessionName(driver, method.getName());
        } catch (Exception e) {
            log.error("Failed to set BrowserStack session name: {}", e.getMessage(), e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        AppiumDriver driver = DriverManager.getDriver();

        if (driver != null) {
            try {
                BrowserStackUtils.setStatus(
                        driver,
                        result.getStatus() == ITestResult.SUCCESS ? "passed" :
                                result.getStatus() == ITestResult.FAILURE ? "failed" : "unknown",
                        result.getStatus() == ITestResult.FAILURE && result.getThrowable() != null ?
                                result.getThrowable().getMessage() : null
                );
            } catch (Exception e) {
                log.error("BrowserStack status update failed: {}", e.getMessage(), e);
            }
        }

        // Close app and driver
        try { DriverManager.closeApplication(); } catch (Exception ignored) {}
        DriverManager.quitDriver();

        // Clear XML overrides for next test
        DeviceInfo.clearOverrides();
    }
}
