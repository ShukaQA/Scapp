package application.pages;

import application.elements.MobileElement;
import org.openqa.selenium.By;

public class AutoLoanFirstStepPage extends BasePage {

    private final MobileElement amountField = new MobileElement(By.xpath("//*[@resource-id='auto_loan_amount_field']/*"));
    private final MobileElement durationField = new MobileElement(By.xpath("//*[@resource-id='auto_loan_duration_field']/*"));
    private final MobileElement paymentDateButton = new MobileElement(By.xpath("//*[@resource-id='auto_loan_payment_date_dropdown']"));
    private final MobileElement calendarOkayButton = new MobileElement(By.xpath("//*[@content-desc='კარგი']"));
    private final MobileElement chooseFilialDropDown = new MobileElement(By.xpath("//*[@resource-id='auto_loan_branch_dropdown']"));
    private final MobileElement continueBtn = new MobileElement(By.xpath("//*[@content-desc='გაგრძელება']"));

    public void fillLoanAmountField(String amount) {
        logStep("Filling loan amount field with value: " + amount);
        amountField.type(amount);
    }

    public void fillLoanPaymentDurationField(String duration) {
        logStep("Filling loan duration field with value: " + duration);
        durationField.type(duration);
    }

    public void openPaymentCalendar() {
        logStep("Opening payment date calendar.");
        paymentDateButton.click();
    }

    public void clickCalendarOkayButton() {
        logStep("Confirming calendar selection by clicking 'OK'.");
        calendarOkayButton.click();
    }

    public void clickChooseFilialDropDown() {
        logStep("Opening filial dropdown.");
        chooseFilialDropDown.click();
    }

    public void selectOption(String option) {
        logStep("Selecting option '" + option + "' from dropdown.");
        MobileElement optionElement = new MobileElement(By.xpath(String.format("//*[@content-desc='%s']", option)));
        optionElement.click();
    }

    public void clickContinue() {
        logStep("Clicking 'Continue' button.");
        continueBtn.click();
    }

}
