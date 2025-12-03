package application.elements;

import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class MobileElement {

    private static final Logger log = LoggerFactory.getLogger(MobileElement.class);
    private final By locator;
    private final AppiumDriver driver;

    private static final int DEFAULT_TIMEOUT = 15; // seconds


    public MobileElement(By locator) {
        this.locator = locator;
        this.driver = DriverManager.getDriver();
    }

    public void click() {
        log.info("Clicking element: {}", locator);
        waitForVisibility().click();
    }

    public void type(String text) {
        log.info("Typing '{}' into element: {}", text, locator);
        WebElement el = waitForVisibility();
        el.click();
        el.clear();
        el.sendKeys(text);
        hideKeyboard();
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

    public WebElement waitForVisibility() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(driver -> driver.findElement(locator));
    }

    public void clickByIndex(int index) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() > index) {
            elements.get(index).click();
            log.info("Clicked element at index {} successfully.", index);
        } else {
            throw new RuntimeException("No element found at index " + index);
        }
    }

    public void waitForElementToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        try {
            log.info("Waiting for Element to appear...");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            log.info("Element did not appear, proceeding...");
        }

        log.info("Waiting for Element to disappear...");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        log.info("Element has disappeared.");
    }

    public By getLocator() {
        return locator;
    }
}
