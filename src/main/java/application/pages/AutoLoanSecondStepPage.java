package application.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoLoanSecondStepPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AutoLoanSecondStepPage.class);

    private final By manufacturerDropdownButton = By.xpath("//*[@resource-id='auto_loan_brand_dropdown']");
    private final By modelDropdownButton = By.xpath("//*[@resource-id='auto_loan_model_dropdown']");
    private final By releaseYearDropdownButton = By.xpath("//*[@resource-id='auto_loan_year_dropdown']");
    private final By fuelTypeDropdown = By.xpath("//*[@resource-id='auto_loan_fuel_type_dropdown']");
    private final By distanceInput = By.xpath("//*[@resource-id='auto_loan_mileage_field']/*");
    private final By customsClearedDropdown = By.xpath("//*[@resource-id='auto_loan_customs_dropdown']");

    public void clickManufacturerDropdownButton() {
        log.info("Clicking Manufacturer dropdown button");
        click(manufacturerDropdownButton);
    }

    public void selectOption(String carName) {
        log.info("Selecting option '{}'", carName);
        String xpath = String.format("//*[@content-desc='%s']", carName);
        click(By.xpath(xpath));
    }

    public void clickModelDropdownButton() {
        log.info("Clicking Model dropdown button");
        click(modelDropdownButton);
    }

    public void clickReleaseYearDropdownButton() {
        log.info("Clicking Release Year dropdown button");
        click(releaseYearDropdownButton);
    }

    public void clickFuelTypeDropdown() {
        log.info("Clicking Fuel Type dropdown");
        click(fuelTypeDropdown);
    }

    public void setDistanceInput(String amount) {
        log.info("Setting Distance (mileage) input field to '{}'", amount);
        type(distanceInput, amount);
    }

    public void clickCustomsClearedDropdown() {
        log.info("Clicking Customs Cleared dropdown");
        click(customsClearedDropdown);
    }
}
