package application.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.xpath("//android.view.View[@content-desc='ავტორიზაცია']/android.view.View/android.widget.EditText[1]");
    private final By passwordField = By.xpath("//android.view.View[@content-desc='ავტორიზაცია']/android.view.View/android.widget.EditText[2]");
    private final By loginBtn = By.xpath("//*[@content-desc='შესვლა']");
    private final By pinField = By.xpath("//*[@hint='ერთჯერადი კოდი:']");

    public void login(String username, String password, String pin) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginBtn);
        type(pinField, pin);
        click(loginBtn);
    }
}
