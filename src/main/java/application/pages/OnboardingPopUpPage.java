package application.pages;

import application.elements.MobileElement;
import core.DeviceInfo;
import org.openqa.selenium.By;
import utils.ConfigReader;

import java.util.Objects;

public class OnboardingPopUpPage extends BasePage {
    private final MobileElement notNowBtn = new MobileElement(By.xpath("//*[@*='dashboard_notification_not_now_button']"));
    private final MobileElement closeAuthSetup = new MobileElement(By.xpath("//*[@resource-id='close_auth_setup']/* | //*[@name='გამოტოვება']"));

    private void clickNotNowBtn() {
        logStep("Clicking 'Not Now' button on notification.");
        try {
            notNowBtn.click();
        } catch (Exception ignored) {
        }
    }

    private void clickCloseAuthSetup() {
        logStep("Clicking 'Skip' button to close Auth Setup.");
        try {
            closeAuthSetup.click();
        } catch (Exception ignored) {
        }
    }

    public void closeOnboardingPopups() {
        if (DeviceInfo.isIOS()) {
            clickCloseAuthSetup();
        } else {
            clickNotNowBtn();
            clickCloseAuthSetup();
        }
    }
}
