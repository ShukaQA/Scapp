package application.pages;

import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

import static drivers.DriverManager.getDriver;

public class BasePage {

    protected AppiumDriver driver;
    private final int TIMEOUT = 15; // seconds
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        this.driver = DriverManager.getDriver();
        log.info("Driver instance initialized in BasePage.");
    }

    protected void click(By locator) {
        log.info("Clicking element: {}", locator);
        waitForVisibility(locator).click();
    }

    protected void type(By locator, String text) {
        log.info("Typing '{}' into element: {}", text, locator);
        WebElement el = waitForVisibility(locator);
        el.click();
        el.clear();
        hideKeyboard();
        el.sendKeys(text);
    }

    protected void scrollToEnd() {
        log.info("Scrolling to end using UiScrollable.");
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
        ));
    }

    public void scrollDownToBottom() {
        Dimension size = getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.35);
        int endY   = 0;
        log.info("Scrolling from ({}, {}) to ({}, {})", startX, startY, startX, endY);
        swipe(startX, startY, startX, endY, 600);
    }

    public void swipe(int startX, int startY, int endX, int endY, long durationMillis) {
        log.info("Swiping from ({}, {}) to ({}, {}) over {} ms", startX, startY, endX, endY, durationMillis);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        try {
            driver.perform(Collections.singletonList(swipe));
            log.info("Swipe performed successfully.");
        } catch (Exception e) {
            log.error("Swipe failed: {}", e.getMessage(), e);
            throw new RuntimeException("Swipe failed", e);
        }
    }

    protected void hideKeyboard() {
        try {
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).hideKeyboard();
                log.debug("Keyboard hidden (Android).");
            } else {
                log.debug("Keyboard hide not implemented for iOS.");
            }
        } catch (Exception e) {
            log.warn("Keyboard hide failed: {}", e.getMessage());
        }
    }

    // Wait until element is visible
    private WebElement waitForVisibility(By locator) {
        log.debug("Waiting for visibility of element: {}", locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilClickable(By locator) {
        log.debug("Waiting for element to be clickable: {}", locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void clickByIndex(By locator, int index) {
        log.info("Clicking element at index {} for locator: {}", index, locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        try {
            java.util.List<WebElement> elements = driver.findElements(locator);

            if (elements.size() > index) {
                elements.get(index).click();
                log.info("Clicked element at index {} successfully.", index);
            } else {
                String msg = "No element found at index " + index + ". Total elements: " + elements.size();
                log.error(msg);
                throw new RuntimeException(msg);
            }
        } catch (Exception e) {
            log.error("Failed to click element at index {}: {}", index, e.getMessage(), e);
            throw new RuntimeException("Failed to click element at index " + index, e);
        }
    }
}
