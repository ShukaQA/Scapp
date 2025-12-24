package application.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

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

    protected void hideKeyboardSmart() {
        if (Objects.equals(ConfigReader.get("PLATFORM_NAME"), "Android")) {
            if (((AndroidDriver) getDriver()).isKeyboardShown()) {
                ((AndroidDriver) getDriver()).hideKeyboard();
            }
        } else if (Objects.equals(ConfigReader.get("PLATFORM_NAME"), "iOS")) {
            if (((IOSDriver) getDriver()).isKeyboardShown()) {
                getDriver().findElement(doneButtonIos()).click();
            }
        } else {
            throw new RuntimeException("Unhandled platform '" + ConfigReader.get("PLATFORM_NAME") + "'");
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
