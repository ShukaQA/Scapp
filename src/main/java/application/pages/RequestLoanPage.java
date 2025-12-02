package application.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLoanPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(RequestLoanPage.class);

    private final By newLoanBtn = By.xpath("//*[@resource-id='dashboard_new_loan_navigation_button']");
    private final By autoLoanBtn = By.xpath("//*[@resource-id='request_loan_ავტო_სესხი_button']");
    private final By notNowBtn = By.xpath("//*[@resource-id='dashboard_notification_not_now_button']");
    private final By closeAuthSetup = By.xpath("//*[@content-desc='გამოტოვება']");

    public void goToLoanPage() {
        log.info("Navigating to Loan Page by clicking 'New Loan' button.");
        click(newLoanBtn);
    }

    public void clickAutoLoan() {
        log.info("Clicking 'Auto Loan' button.");
        click(autoLoanBtn);
    }

    public void clickNotNowBtn() {
        log.info("Clicking 'Not Now' button on notification.");
        click(notNowBtn);
    }

    public void clickCloseAuthSetup() {
        log.info("Clicking 'Skip' button to close Auth Setup.");
        click(closeAuthSetup);
    }
}
