package application.pages;

import org.openqa.selenium.By;

public class RequestLoanPage extends BasePage {

    private final By newLoanBtn = By.xpath("//*[@content-desc='ახალი სესხი']");
    private final By autoLoanBtn = By.xpath("//*[@content-desc='ავტო სესხი']");
    private final By agreeBtn = By.xpath("//*[@content-desc='ვეთანხმები']");
    private final By allow = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']");

    public void goToLoanPage() {
        click(newLoanBtn);
    }

    public void clickAutoLoan() {
        click(autoLoanBtn);
    }

    public void clickAgreeBtn() { click(agreeBtn); }
    public void clickAllow() { click(allow); }
}
