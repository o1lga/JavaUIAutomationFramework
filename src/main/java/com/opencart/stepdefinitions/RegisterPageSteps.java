package com.opencart.stepdefinitions;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the Register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Olga", "Cosneanu", randomEmail, "Password1234!");

    }

    @And("the Privacy Toggle bar is enabled")
    public void thePrivacyToggleBarIsEnabled() {
        registerPage.enablePrivacyToggle();
    }

    @When("the continueButton is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnContinueButton();
    }
}
