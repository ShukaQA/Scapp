package application.pages;

import application.elements.MobileElement;
import org.openqa.selenium.By;

public class RequestLoanPage extends BasePage {

    private final MobileElement newLoanBtn = new MobileElement(By.xpath("//*[@*='dashboard_new_loan_navigation_button']"));
    private final MobileElement autoLoanBtn = new MobileElement(By.xpath("//*[@*='request_loan_ავტო_სესხი_button']"));

    public void goToLoanPage() {
        logStep("Navigating to Loan Page by clicking 'New Loan' button.");
        newLoanBtn.click();
    }

    public void clickAutoLoan() {
        logStep("Clicking 'Auto Loan' button.");
        autoLoanBtn.click();
    }


}
