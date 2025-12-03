package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BrowserStackUtils {

    public static void setStatus(AppiumDriver driver, String status, String reason) {
        ((JavascriptExecutor) driver).executeScript(
                "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\""
                        + status + "\", \"reason\": \"" + reason + "\"}}"
        );
    }
}
