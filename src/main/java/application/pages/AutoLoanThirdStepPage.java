package application.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoLoanThirdStepPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AutoLoanThirdStepPage.class);

    private final By attachPhotoButton = By.xpath("(//*[@content-desc='მიამაგრე ფოტო'])[1]");
    private final By phoneGalleryOption = By.xpath("//*[@content-desc='ტელეფონის გალერეა']");
    private final By firstPhoto = By.xpath("//*[contains(@resource-id, 'thumbnail')]");
    private final By requestLoanButton = By.xpath("//*[@resource-id='auto_loan_continue_submit_button']");
    private final By iSubmitLoanButton = By.xpath("//*[@resource-id='auto_loan_credit_info_confirm_button']");
    private final By loanHistoryButton = By.xpath("//*[@content-desc='განაცხადების ისტორია']");

    public void attachPhotoFromGallery(int times) {
        log.info("Attaching {} photo(s) from gallery", times);
        for (int i = 0; i < times; i++) {
            log.info("Attaching photo #{}", i + 1);
            waitUntilClickable(attachPhotoButton).click();
            waitUntilClickable(phoneGalleryOption).click();
            clickByIndex(firstPhoto, 1);
        }
    }

    public void scrollToEndOfPage() {
        log.info("Scrolling to the end of the page");
        scrollToEnd();
    }

    public void submitLoanRequest() {
        log.info("Clicking 'Request Loan' button");
        waitUntilClickable(requestLoanButton).click();
    }

    public void clickISubmitLoanButton() {
        log.info("Clicking 'I Submit Loan' button");
        waitUntilClickable(iSubmitLoanButton).click();
    }

    public void clickLoanHistoryButton() {
        log.info("Clicking 'Loan History' button");
        waitUntilClickable(loanHistoryButton).click();
    }
}
