package application.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoLoanFirstStepPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AutoLoanFirstStepPage.class);

    private final By amountField = By.xpath("//*[@resource-id='auto_loan_amount_field']/*");
    private final By durationField = By.xpath("//*[@resource-id='auto_loan_duration_field']/*");
    private final By paymentDateButton = By.xpath("//*[@resource-id='auto_loan_payment_date_dropdown']");
    private final By calendarOkayButton = By.xpath("//*[@content-desc='კარგი']");
    private final By chooseFilialDropDown = By.xpath("//*[@resource-id='auto_loan_branch_dropdown']");
    private final By continueBtn = By.xpath("//*[@content-desc='გაგრძელება']");

    public void fillLoanAmountField(String amount) {
        log.info("Filling loan amount field with value: {}", amount);
        type(amountField, amount);
    }

    public void fillLoanPaymentDurationField(String duration) {
        log.info("Filling loan duration field with value: {}", duration);
        type(durationField, duration);
    }

    public void openPaymentCalendar() {
        log.info("Opening payment date calendar.");
        click(paymentDateButton);
    }

    public void clickCalendarOkayButton() {
        log.info("Confirming calendar selection by clicking 'OK'.");
        click(calendarOkayButton);
    }

    public void clickChooseFilialDropDown() {
        log.info("Opening filial dropdown.");
        click(chooseFilialDropDown);
    }

    public void selectOption(String option) {
        log.info("Selecting option '{}' from dropdown.", option);
        String xpath = String.format("//*[@content-desc='%s']", option);
        log.debug("Generated XPath for option: {}", xpath);
        click(By.xpath(xpath));
    }

    public void clickContinue() {
        log.info("Clicking 'Continue' button.");
        click(continueBtn);
    }
}
