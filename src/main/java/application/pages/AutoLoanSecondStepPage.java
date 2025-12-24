package application.pages;

import application.elements.MobileElement;
import org.openqa.selenium.By;

public class AutoLoanSecondStepPage extends BasePage {

    private final MobileElement manufacturerDropdownButton = new MobileElement(By.xpath("//*[@*='auto_loan_brand_dropdown']"));
    private final MobileElement modelDropdownButton = new MobileElement(By.xpath("//*[@*='auto_loan_model_dropdown']"));
    private final MobileElement releaseYearDropdownButton = new MobileElement(By.xpath("//*[@*='auto_loan_year_dropdown']"));
    private final MobileElement fuelTypeDropdown = new MobileElement(By.xpath("//*[@*='auto_loan_fuel_type_dropdown']"));
    private final MobileElement distanceInput = new MobileElement(By.xpath("//*[@resource-id='auto_loan_mileage_field']/* | //*[@name='auto_loan_mileage_field']"));
    private final MobileElement customsClearedDropdown = new MobileElement(By.xpath("//*[@*='auto_loan_customs_dropdown']"));

    public void clickManufacturerDropdownButton() {
        logStep("Clicking Manufacturer dropdown button");
        manufacturerDropdownButton.click();
    }

    public void selectOption(String carName) {
        logStep("Selecting option '" + carName + "' from dropdown");
        MobileElement optionElement = new MobileElement(
                By.xpath(String.format("//*[@content-desc='%1$s' or @name='%1$s']", carName))
        );
        optionElement.click();
    }

    public void clickModelDropdownButton() {
        logStep("Clicking Model dropdown button");
        modelDropdownButton.click();
    }

    public void clickReleaseYearDropdownButton() {
        logStep("Clicking Release Year dropdown button");
        releaseYearDropdownButton.click();
    }

    public void clickFuelTypeDropdown() {
        logStep("Clicking Fuel Type dropdown");
        fuelTypeDropdown.click();
    }

    public void setDistanceInput(String amount) {
        logStep("Setting Distance (mileage) input field to '" + amount + "'");
        distanceInput.type(amount);
    }

    public void clickCustomsClearedDropdown() {
        logStep("Clicking Customs Cleared dropdown");
        customsClearedDropdown.click();
    }
}
