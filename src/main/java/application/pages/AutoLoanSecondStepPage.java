package application.pages;

import org.openqa.selenium.By;

public class AutoLoanSecondStepPage extends BasePage {

    private final By manufacturerDropdownButton = By.xpath("//android.widget.ScrollView/android.view.View[2]");
    private final By modelDropdownButton = By.xpath("//android.widget.ScrollView/android.view.View[4]");
    private final By releaseYearDropdownButton  = By.xpath("//*[@content-desc='გამოშვების წელი:']");
    private final By dieselTypeDropdown = By.xpath("//*[@content-desc='საწვავის ტიპი:']");
    private final By distanceInput = By.xpath("//*[@hint='გარბენი:']");
    private final By customsClearedDropdown = By.xpath("//*[@content-desc='განბაჟებული:']");

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


    public void clickDieselTypeDropdown() {
        click(dieselTypeDropdown);
    }

    public void setDistanceInput(String amount) {
        type(distanceInput, amount);
    }

    public void clickCustomsClearedDropdown() {
        click(customsClearedDropdown);
    }


}
