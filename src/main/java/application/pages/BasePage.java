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

import java.time.Duration;
import java.util.Collections;

import static drivers.DriverManager.getDriver;

public class BasePage {
    protected AppiumDriver driver;
    private final int TIMEOUT = 15; // seconds

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    protected void click(By locator) {
        waitForVisibility(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = waitForVisibility(locator);
        el.click();
        el.clear();
        hideKeyboard();
        el.sendKeys(text);

    }

    protected void scrollToEnd() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
        ));
    }

    public void scrollDownToBottom() {
        Dimension size = getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height / 2);
        int endY   = (int) (size.height);
        System.out.println(startX);
        System.out.println(startY);
        System.out.println(endY);
        swipe(startX, startY, startX, endY, 600);
    }

    public void swipe(int startX, int startY, int endX, int endY, long durationMillis) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        // Move to start point
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        // Press down
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // Move to end point over duration
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        // Release finger
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the swipe
        driver.perform(Collections.singletonList(swipe));
    }

    protected void hideKeyboard() {
        // Hide keyboard depending on platform
        try {
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).hideKeyboard();
            } else { // iOS
                // TODO add for IOS
            }
        } catch (Exception e) {
            System.out.println("Keyboard hide failed: " + e.getMessage());
        }
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

    protected void clickByIndex(By locator, int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        // Wait until at least one element is visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        try {
            // Find all elements
            java.util.List<WebElement> elements = driver.findElements(locator);

            if (elements.size() > index) {
                elements.get(index).click();
            } else {
                throw new RuntimeException("No element found at index " + index + ". Total elements: " + elements.size());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to click element at index " + index + ": " + e.getMessage(), e);
        }
    }
}
