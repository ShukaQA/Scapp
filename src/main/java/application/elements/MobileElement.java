package application.elements;

import core.DeviceInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static drivers.DriverManager.getDriver;

public class MobileElement {

    private static final Logger log = LoggerFactory.getLogger(MobileElement.class);
    private final By locator;
    private final AppiumDriver driver;

    private static final int DEFAULT_TIMEOUT = 5; // seconds


    public MobileElement(By locator) {
        this.locator = locator;
        this.driver = getDriver();
    }

    public void click() {
        log.info("Clicking element: {}", locator);
        waitForClickable().click();
    }

    public void type(String text) {
        log.info("Typing '{}' into element: {}", text, locator);
        WebElement el = waitForVisibility();
        el.click();
        el.clear();
        el.sendKeys(text);
        try {
            hideKeyboardSmart();
        } catch (Exception ignored) {
        }
    }

    protected void hideKeyboardSmart() {
        if (DeviceInfo.isAndroid()) {
            AndroidDriver android = (AndroidDriver) getDriver();
            if (android.isKeyboardShown()) {
                android.hideKeyboard();
                log.debug("Keyboard hidden (Android).");
            }
        } else if (DeviceInfo.isIOS()) {
            IOSDriver ios = (IOSDriver) getDriver();
            if (ios.isKeyboardShown()) {
                ios.findElement(doneButtonIos()).click();
                log.debug("Keyboard hidden (iOS).");
            }
        } else {
            throw new RuntimeException("Unhandled platform '" + DeviceInfo.getPlatformName() + "'");
        }
    }


    public By doneButtonIos() {
        return By.xpath("//XCUIElementTypeButton[contains(@name,'Done')]");
    }

    public WebElement waitForVisibility() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
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

    public By getLocator() {
        return locator;
    }
}
