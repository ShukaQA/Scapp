package application.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.xpath("//*[@resource-id='login_username_field' or @name='login_username_field']/*");
    private final By passwordField = By.xpath("//*[@resource-id='login_password_field' or @name='login_password_field']/*");
    private final By loginBtn = By.xpath("//*[@resource-id='login_submit_button' or @name='login_submit_button']");
    private final By pinField = By.xpath("//*[@resource-id='sms_code_field']/*");
    private final By smsSubmitButton = By.xpath("//*[@content-desc='შესვლა']");

    public void login(String username, String password, String pin) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginBtn);
        type(pinField, pin);
        click(smsSubmitButton);
    }
}
