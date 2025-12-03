import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.BrowserStackUtils;

public class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        AppiumDriver driver = DriverManager.getDriver();

        if (result.getStatus() == ITestResult.FAILURE) {
            BrowserStackUtils.setStatus(driver, "failed", result.getThrowable().getMessage());
        } else {
            BrowserStackUtils.setStatus(driver, "passed", "Test passed");
        }

        DriverManager.closeApplication();
        DriverManager.quitDriver();
    }

}
