package application.pages;

import org.openqa.selenium.By;

public class AutoLoanSecondStepPage extends BasePage {

    private final By manufacturerDropdownButton = By.xpath("//*[@resource-id='auto_loan_brand_dropdown']");
    private final By modelDropdownButton = By.xpath("//*[@resource-id='auto_loan_model_dropdown']");
    private final By releaseYearDropdownButton = By.xpath("//*[@resource-id='auto_loan_year_dropdown']");
    private final By fuelTypeDropdown = By.xpath("//*[@resource-id='auto_loan_fuel_type_dropdown']");
    private final By distanceInput = By.xpath("//*[@resource-id='auto_loan_mileage_field']/*");
    private final By customsClearedDropdown = By.xpath("//*[@resource-id='auto_loan_customs_dropdown']");

    public void clickManufacturerDropdownButton() {
        click(manufacturerDropdownButton);
    }

    public void selectOption(String carName) {
        String xpath = String.format("//*[@content-desc='%s']", carName);
        click(By.xpath(xpath));
    }

    public void clickModelDropdownButton() {
        click(modelDropdownButton);
    }

    public void clickReleaseYearDropdownButton() {
        click(releaseYearDropdownButton);
    }

    public void clickFuelTypeDropdown() {
        click(fuelTypeDropdown);
    }

    public void setDistanceInput(String amount) {
        type(distanceInput, amount);
    }

    public void clickCustomsClearedDropdown() {
        click(customsClearedDropdown);
    }


}
