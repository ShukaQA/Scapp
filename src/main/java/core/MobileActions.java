package core;

import drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

import org.slf4j.Logger;
import utils.LoggerHelper;

public class MobileActions {

    private final AppiumDriver driver;
    protected final Logger log = LoggerHelper.getLogger(this.getClass());

    public MobileActions() {
        this.driver = DriverManager.getDriver();
    }

    public void swipe(int startX, int startY, int endX, int endY, long durationMillis) {
        log.info(String.format("Swiping from (%d,%d) to (%d,%d) over %d ms", startX, startY, endX, endY, durationMillis));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

}
