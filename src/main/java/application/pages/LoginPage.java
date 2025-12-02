package application.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private final By usernameField = By.xpath("//*[@resource-id='login_username_field' or @name='login_username_field']/*");
    private final By passwordField = By.xpath("//*[@resource-id='login_password_field' or @name='login_password_field']/*");
    private final By loginBtn = By.xpath("//*[@resource-id='login_submit_button' or @name='login_submit_button']");
    private final By pinField = By.xpath("//*[@resource-id='sms_code_field']/*");
    private final By smsSubmitButton = By.xpath("//*[@content-desc='შესვლა']");

    public void login(String username, String password, String pin) {
        log.info("Logging in with username: {}", username);
        type(usernameField, username);

        log.info("Typing password.");
        type(passwordField, password);

        log.info("Clicking Login button.");
        click(loginBtn);

        log.info("Entering SMS PIN.");
        type(pinField, pin);

        log.info("Clicking SMS Submit button.");
        click(smsSubmitButton);

        log.info("Login flow completed.");
    }
}
