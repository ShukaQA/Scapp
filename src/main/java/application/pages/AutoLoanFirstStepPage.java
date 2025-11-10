package application.pages;

import org.openqa.selenium.By;

public class AutoLoanFirstStepPage extends BasePage {

    private final By amountField = By.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
    private final By termField = By.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
    private final By paymentDateButton = By.xpath("//android.widget.ScrollView/android.view.View[7]");
    private final By calendarOkayButton = By.xpath("//*[@content-desc='კარგი']");
    private final By chooseFilialDropDown = By.xpath("//android.widget.ScrollView/android.widget.Button[1]");
    private final By continueBtn = By.xpath("//*[@content-desc='გაგრძელება']");

    public void fillLoanAmountField(String amount) {
        type(amountField, amount);
    }

    public void fillLoanPaymentDurationField(String duration) {
        type(termField, duration);
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

