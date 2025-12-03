import application.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanTest {

    @Test
    public void testLoan() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        RequestLoanPage requestLoanPage = new RequestLoanPage();
        AutoLoanFirstStepPage autoLoanFirstStepPage = new AutoLoanFirstStepPage();
        AutoLoanSecondStepPage autoLoanSecondStepPage = new AutoLoanSecondStepPage();
        AutoLoanThirdStepPage autoLoanThirdStepPage = new AutoLoanThirdStepPage();

        autoLoanFirstStepPage.clickContinue();
        autoLoanFirstStepPage.clickContinue();
        loginPage.login("gaga", "123", "1234");

        requestLoanPage.clickNotNowBtn();
        requestLoanPage.clickCloseAuthSetup();

        requestLoanPage.goToLoanPage();
        requestLoanPage.clickAutoLoan();

        autoLoanFirstStepPage.fillLoanAmountField("1000");
        autoLoanFirstStepPage.clickChooseFilialDropDown();
        autoLoanFirstStepPage.selectOption("პეკინი");
        autoLoanFirstStepPage.openPaymentCalendar();
        autoLoanFirstStepPage.clickCalendarOkayButton();
        autoLoanFirstStepPage.fillLoanPaymentDurationField("5");
        autoLoanFirstStepPage.clickContinue();

        autoLoanSecondStepPage.clickManufacturerDropdownButton();
        autoLoanSecondStepPage.selectOption("BMW");
        autoLoanSecondStepPage.clickModelDropdownButton();
        autoLoanSecondStepPage.selectOption("X5");
        autoLoanSecondStepPage.clickReleaseYearDropdownButton();
        autoLoanFirstStepPage.selectOption("2004");
        autoLoanSecondStepPage.clickFuelTypeDropdown();
        autoLoanFirstStepPage.selectOption("ბენზინი");
        autoLoanSecondStepPage.setDistanceInput("13000");
        autoLoanThirdStepPage.swipeUpScreen();
        autoLoanSecondStepPage.clickCustomsClearedDropdown();
        autoLoanFirstStepPage.selectOption("არა");
        autoLoanFirstStepPage.clickContinue();

        autoLoanThirdStepPage.attachPhotoFromGallery(4);
        Thread.sleep(5000);
        autoLoanThirdStepPage.swipeUpScreen();
        autoLoanThirdStepPage.attachPhotoFromGallery(4);
        autoLoanThirdStepPage.submitLoanRequest();

        autoLoanThirdStepPage.swipeUpScreen();
        autoLoanThirdStepPage.clickISubmitLoanButton();
        autoLoanThirdStepPage.clickLoanHistoryButton();
        Assert.assertTrue(true);

    }
}
