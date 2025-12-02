package application.pages;

import org.openqa.selenium.By;

public class AutoLoanThirdStepPage extends BasePage {

    private final By attachPhotoButton = By.xpath("(//*[@content-desc='მიამაგრე ფოტო'])[1]");
    private final By phoneGalleryOption = By.xpath("//*[@content-desc='ტელეფონის გალერეა']");
    private final By firstPhoto = By.xpath("//*[contains(@resource-id, 'thumbnail')]");
    private final By requestLoanButton = By.xpath("//*[@content-desc='მოითხოვე სესხი']");
    private final By iSubmitLoanButton = By.xpath("//*[@resource-id='auto_loan_continue_submit_button']");
    private final By loanHistoryButton = By.xpath("//*[@content-desc='განაცხადების ისტორია']");

    public void attachPhotoFromGallery(int times) {
        for (int i = 0; i < times; i++) {
            waitUntilClickable(attachPhotoButton).click();
            waitUntilClickable(phoneGalleryOption).click();
            clickByIndex(firstPhoto, 1);
        }
    }

    public void scrollToEndOfPage() {
        scrollToEnd();
    }

    public void submitLoanRequest() {
        waitUntilClickable(requestLoanButton).click();
    }

    public void clickISubmitLoanButton() {
        waitUntilClickable(iSubmitLoanButton).click();
    }

    public void clickLoanHistoryButton() {
        waitUntilClickable(loanHistoryButton).click();
    }
}
