package application.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import drivers.DriverManager;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    private final int TIMEOUT = 15; // seconds

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    protected WebElement find(By locator) {
        return waitForVisibility(locator);
    }

    protected void click(By locator) {
        waitForVisibility(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = waitForVisibility(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    protected void scrollToEnd() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
        ));

    }

    // Wait until element is visible
    private WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
