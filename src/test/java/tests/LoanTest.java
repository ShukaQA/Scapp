package tests;

import application.pages.*;
import base.BaseTest;
import models.AutoLoanTestPojo;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReader;

public class LoanTest extends BaseTest {

    @Test()
    public void testLoan() throws InterruptedException {
        AutoLoanTestPojo data = JsonReader.load("src/test/resources/testData/AutoLoanTestData.json", AutoLoanTestPojo.class);

        LoginPage loginPage = new LoginPage();
        RequestLoanPage requestLoanPage = new RequestLoanPage();
        AutoLoanFirstStepPage autoLoanFirstStepPage = new AutoLoanFirstStepPage();
        AutoLoanSecondStepPage autoLoanSecondStepPage = new AutoLoanSecondStepPage();
        AutoLoanThirdStepPage autoLoanThirdStepPage = new AutoLoanThirdStepPage();

        //Only for IOS
        loginPage.clickAskAppNotToTrackIos();

        autoLoanFirstStepPage.clickContinue();
        autoLoanFirstStepPage.clickContinue();
        loginPage.login(data.login.username, data.login.password, data.login.pin);

        OnboardingPopUpPage onboardingPopUpPage = new OnboardingPopUpPage();
        onboardingPopUpPage.closeOnboardingPopups();

        requestLoanPage.goToLoanPage();
        requestLoanPage.clickAutoLoan();

        autoLoanFirstStepPage.fillLoanAmountField(data.loan.amount);
        autoLoanFirstStepPage.clickChooseFilialDropDown();
        autoLoanFirstStepPage.selectOption(data.loan.filial);
        autoLoanFirstStepPage.openPaymentCalendar();
        autoLoanFirstStepPage.clickCalendarOkayButton();
        autoLoanFirstStepPage.fillLoanPaymentDurationField(data.loan.paymentDuration);
        autoLoanFirstStepPage.clickContinue();

        autoLoanSecondStepPage.clickManufacturerDropdownButton();
        autoLoanSecondStepPage.selectOption(data.car.manufacturer);
        autoLoanSecondStepPage.clickModelDropdownButton();
        autoLoanSecondStepPage.selectOption(data.car.model);
        autoLoanSecondStepPage.clickReleaseYearDropdownButton();
        autoLoanFirstStepPage.selectOption(data.car.year);
        autoLoanSecondStepPage.clickFuelTypeDropdown();
        autoLoanFirstStepPage.selectOption(data.car.fuel);
        autoLoanSecondStepPage.setDistanceInput(data.car.distance);
        autoLoanThirdStepPage.swipeUpScreen(500);
        autoLoanSecondStepPage.clickCustomsClearedDropdown();
        autoLoanFirstStepPage.selectOption(data.car.customsCleared);
        autoLoanFirstStepPage.clickContinue();

        autoLoanThirdStepPage.attachPhotoFromGallery(4);
        Thread.sleep(5000);
        autoLoanThirdStepPage.swipeUpScreen(500);
        autoLoanThirdStepPage.attachPhotoFromGallery(4);
        autoLoanThirdStepPage.submitLoanRequest();

        autoLoanThirdStepPage.swipeUpScreen(350);
        autoLoanThirdStepPage.swipeUpScreen(350);
        autoLoanThirdStepPage.clickISubmitLoanButton();
        autoLoanThirdStepPage.clickLoanHistoryButton();
        Assert.assertTrue(true);

    }

}
