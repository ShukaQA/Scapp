package application.pages;

import application.elements.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final MobileElement usernameField = new MobileElement(By.xpath("//*[@resource-id='login_username_field']/* | //*[@name='login_username_field']"));
    private final MobileElement passwordField = new MobileElement(By.xpath("//*[@resource-id='login_password_field']/* | //*[@name='login_password_field']"));
    private final MobileElement loginBtn = new MobileElement(By.xpath("//*[@*='login_submit_button']"));
    private final MobileElement pinField = new MobileElement(By.xpath("//*[@resource-id='sms_code_field']/* | //*[@name='sms_code_field']"));
    private final MobileElement smsSubmitButton = new MobileElement(By.xpath("//*[@resource-id='sms_submit_button']/* | //*[@name='sms_submit_button']"));
    private final MobileElement allowTrackingIosPopup = new MobileElement(By.xpath("//*[@*='Ask App Not to Track']"));

    public void login(String username, String password, String pin) {
        logStep("Logging in with username: " + username);
        usernameField.type(username);

        logStep("Typing password.");
        passwordField.type(password);

        logStep("Clicking Login button.");
        loginBtn.click();

        logStep("Entering SMS PIN.");
        pinField.type(pin);

        logStep("Clicking SMS Submit button.");
        smsSubmitButton.click();

        logStep("Login flow completed.");
    }

    public void clickAskAppNotToTrackIos() {
        logStep("Click Ask App Not To Track button on IOS popup");
        try {
            allowTrackingIosPopup.click();
        } catch (Exception ignored) {
        }
    }
}
