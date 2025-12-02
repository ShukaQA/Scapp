package application.pages;

import org.openqa.selenium.By;

public class RequestLoanPage extends BasePage {

    private final By newLoanBtn = By.xpath("//*[@resource-id='dashboard_new_loan_navigation_button']");
    private final By autoLoanBtn = By.xpath("//*[@resource-id='request_loan_ავტო_სესხი_button']");
    private final By agreeBtn = By.xpath("//*[@resource-id='dashboard_notification_accept_button']");
    private final By notNowBtn = By.xpath("//*[@resource-id='dashboard_notification_not_now_button']");
    private final By allow = By.xpath("//*[@text='Allow']");
    private final By closeAuthSetup = By.xpath("//*[@content-desc='გამოტოვება']");

    public void goToLoanPage() {
        click(newLoanBtn);
    }

    public void clickAutoLoan() {
        click(autoLoanBtn);
    }

    public void clickAgreeBtn() {
        click(agreeBtn);
    }

    public void clickNotNowBtn() {
        click(notNowBtn);
    }

    public void clickAllow() {
        click(allow);
    }

    public void clickCloseAuthSetup() {
        click(closeAuthSetup);
    }
}
