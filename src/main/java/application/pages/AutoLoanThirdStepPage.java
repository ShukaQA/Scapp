package application.pages;

import org.openqa.selenium.By;

public class AutoLoanThirdStepPage extends BasePage {

    private final By attachPhotoButton = By.xpath("(//*[@content-desc='მიამაგრე ფოტო'])[1]");
    private final By phoneGalleryOption = By.xpath("//*[@content-desc='ტელეფონის გალერეა']");
    private final By firstPhoto = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View");
    private final By requestLoanButton = By.xpath("//android.widget.Button[@content-desc='მოითხოვე სესხი']");
    private final By iSubmitLoanButton = By.xpath("//*[@content-desc='ვადასტურებ']");
    private final By loanHistoryButton = By.xpath("//*[@content-desc='განაცხადების ისტორია']");

    public void attachPhotoFromGallery(int times) {
        for (int i = 0; i < times; i++) {
            waitUntilClickable(attachPhotoButton).click();
            waitUntilClickable(phoneGalleryOption).click();
            waitUntilClickable(firstPhoto).click();
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
