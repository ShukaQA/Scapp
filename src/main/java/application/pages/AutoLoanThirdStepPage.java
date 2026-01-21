package application.pages;

import application.elements.MobileElement;
import core.MobileActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class AutoLoanThirdStepPage extends BasePage {

    private final MobileElement attachPhotoButton = new MobileElement(By.xpath("(//*[@*='მიამაგრე ფოტო'])[1]"));
    private final MobileElement phoneGalleryOption = new MobileElement(By.xpath("//*[@*='ტელეფონის გალერეა']"));
    private final MobileElement firstPhoto = new MobileElement(By.xpath("//*[contains(@resource-id, 'thumbnail')] | //XCUIElementTypeImage[contains(@name,'Photo')]"));
    private final MobileElement requestLoanButton = new MobileElement(By.xpath("//*[@*='auto_loan_continue_submit_button']"));
    private final MobileElement iSubmitLoanButton = new MobileElement(By.xpath("//*[@*='auto_loan_credit_info_confirm_button']"));
    private final MobileElement loanHistoryButton = new MobileElement(By.xpath("//*[@*='განაცხადების ისტორია']"));

    private final MobileActions actions = new MobileActions();

    public void attachPhotoFromGallery(int times) {
        logStep("Attaching " + times + " photo(s) from gallery");
        for (int i = 0; i < times; i++) {
            logStep("Attaching photo #" + (i + 1));
            attachPhotoButton.click();
            phoneGalleryOption.click();
            firstPhoto.clickByIndex(1);
        }
    }

    public void submitLoanRequest() {
        logStep("Clicking 'Request Loan' button");
        requestLoanButton.click();
    }

    public void clickISubmitLoanButton() {
        logStep("Clicking 'I Submit Loan' button");
        iSubmitLoanButton.click();
    }

    public void clickLoanHistoryButton() {
        logStep("Clicking 'Loan History' button");
        loanHistoryButton.click();
    }

    public void swipeUpScreen(int speed) {
        logStep("Swiping up the screen.");

        Dimension size = driver.manage().window().getSize();
        actions.swipe(
                size.width / 2,
                (int) (size.height * 0.75),
                size.width / 2,
                10,
                speed
        );
    }
}
