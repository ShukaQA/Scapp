package application.pages;

import org.openqa.selenium.By;

public class AutoLoanFirstStepPage extends BasePage {

    private final By amountField = By.xpath("//*[@resource-id='auto_loan_amount_field']/*");
    private final By durationField = By.xpath("//*[@resource-id='auto_loan_duration_field']/*");
    private final By paymentDateButton = By.xpath("//*[@resource-id='auto_loan_payment_date_dropdown']");
    private final By calendarOkayButton = By.xpath("//*[@content-desc='კარგი']");
    private final By chooseFilialDropDown = By.xpath("//*[@resource-id='auto_loan_branch_dropdown']");
    private final By continueBtn = By.xpath("//*[@content-desc='გაგრძელება']");

    public void fillLoanAmountField(String amount) {
        type(amountField, amount);
    }

    public void fillLoanPaymentDurationField(String duration) {
        type(durationField, duration);
    }

    public void openPaymentCalendar() {
        click(paymentDateButton);
    }

    public void clickCalendarOkayButton() {
        click(calendarOkayButton);
    }

    public void clickChooseFilialDropDown() {
        click(chooseFilialDropDown);
    }

    public void selectOption(String option) {
        String xpath = String.format("//*[@content-desc='%s']", option);
        click(By.xpath(xpath));
    }

    public void clickContinue() {
        click(continueBtn);
    }


}

