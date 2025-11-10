import application.pages.*;
import drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoanTest {

    @Test
    public void testLoan() {
        LoginPage loginPage = new LoginPage();
        RequestLoanPage requestLoanPage = new RequestLoanPage();
        AutoLoanFirstStepPage autoLoanFirstStepPage = new AutoLoanFirstStepPage();
        AutoLoanSecondStepPage autoLoanSecondStepPage = new AutoLoanSecondStepPage();
        AutoLoanThirdStepPage autoLoanThirdStepPage = new AutoLoanThirdStepPage();

        autoLoanFirstStepPage.clickContinue();
        autoLoanFirstStepPage.clickContinue();
        loginPage.login("gaga", "123", "1234");

        requestLoanPage.clickAgreeBtn();
        requestLoanPage.clickAllow();
        requestLoanPage.goToLoanPage();
        requestLoanPage.clickAutoLoan();

        autoLoanFirstStepPage.fillLoanAmountField("1000");
        autoLoanFirstStepPage.fillLoanPaymentDurationField("5");
        autoLoanFirstStepPage.openPaymentCalendar();
        autoLoanFirstStepPage.clickCalendarOkayButton();
        autoLoanFirstStepPage.clickChooseFilialDropDown();
        autoLoanFirstStepPage.selectOption("პეკინი");
        autoLoanFirstStepPage.clickContinue();

        autoLoanSecondStepPage.clickManufacturerDropdownButton();
        autoLoanSecondStepPage.selectOption("BMW");
        autoLoanSecondStepPage.clickModelDropdownButton();
        autoLoanSecondStepPage.selectOption("X5");
        autoLoanSecondStepPage.clickReleaseYearDropdownButton();
        autoLoanFirstStepPage.selectOption("2004");
        autoLoanSecondStepPage.clickDieselTypeDropdown();
        autoLoanFirstStepPage.selectOption("ბენზინი");
        autoLoanSecondStepPage.setDistanceInput("13000");
        autoLoanThirdStepPage.scrollToEndOfPage();
        autoLoanSecondStepPage.clickCustomsClearedDropdown();
        autoLoanFirstStepPage.selectOption("არა");

        autoLoanFirstStepPage.clickContinue();

        autoLoanThirdStepPage.attachPhotoFromGallery(4);
        autoLoanThirdStepPage.scrollToEndOfPage();
        autoLoanThirdStepPage.attachPhotoFromGallery(4);
        autoLoanThirdStepPage.submitLoanRequest();

        autoLoanThirdStepPage.scrollToEndOfPage();
        autoLoanThirdStepPage.clickISubmitLoanButton();
        autoLoanThirdStepPage.clickLoanHistoryButton();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeApplication();
        DriverManager.quitDriver();
    }
}
