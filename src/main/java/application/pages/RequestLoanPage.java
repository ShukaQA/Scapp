package application.pages;

import application.elements.MobileElement;
import org.openqa.selenium.By;

public class RequestLoanPage extends BasePage {

    private final MobileElement newLoanBtn = new MobileElement(By.xpath("//*[@resource-id='dashboard_new_loan_navigation_button']"));
    private final MobileElement autoLoanBtn = new MobileElement(By.xpath("//*[@resource-id='request_loan_ავტო_სესხი_button']"));
    private final MobileElement notNowBtn = new MobileElement(By.xpath("//*[@resource-id='dashboard_notification_not_now_button']"));
    private final MobileElement closeAuthSetup = new MobileElement(By.xpath("//*[@content-desc='გამოტოვება']"));

    public void goToLoanPage() {
        logStep("Navigating to Loan Page by clicking 'New Loan' button.");
        newLoanBtn.click();
    }

    public void clickAutoLoan() {
        logStep("Clicking 'Auto Loan' button.");
        autoLoanBtn.click();
    }

    public void clickNotNowBtn() {
        logStep("Clicking 'Not Now' button on notification.");
        notNowBtn.click();
    }

    public void clickCloseAuthSetup() {
        logStep("Clicking 'Skip' button to close Auth Setup.");
        closeAuthSetup.click();
    }
}
