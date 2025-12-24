package utils;

import browserstack.shaded.org.json.JSONObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BrowserStackUtils {

    /**
     * Set BrowserStack session name
     */
    public static void setSessionName(AppiumDriver driver, String name) {
        JSONObject arguments = new JSONObject();
        arguments.put("name", name);

        JSONObject command = new JSONObject();
        command.put("action", "setSessionName");
        command.put("arguments", arguments);

        ((JavascriptExecutor) driver)
                .executeScript("browserstack_executor: " + command.toString());
    }

    /**
     * Set BrowserStack session status
     */
    public static void setStatus(AppiumDriver driver, String status, String reason) {
        JSONObject arguments = new JSONObject();
        arguments.put("status", status);
        arguments.put("reason", reason);

        JSONObject command = new JSONObject();
        command.put("action", "setSessionStatus");
        command.put("arguments", arguments);

        ((JavascriptExecutor) driver)
                .executeScript("browserstack_executor: " + command.toString());
    }

}
